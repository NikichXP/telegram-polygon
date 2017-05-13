package com.polygon.logic;

import com.polygon.entity.Message;
import com.polygon.util.TelegramBotMethods;

public class ResponseLogic {
	
	public static void getMyId (Message message) {
		
		TelegramBotMethods.sendMessage(message.getSenderId(), "Your ID is: " + message.getSenderId());
		
	}
	
}
