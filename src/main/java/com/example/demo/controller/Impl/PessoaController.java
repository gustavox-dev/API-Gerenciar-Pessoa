package com.example.demo.controller.Impl;

import com.example.demo.entities.Endereco;
import com.example.demo.entities.Pessoa;
import com.example.demo.services.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PessoaController {

    private final PessoaService service;

    @PostMapping("/pessoa")
    public Pessoa create(@RequestParam String nome, @RequestParam Date dataNascimento, @RequestParam List<Endereco> enderecos) {
        return service.create(nome, dataNascimento, enderecos);
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping("/pessoa/{id}")
    public Pessoa update(@PathVariable Integer id, @RequestParam String nome, @RequestParam Date dataNascimento, @RequestParam List<Endereco> enderecos) {
        return service.update(id, nome, dataNascimento, enderecos);
    }

    @GetMapping("/pessoa/all")
    public List<Pessoa> listAll(){
        return service.listAll();
    }
}
