package com.ishan.security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LearningTest {

	@Test
	public void password_encoder() {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String epw = pe.encode("123456");
		System.out.println(epw);
	}
}
