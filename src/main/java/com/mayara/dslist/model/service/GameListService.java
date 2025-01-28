package com.mayara.dslist.model.service;

import com.mayara.dslist.model.dto.GameDTO;
import com.mayara.dslist.model.dto.GameListDTO;
import com.mayara.dslist.model.entities.GameList;
import com.mayara.dslist.model.repositories.GameListRepository;
import com.mayara.dslist.model.repositories.GameRepository;
import com.mayara.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
        @Autowired
        GameListRepository gameListRepository;
        @Autowired
        GameRepository gameRepository;

        @Transactional(readOnly = true)
        public List<GameListDTO> findAll(){
            List<GameList> result= gameListRepository.findAll();
            return result.stream().map(x -> new GameListDTO(x)).toList();
        }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList entity = gameListRepository.findById(id).get();
        return new GameListDTO(entity);
    }
    }


