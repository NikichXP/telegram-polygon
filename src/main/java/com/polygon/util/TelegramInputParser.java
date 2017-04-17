package com.polygon.util;

import com.google.gson.JsonParser;
import com.polygon.entity.Message;
import com.polygon.logic.Router;

public class TelegramInputParser {

	public static void analyze(String s) {
		try {
			Router.routeMsg(new Message(new JsonParser().parse(s).getAsJsonObject().get("message").getAsJsonObject()));
		} catch (NullPointerException e) {
			TelegramBotMethods.sendMessage("34080460", "error on parse: " + s);
		}
	}

}
