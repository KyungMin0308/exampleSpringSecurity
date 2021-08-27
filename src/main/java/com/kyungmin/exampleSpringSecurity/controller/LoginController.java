package com.kyungmin.exampleSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		// 잘못된 로그인 정보 입력 시 에러 메시지 출력
		if (error != null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		}

		// 잘못된 로그인 정보 입력 시 에러 메시지 출력
		if (logout != null) {
			model.addAttribute("logoutMsg", "Logged Out Successfully.");
		}

		return "login";
	}

}
