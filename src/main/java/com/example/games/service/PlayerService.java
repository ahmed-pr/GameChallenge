package com.example.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.games.model.Player;
import com.example.games.repository.PlayerRepository;


@Service
public class PlayerService implements IPlayerService {
	
	@Autowired 
	private PlayerRepository playerRepository;
	
	public Player findByUsername(String username) {
		List<Player> l = playerRepository.findByUsername(username);
		
		if (l.size() == 0)
			return null;
		
		return l.get(0);
	}
	
	
	public void addPlayer(String username) {
		
		Player p = new Player();
		
		p.setUsername(username);
		
		playerRepository.save(p);
		
	}
	
}