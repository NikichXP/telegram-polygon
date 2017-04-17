package com.polygon.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
public class UnifiedRequestHandler {

	@RequestMapping("/")
	public ResponseEntity echo(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		sb.append("path = / ");
		req.getParameterMap()
				.forEach((arg, val) -> sb.append("; arg ").append(arg)
						.append(" = ").append(Arrays.toString(val)));
		System.out.println(sb.toString());
		return ResponseEntity.ok(sb.toString());
	}

	@RequestMapping("/{whatever}")
	public ResponseEntity echo(HttpServletRequest req, @PathVariable("whatever") String whatever) {
		StringBuilder sb = new StringBuilder();
		sb.append("path = " + whatever);
		req.getParameterMap()
				.forEach((arg, val) -> sb.append("; arg ").append(arg)
						.append(" = ").append(Arrays.toString(val)));
		System.out.println(sb.toString());
		return ResponseEntity.ok(sb.toString());
	}

	@RequestMapping("/{whatever}/{else}")
	public ResponseEntity echo(HttpServletRequest req,
	                           @PathVariable("whatever") String whatever,
	                           @PathVariable("else") String _else) {
		StringBuilder sb = new StringBuilder();
		sb.append("path = " + whatever + " / " + _else);
		req.getParameterMap()
				.forEach((arg, val) -> sb.append("; arg ").append(arg)
						.append(" = ").append(Arrays.toString(val)));
		System.out.println(sb.toString());
		return ResponseEntity.ok(sb.toString());
	}
}
