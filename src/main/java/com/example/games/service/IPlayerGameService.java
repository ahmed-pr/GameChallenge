package com.example.games.service;

import com.example.games.model.Game;
import com.example.games.model.Player;

public interface IPlayerGameService {
	
	public void challengePlayers(Game game, Player player);
	
	public void acceptChallenge(Player player, Game game);
	
	public void surrenderFromGame(Player player, Game game);
	
	public void setRanking(Player player, Game game, String ranking);
	
}