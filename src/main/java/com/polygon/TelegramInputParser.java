package com.polygon;

import com.google.gson.JsonParser;
import com.polygon.entity.Message;

public class TelegramInputParser {

	public static Object analyze(String s) {
		return new Message(new JsonParser().parse(s).getAsJsonObject().get("message").getAsJsonObject());
	}

}
