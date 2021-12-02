package com.example.games;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.games.service.IGameService;
import com.example.games.service.IPlayerService;


@SpringBootTest
@RunWith(SpringRunner.class)
class GamesApplicationTests {
	
	@Autowired
	private IGameService gs;
	
	@Autowired
	private IPlayerService ps;
	
	
	
	
	@Test
	void contextLoads() {
	}
	
	
	//Test a GameService method which returns a Game object by using his Id
	//You should specify a valid game_id and it's respective game_type according to your DB records (for my case game_id was : 1 and game_type was : Monopoly)
	//This test method tries to verify if the method's result is equal to the expected one (Monopoly)
	@Test
	void testGetGameById() {
		assertThat(gs.getGameById(1).getGame_type()).isEqualTo("Monopoly");
	}
	
	
	//Test a PlayerService method which returns a Player object by using his username
	//You should specify a valid game_id and it's respective game_type according to your DB records (for my case game_id was : BestPlayer1)
	//This test method tries to verify if the method's result is not Null
	@Test
	void testGetPlayerByUsername() {
		assertThat(ps.findByUsername("BestPlayer1")).isNotNull();
	}

}
