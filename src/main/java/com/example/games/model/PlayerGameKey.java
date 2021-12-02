package com.example.games.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlayerGameKey implements Serializable {
	
	
	private int id;
	private int id_game;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_game() {
		return id_game;
	}
	public void setId_game(int id_game) {
		this.id_game = id_game;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + id_game;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerGameKey other = (PlayerGameKey) obj;
		if (id != other.id)
			return false;
		if (id_game != other.id_game)
			return false;
		return true;
	}
	
	
	
	
	 
	 
}