package com.polygon.logic;

import com.polygon.entity.Message;
import com.polygon.util.TelegramBotMethods;

public class Router {

	public static void routeMsg(Message message) {
		switch (message.getText().split(" ")[0]) {
			case "plan":
				break;
			case "/register":
			case "/subscribe":
				TelegramBotMethods.sendMessage(message.getSenderId(), "Register detected:" + message.getText());
				ResponseLogic.subscribeLogs(message.getText().split(" ")[1], message.getText().split(" ")[2], message.getText().split(" ")[3]);
			case "/myid":
				System.out.println("My ID requested");
				ResponseLogic.getMyId(message);
				break;
			default:
				TelegramBotMethods.sendMessage(message.getSenderId(), message.getText());
				break;
		}
	}

}
