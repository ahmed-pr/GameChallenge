package com.example.games.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.games.model.Game;
import com.example.games.model.Player;
import com.example.games.model.PlayerGame;
import com.example.games.repository.GameRepository;

@Service
public class GameService implements IGameService {
	
	@Autowired 
	private GameRepository gameRepository;
	
	public Game addGame(String game_type) {
		
		Game g = new Game();
		
		g.setGame_type(game_type);
		g.setStatus("waiting");
		g.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		return gameRepository.save(g);
		
	}
	
	public void changeStatus(Game g, String status) {
		
		g.setStatus(status);
		g.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		gameRepository.save(g);
	}
	
	public Game getGameById(int id_game) {
		
		Optional<Game> og = gameRepository.findById(id_game);
		
		if (og.isEmpty())
			return null;
		
		return og.get();
	}
	
	
	public List<PlayerGame> getGameResult(Game g) {
		
		
		List<PlayerGame> l = g.getPlayersGame();
		
		List<PlayerGame> s = new ArrayList<PlayerGame>();
		
		
		for(int i = 0; i < l.size(); i++) {
			
			
			if(!(l.get(i).getStatus().equals("Surrendered"))) {
				
				l.get(i).setRanking("Surrendered");
				s.add(l.get(i));
				l.remove(i);
				i--;
				
				
				
				
			}
			
			else {
				
				for(int j = i+1; j < l.size(); j++) {
					
					if (Integer.valueOf(l.get(j).getRanking()).intValue() < Integer.valueOf(l.get(i).getRanking()).intValue()) {
						
						PlayerGame tmp = l.get(j);
						l.add(j, l.get(i));
						l.add(i, tmp);
						
					}
					
					
					
				}
				
				
			}
			
				
				
		}
		
		
		
		
		l.addAll(s);
		
		
		return l;
		
		
	}
	
	
	
	
	
	
	public ArrayList<Game> getGameInfos(String filter, String value) {
		
		ArrayList<Game> l = new ArrayList<Game>();
		
		if ((filter == null) || (value == null))
			gameRepository.findAll().forEach(l::add);
		
		else {
		
			if (filter.equals("name")) 
				gameRepository.findByGameType(value).forEach(l::add);
		
		
			if (filter.equals("player")) {
			
				Set<Game> s = new HashSet<Game>();
			
			
				for(Game game : gameRepository.findAll()) {
				
					for(PlayerGame pg : game.getPlayersGame()) {
					
						if (pg.getPlayer().getUsername().equals(value)) {
							s.add(game);
							break;
						}	
					}
				
				
				}
			
			
			
			
				s.forEach(l::add);
			
		
			}
		
		
			if (filter.equals("createdAt")) 
				gameRepository.findByCreatedAt(value).forEach(l::add);
			
			
		}
			
		return l;
		
		
		
		
		
		}
		
		

	
}