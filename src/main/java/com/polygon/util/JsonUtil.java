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
	
	public static JsonUtil of (String json) {
		return new JsonUtil(json);
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
	
	public JsonUtil getJson (String name) {
		return new JsonUtil(json.getAsJsonObject(name));
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
				ret = ret.getJson(part[i]);
			}
		}
		return ret.json.get(part[part.length - 1]).toString();
	}
	
	public String get (String name) {
		String ret = getX(name);
		if (ret.startsWith("\"") && ret.endsWith("\"")) {
			ret = ret.substring(1, ret.length() - 1);
		}
		return ret;
	}
	
	@Override
	public String toString () {
		return json.toString();
	}
	
	
}
