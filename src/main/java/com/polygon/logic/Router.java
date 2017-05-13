package com.polygon.logic;

import com.polygon.entity.Message;
import com.polygon.util.TelegramBotMethods;

public class Router {

	public static void routeMsg(Message message) {
		switch (message.getText().split(" ")[0]) {
			case "plan":
				break;
				
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
