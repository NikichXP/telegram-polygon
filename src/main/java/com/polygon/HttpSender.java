package com.polygon;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpSender {

	public static String get(String path) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet req = new HttpGet(path);
		CloseableHttpResponse response = null;
		try {
			response = client.execute(req);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String post (String path, String... args) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(path);
		try {
			CloseableHttpResponse response = null;
			List<NameValuePair> urlParameters = new ArrayList<>();
			for (int i = 0; i < args.length/2; i++) {
				urlParameters.add(new BasicNameValuePair(args[i*2], args[i*2 + 1]));
			}
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			response = client.execute(post);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
