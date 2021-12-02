package com.example.games.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.games.model.Player;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	List<Player> findByUsername(String username);
	
}