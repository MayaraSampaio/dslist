package com.mayara.dslist.model.service;

import com.mayara.dslist.model.dto.GameDTO;
import com.mayara.dslist.model.dto.GameListDTO;
import com.mayara.dslist.model.entities.GameList;
import com.mayara.dslist.model.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
        @Autowired
        GameListRepository gameListRepository;

        @Transactional(readOnly = true)
        public List<GameListDTO> findAll(){
            List<GameList> result= gameListRepository.findAll();
            return result.stream().map(x -> new GameListDTO(x)).toList();
        }
    }


