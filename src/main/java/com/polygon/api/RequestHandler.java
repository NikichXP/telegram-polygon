package com.polygon.api;

import com.polygon.util.TelegramInputParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@RestController
public class RequestHandler {

	@RequestMapping("/telegram")
	public void listen(HttpServletRequest req) throws IOException {
		String x = new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8))
				.lines().reduce((s1, s2) -> s1 + s2).orElse("");
		x = new String(x.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(x);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) != '\\') {
				sb.append(x.charAt(i));
			} else {
				if (x.charAt(i + 1) == 'u') {
					int charCode = Integer.parseInt(x.substring(i + 2, i + 6), 16);
					sb.append(Character.toChars(charCode));
				}
				i += 5;
			}
		}
		System.out.println(sb.toString());
		try {
			TelegramInputParser.analyze(sb.toString());
		} catch (Exception e) {
			System.out.println(sb.toString());
		}

	}
	
	@RequestMapping ("/github")
	public ResponseEntity github (HttpServletRequest req) throws IOException {
		System.out.println("This is JSON req:" + new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8))
				.lines().reduce((s1, s2) -> s1 + s2).orElse(""));
		System.out.print("This is request params: ");
		req.getParameterMap().forEach((k, v) -> System.out.print(k + " : " + Arrays.toString(v) + "; "));
		return ResponseEntity.ok(null);
	}

}
