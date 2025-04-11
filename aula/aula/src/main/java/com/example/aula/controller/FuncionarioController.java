package com.example.aula.controller;
import com.example.aula.model.Funcionario;
import com.example.aula.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    // lista todos os funcionários
    @GetMapping
        public List<Funcionario> listarTodos() {
           return funcionarioService.listarTodos();
        }

    // cadastra um novo funcionário
        @PostMapping
        public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
            funcionarioService.salvar(funcionario);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Map.of("mensagem", "funcionario " + funcionario.getNome() + " cadastrado com sucesso."));
        }
    // atualiza um funcionário existente
        @PutMapping
        public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
            funcionarioService.atualizar(funcionario);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("mensagem","Funcionario  atualizado com sucesso."));
        }
    // exclui funcionário pelo e-mail
    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable String email) {
        funcionarioService.excluir(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionário excluido com sucesso"));
    }
}
