package com.leaolabs.tarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leaolabs.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
