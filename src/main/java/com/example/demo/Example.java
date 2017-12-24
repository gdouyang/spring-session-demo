package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

	@RequestMapping("/add/{name}/{value}")
	public void add(@PathVariable(name = "name") String name, @PathVariable(name = "value") String value,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	@RequestMapping("/get/{name}")
	public String doGet(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {

		// 使用正常的servlet API获取session，在底层，
		// session是通过Spring Session得到的，并且会存储到Redis或
		// 其他你所选择的数据源中

		HttpSession session = request.getSession();
		String value = (String) session.getAttribute(name);
		return value;
	}
}