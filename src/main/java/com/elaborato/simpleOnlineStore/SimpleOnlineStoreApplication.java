package com.elaborato.simpleOnlineStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class SimpleOnlineStoreApplication implements CommandLineRunner {
	private final DataSource dataSource;
	public SimpleOnlineStoreApplication(final DataSource dataSource){
		this.dataSource=dataSource;
	}

	@Override
	public void run(String... args) {
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("Select 1");
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleOnlineStoreApplication.class, args);
	}

}
