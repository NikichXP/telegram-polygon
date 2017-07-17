package com.polygon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class SubscriberInfo {
	
	@Id
	private String id;
	private String app, user;
	private int level;
	
	public SubscriberInfo(String app, String user) {
		this.id = app + "::" + user;
		this.app = app;
		this.user = user;
	}
	
	public SubscriberInfo(String app, String user, int level) {
		this(app, user);
		this.level = level;
	}
}
