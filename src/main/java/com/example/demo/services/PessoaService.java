package com.example.demo.services;

import com.example.demo.entities.Endereco;
import com.example.demo.entities.Pessoa;
import com.example.demo.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repo;

    public Pessoa create(String nome, Date dataNascimento, List<Endereco> enderecos) {
        Pessoa pessoa = Pessoa.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .endereco(enderecos)
                .build();

        return repo.save(pessoa);
    }

    public Pessoa findById(Integer id) {
        return repo.findById(id).get();
    }

    public Pessoa update(Integer id, String nome, Date dataNascimento, List<Endereco> enderecos) {
        Pessoa pessoa = findById(id);
        pessoa.setNome(nome);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setEndereco(enderecos);

        return repo.save(pessoa);
    }

    public List<Pessoa> listAll() {
        return repo.findAll();
    }



}
