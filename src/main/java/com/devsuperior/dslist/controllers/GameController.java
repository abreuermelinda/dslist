package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//O controller vai ser a porta de entrada do backend dsiponibilizando a API implementando essa API
// e expondo essa API para o mundo externo.
@RestController //Configura a classe para ser um Controller
@RequestMapping(value= "/games") //Configura o caminho que vai ser respondido na API
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
