package com.mayara.dslist.model.controllers;

import com.mayara.dslist.model.dto.GameDTO;
import com.mayara.dslist.model.dto.GameMinDTO;
import com.mayara.dslist.model.dto.ReplacementDTO;
import com.mayara.dslist.model.service.GameListService;
import com.mayara.dslist.model.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/games")
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    GameListService gameListService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
       return gameService.findById(id);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
