package com.mayara.dslist.model.service;
import com.mayara.dslist.model.dto.GameDTO;
import com.mayara.dslist.model.dto.GameMinDTO;
import com.mayara.dslist.model.entities.Game;
import com.mayara.dslist.model.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    //stream= vai lib que permite operações com sequencia de dados
    //transactional, é uma boa prática ACID
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result= gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        //depois posso fazer o tratamento com o optional
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
