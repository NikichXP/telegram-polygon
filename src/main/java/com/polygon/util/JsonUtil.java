package com.polygon.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

import java.util.Arrays;

@Data
public class JsonUtil {
	
	public JsonObject json;
	
	public JsonUtil (String src) {
		json = new JsonParser().parse(src).getAsJsonObject();
	}
	
	public JsonUtil (JsonObject json) {
		this.json = json;
	}
	
	/**
	 * Get array index
	 *
	 * @param name member, like 'routes[0]'
	 * @return JsonObject of this
	 */
	public JsonUtil arr (String name) {
		System.out.println(json);
		JsonElement jse = json.get(
				name.substring(0, name.indexOf('[')))
				.getAsJsonArray()
				.get(Integer.parseInt(name.substring(name.indexOf('[') + 1, name.indexOf(']'))));
		
		return new JsonUtil(jse
				.getAsJsonObject());
	}
	
	public JsonUtil get (String name) {
		return new JsonUtil(json.getAsJsonObject(name));
	}
	
	public static JsonUtil of (String json) {
		return new JsonUtil(json);
	}
	
	public String getX (String name) {
		String[] part = name.split("\\.");
		System.out.println(Arrays.toString(part));
		JsonUtil ret = this;
		for (int i = 0; i < part.length - 1; i++) {
			System.out.println(part[i]);
			if (part[i].contains("[")) {
				ret = ret.arr(part[i]);
			} else {
				ret = ret.get(part[i]);
			}
		}
		return ret.json.get(part[part.length-1]).toString();
	}
	
	@Override
	public String toString() {
		return json.toString();
	}
	
	
}
