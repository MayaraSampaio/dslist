package com.mayara.dslist.model.service;
import com.mayara.dslist.model.dto.GameMinDTO;
import com.mayara.dslist.model.entities.Game;
import com.mayara.dslist.model.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    //stream= vai lib que permite operações com sequencia de dados
    public List<GameMinDTO> findAll(){
        List<Game> result= gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
