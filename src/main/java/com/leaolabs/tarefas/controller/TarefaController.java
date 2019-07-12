package com.leaolabs.tarefas.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leaolabs.tarefas.model.Tarefa;
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

	@GetMapping("/inserir")
	public ModelAndView inserir() {
		var mv = new ModelAndView();
		mv.setViewName("tarefas/inserir");
		mv.addObject("tarefa", new Tarefa());
		return mv;
	}

	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Tarefa tarefa, BindingResult result) {
		var mv = new ModelAndView();

		if (tarefa.getDataExpiracao() == null) {
			result.rejectValue("dataExpiracao", "tarefas.dataNull", "A data de expiração não pode ser null");
		} else if (tarefa.getDataExpiracao().before(new Date())) {
			result.rejectValue("dataExpiracao", "tarefas.dataExpiracaoInvalida",
					"A data de expiração não pode ser menor que a data atual");
		} else if (result.hasErrors()) {
			mv.setViewName("/tarefas/inserir");
			mv.addObject(tarefa);
		} else {
			mv.setViewName("redirect:/tarefas/listar");
			tarefaRepositorio.save(tarefa);
		}
		return mv;
	}
	
	// parou no 1:25:21 https://lp.treinaweb.com.br/semana/aula-2

}
