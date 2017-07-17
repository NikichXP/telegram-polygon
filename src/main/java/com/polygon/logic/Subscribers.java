package com.polygon.logic;

import com.polygon.AppLoader;
import com.polygon.entity.SubscriberInfo;
import com.polygon.repo.SubscriberInfoRepo;
import lombok.val;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.polygon.util.Async.async;

public class Subscribers {
	
	/**
	 * Key = project, value: list: key: userID, value: level of alerting
	 */
	private static HashMap<String, Map<String, Integer>> subscribers = new HashMap<>();
	private static SubscriberInfoRepo repo;
	
	static {
		async(() -> {
			repo = AppLoader.get(SubscriberInfoRepo.class);
			repo.findAll().forEach(entry -> subscribeWork(entry.getApp(), entry.getUser(), entry.getLevel(), true));
		});
	}
	
	public static List<String> notifyList (String appId, Integer level) {
		if (subscribers.get(appId) == null) {
			return new ArrayList<>();
		}
		return subscribers.get(appId).keySet().stream().filter(user -> canHear(appId, user, level)).collect(Collectors.toList());
	}
	
	private static boolean canHear (String app, String user, Integer level) {
		return subscribers.get(app) != null && subscribers.get(app).get(user) != null && subscribers.get(app).get(user) >= level;
	}
	
	private static void subscribeWork (String app, String user, Integer level, boolean safe) {
		if (subscribers.get(app) == null) {
			if (safe) {
				validateAppExist(app);
			}
			return;
		}
		subscribers.get(app).put(user, level);
		if (!safe) {
			async(() -> {
				SubscriberInfo info = Optional.ofNullable(repo.findOne(app + "::" + user))
					.orElse(new SubscriberInfo(app, user, level));
				info.setLevel(level);
				repo.save(info);
			});
		}
	}
	
	public static void subscribe (String app, String user, Integer level) {
		subscribeWork(app, user, level, false);
	}
	
	public static void validateAppExist (String app) {
		subscribers.putIfAbsent(app, new ConcurrentHashMap<>());
	}
	
}
