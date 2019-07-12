package com.leaolabs.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaolabs.tarefas.repositorios.TarefaRepository;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepositorio;

	@GetMapping("/listar")
	public ModelAndView listar() {
		var mv = new ModelAndView();
		mv.setViewName("tarefas/listar");
		mv.addObject("tarefas", tarefaRepositorio.findAll());
		return mv;
	}

}
