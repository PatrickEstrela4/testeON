package com.example.testeON.ON.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.testeON.ON.model.Pessoa;
import com.example.testeON.ON.service.PessoaService;

@Controller
@RequestMapping("/api")
public class PessoaController {

        @Autowired
        private PessoaService service;

        @GetMapping("/Pessoa")
        public ResponseEntity<List<Pessoa>> getReport(@RequestParam  String path) throws IOException{
            return new ResponseEntity<>(service.relatorioGeral(path), HttpStatus.ACCEPTED);
        }
        
}
