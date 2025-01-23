package com.mayara.dslist.model.repositories;
import com.mayara.dslist.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
