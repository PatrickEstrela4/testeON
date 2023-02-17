package com.example.testeON.ON.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testeON.ON.model.Pessoa;
import com.example.testeON.ON.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> relatorioGeral(String path) throws IOException{
    	List<String> file = Files.readAllLines(Paths.get(path));
    	
        List<Pessoa> pessoas = file.stream().map(linha -> {
            String[] words = linha.split(",");

            return Pessoa.builder().nome(words[0]).cpf(words[1]).idade(Long.parseLong(words[2])).build();
        }).collect(Collectors.toList());
        
        pessoaRepository.saveAll(pessoas);
        
        return pessoaRepository.saveAll(pessoas);
    }

}
