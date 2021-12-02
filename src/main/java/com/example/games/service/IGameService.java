package com.example.games.service;

import java.util.ArrayList;
import java.util.List;

import com.example.games.model.Game;
import com.example.games.model.PlayerGame;

public interface IGameService {
	
	public Game addGame(String game_type);
	
	public void changeStatus(Game g, String status);
	
	public Game getGameById(int id_game);
	
	public List<PlayerGame> getGameResult(Game g);
	
	public ArrayList<Game> getGameInfos(String filter, String value);
	
}