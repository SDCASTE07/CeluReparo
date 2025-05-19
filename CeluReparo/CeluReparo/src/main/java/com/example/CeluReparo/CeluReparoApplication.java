package com.example.CeluReparo;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CeluReparoApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(CeluReparoApplication.class, args);
	}
	private static void loadEnv() {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("BD_URL", dotenv.get("BD_URL"));
		System.setProperty("BD_USERNAME", dotenv.get("BD_USERNAME"));
		System.setProperty("BD_PASSWORD", dotenv.get("BD_PASSWORD"));
	}

}