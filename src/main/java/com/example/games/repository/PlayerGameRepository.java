package com.example.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.games.model.PlayerGame;
import com.example.games.model.PlayerGameKey;

@Repository
public interface PlayerGameRepository extends CrudRepository<PlayerGame, PlayerGameKey> {
	
	
}