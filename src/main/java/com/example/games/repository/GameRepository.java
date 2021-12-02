package com.example.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.games.model.Game;


@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
	
	List<Game> findByGameType(String gameType);
	
	List<Game> findByCreatedAt(String createdAt);
}