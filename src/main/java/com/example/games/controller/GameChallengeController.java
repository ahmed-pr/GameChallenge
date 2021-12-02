package com.example.games.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.games.model.Game;
import com.example.games.model.PlayerGame;
import com.example.games.service.IGameService;
import com.example.games.service.IPlayerGameService;
import com.example.games.service.IPlayerService;


@RestController
public class GameChallengeController {
	
	@Autowired
	private IPlayerService ps;
	
	@Autowired
	private IGameService gs;
	
	@Autowired
	private IPlayerGameService pgs;
	
	@GetMapping("/gameById")
    public Game gameById(@RequestParam("id") Optional<Integer> id) {
		
        return gs.getGameById(id.get().intValue());
    }
	
	
	
	
	@PostMapping("/createGame")
	public String createGame(@RequestBody String game_type) {
		
		return "Game have been successfuly created with id : " + String.valueOf(gs.addGame(game_type).getId_game()) + "\n";
		
	}
	
	
	@PostMapping("/createPlayer")
	public String createPlayer(@RequestBody String username) {
		
		ps.addPlayer(username);
		
		return "Player have been successfuly created";
		
	}
	
	
	
	@PostMapping("/challengePlayer")
	public String challengePlayer(@RequestBody Map<String, String> m) {
		
		//System.out.print("\nLe id game : " + m.get("id_game") + "\nLe username : " + m.get("username"));
		
			
		pgs.challengePlayers(gs.getGameById(Integer.valueOf(m.get("id_game")).intValue()), ps.findByUsername((m.get("username"))));
		
		return "Player have been invited to this game";
		
	}
	
	
	
	@PutMapping("/acceptChallenge")
	public String acceptChallenge(@RequestBody Map<String, String> m) {
			
		pgs.acceptChallenge(ps.findByUsername(m.get("username")), gs.getGameById(Integer.valueOf(m.get("id_game")).intValue()));
		
		
		return "You have accepted the challenge";
		
	}
	
	@PutMapping("/startGame")
	public String startGame(@RequestBody Integer id_game) {
			
		gs.changeStatus(gs.getGameById(id_game.intValue()), "Started");
		
		
		return "You have started this game";
		
	}
	
	@PutMapping("/surrenderFromGame")
	public String surrenderFromGame(@RequestBody Map<String, String> m) {
			
		pgs.surrenderFromGame(ps.findByUsername(m.get("username")), gs.getGameById(Integer.valueOf(m.get("id_game")).intValue()));
		
		
		return "You have surrendered from the game";
		
	}
	
	
	@PutMapping("/finishGame")
	public List<PlayerGame> finishGame(@RequestBody Integer id_game) {
		
		Game g = gs.getGameById(id_game.intValue());
			
		gs.changeStatus(g, "Finished");
		
		return g.getPlayersGame();
		
	}
	
	
	
	@PutMapping("/updatePlayerRanking")
	public String updatePlayerRanking(@RequestBody Map<String, String> m) {
			
		pgs.setRanking(ps.findByUsername(m.get("username")), gs.getGameById(Integer.valueOf(m.get("id_game")).intValue()), m.get("ranking"));
		
		return "Rank have been successfuly updated";
		
	}
	
	
	
	@GetMapping("/getGamesInfos")
    public ArrayList<Game> getGamesInfos(@RequestParam("name") Optional<String> name, @RequestParam("player") Optional<String> player, @RequestParam("createdAt") Optional<String> createdAt) {
		
		
		if ((name.isEmpty()) && (player.isEmpty()) && (createdAt.isEmpty()))
			return gs.getGameInfos(null, null);
		
		if(name.isPresent())
			return gs.getGameInfos("name", name.get());
		
		if(player.isPresent())
			return gs.getGameInfos("player", player.get());
		
		return gs.getGameInfos("createdAt", createdAt.get());
		
		
    }
	
	
	
	
}