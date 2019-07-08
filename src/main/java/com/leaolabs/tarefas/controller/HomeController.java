package com.leaolabs.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("home/home");
		modelView.addObject("mensagem", "Mensagem do Controller");
		return modelView;
	}
}
