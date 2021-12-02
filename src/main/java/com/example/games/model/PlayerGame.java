package com.example.games.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PlayerGame {
	

    @EmbeddedId
    private PlayerGameKey playerGameKey;
    
    
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    @JsonBackReference
    private Player player;
    
    @ManyToOne
    @MapsId("id_game")
    @JoinColumn(name = "id_game")
    @JsonBackReference
    private Game game;
    
    private String status;
    private String ranking;
    
    
    
	public PlayerGameKey getPlayerGameKey() {
		return playerGameKey;
	}
	public void setPlayerGameKey(PlayerGameKey playerGameKey) {
		this.playerGameKey = playerGameKey;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
    
    
    
    
    
	
}