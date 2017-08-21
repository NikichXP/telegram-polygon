package com.polygon.api;

import com.polygon.logic.Subscribers;
import com.polygon.util.TelegramBotMethods;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api")
public class ExternalAPI {
	
	@RequestMapping ("/log/{app}")
	public ResponseEntity log (@PathVariable ("app") String app,
	                           @RequestParam ("message") String message,
	                           @RequestParam ("level") Integer level) {
		Subscribers.notifyList(app, level).parallelStream().forEach(user -> TelegramBotMethods.sendMessage(user, message));
		return ResponseEntity.ok("OK");
	}
	
	@RequestMapping ("/reg/{app}")
	public ResponseEntity registerApp (@PathVariable ("app") String app,
	                                   @RequestParam ("url") String url) {
		Subscribers.setCallbackUrl(app, url);
		return ResponseEntity.ok("OK");
	}
	
}

// TODO reg/app must receive token
