package com.ishan.security.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ishan.security.demo.domain.User;
import com.ishan.security.demo.service.AdminService;

@Controller
public class DashboardController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap map) {
		map.put("user", user);
		adminService.getAllUserAccounts();
		return "dashboard";
	}
	
	
}
