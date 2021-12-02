package com.example.games.service;

import com.example.games.model.Player;

public interface IPlayerService {
	
	public Player findByUsername(String username);
	
	public void addPlayer(String username);
	
	
}