package com.polygon.util;

import com.polygon.AppLoader;

import static com.polygon.util.Async.async;

public class TelegramBotMethods {

	private static final String BASE_URL;

	static {
		BASE_URL = "https://api.telegram.org/bot" + AppLoader.getProperty("telegram.bot.token") + "/";
        async(() -> HttpSender.get(BASE_URL + "setWebhook?url=" + AppLoader.getProperty("telegram.bot.host")));
	}

	public static String sendMessage (String chatId, String text) {
		return HttpSender.post(BASE_URL + "sendMessage", "chat_id", chatId, "text", text);
	}

}
