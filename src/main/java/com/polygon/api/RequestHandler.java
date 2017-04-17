package com.polygon.api;

import com.polygon.util.TelegramInputParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class RequestHandler {

	@RequestMapping("/")
	public void listen(HttpServletRequest req) throws IOException {
		new BufferedReader(new InputStreamReader(req.getInputStream()))
				.lines().reduce((s1, s2) -> s1 + s2).ifPresent(TelegramInputParser::analyze);
	}

}
