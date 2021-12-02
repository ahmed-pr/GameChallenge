package com.example.games.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	@OneToMany(mappedBy = "player")
	@JsonManagedReference
	private List<PlayerGame> gamesPlayer = new ArrayList<PlayerGame>();

	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<PlayerGame> getGamesPlayer() {
		return gamesPlayer;
	}

	public void setGamesPlayer(List<PlayerGame> gamesPlayer) {
		this.gamesPlayer = gamesPlayer;
	}
	
	
}