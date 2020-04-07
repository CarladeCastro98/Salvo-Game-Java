package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository) {
		return (args) -> {
			// sample date
			Player John = new Player("j.bauer@ctu.gov", 24);
			playerRepository.save(John);
			Game gameTest1 = new Game();
			gameRepository.save(gameTest1);
			GamePlayer gpTest1 = new GamePlayer(gameTest1, John);
			gamePlayerRepository.save(gpTest1);
			Player Chloe = new Player("c.obrian@ctu.gov", 42);
			playerRepository.save(Chloe);
			Game gameTest2 = new Game();
			gameRepository.save(gameTest2);
			GamePlayer gpTest2 = new GamePlayer(gameTest2, Chloe);
			gamePlayerRepository.save(gpTest2);
			Player Kim = new Player("kim_bauer@gmail.com", 18);
			playerRepository.save(Kim);
			Game gameTest3 = new Game();
			gameRepository.save(gameTest3);
			GamePlayer gpTest3 = new GamePlayer(gameTest3, Kim);
			gamePlayerRepository.save(gpTest3);
			Player Tony = new Player("t.almeida@ctu.gov", 10);
			playerRepository.save(Tony);
			Game gameTest4 = new Game();
			gameRepository.save(gameTest4);
			GamePlayer gpTest4 = new GamePlayer(gameTest4, Tony);
			gamePlayerRepository.save(gpTest4);
		};
	}
}
