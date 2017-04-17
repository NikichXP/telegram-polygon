package com.polygon.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestAPI {

	@GetMapping("/ping")
	public ResponseEntity ping() {
		return ResponseEntity.ok("OK");
	}

}
