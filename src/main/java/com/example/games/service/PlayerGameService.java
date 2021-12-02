package com.example.games.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.games.model.Game;
import com.example.games.model.Player;
import com.example.games.model.PlayerGame;
import com.example.games.model.PlayerGameKey;
import com.example.games.repository.PlayerGameRepository;

@Service
public class PlayerGameService implements IPlayerGameService {
	
	@Autowired 
	private PlayerGameRepository playerGameRepository;
	
	public void challengePlayers(Game game, Player player) {
		
			
		PlayerGame p = new PlayerGame();
			
		p.setGame(game);
		p.setPlayer(player);
		p.setStatus("Player have not answerd yet");
		
		PlayerGameKey playerGameKey = new PlayerGameKey();
		playerGameKey.setId(player.getId());
		playerGameKey.setId_game(game.getId_game());
		
		p.setPlayerGameKey(playerGameKey);
			
		playerGameRepository.save(p);
	}
	
	
	public void acceptChallenge(Player player, Game game) {
		
		PlayerGameKey pgk = new PlayerGameKey();
		
		pgk.setId(player.getId());
		pgk.setId_game(game.getId_game());
		
		PlayerGame pg = playerGameRepository.findById(pgk).get();
		
		pg.setStatus("Participating");
		
		playerGameRepository.save(pg);
		
		
	}
	
	
	public void surrenderFromGame(Player player, Game game) {
		
		PlayerGameKey pgk = new PlayerGameKey();
		
		pgk.setId(player.getId());
		pgk.setId_game(game.getId_game());
		
		PlayerGame pg = playerGameRepository.findById(pgk).get();
		
		pg.setStatus("Surrendered");
		
		playerGameRepository.save(pg);
		
		
	}
	
	
	public void setRanking(Player player, Game game, String ranking) {
		
		PlayerGameKey pgk = new PlayerGameKey();
		
		pgk.setId(player.getId());
		pgk.setId_game(game.getId_game());
		
		PlayerGame pg = playerGameRepository.findById(pgk).get();
		
		pg.setRanking(ranking);
		
		playerGameRepository.save(pg);
		
	}
	
	
	
	
	
}