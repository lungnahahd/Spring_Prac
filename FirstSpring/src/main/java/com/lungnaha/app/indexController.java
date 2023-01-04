package com.lungnaha.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class indexController {
	@GetMapping("index")
	public String indexForm() {
		return "index";
	}
}
