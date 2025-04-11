package com.example.aula.repository;

import com.example.aula.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario , Long> {

    Optional<Funcionario> findByEmail(String email);
// busca funcionário pelo e-mail
}
