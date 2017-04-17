package com.polygon.entity;

import com.google.gson.JsonObject;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Message {

	@Id
	private String id;
	private String text;
	private String senderId;

	public Message(JsonObject textMessageJson) {
		this.text = textMessageJson.get("text").getAsString();
		this.id = textMessageJson.get("chat").getAsJsonObject().get("id")
				.getAsString() + "_" + textMessageJson.get("message_id");
		this.senderId = textMessageJson.get("from").getAsJsonObject().get("id").getAsString();
	}
}
