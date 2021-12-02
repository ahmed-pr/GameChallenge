package com.example.games.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_game;
	
	private String gameType;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "game")
	private List<PlayerGame> playersGame = new ArrayList<PlayerGame>();
	

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public String getGame_type() {
		return gameType;
	}

	public void setGame_type(String gameType) {
		this.gameType = gameType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<PlayerGame> getPlayersGame() {
		return playersGame;
	}

	public void setPlayersGame(List<PlayerGame> playersGame) {
		this.playersGame = playersGame;
	}
	 
	 
	
}