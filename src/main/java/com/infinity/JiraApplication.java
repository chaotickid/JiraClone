package com.infinity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties
public class JiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiraApplication.class, args);
		log.debug("\n__________________ _______  _______         _______  _        _______  _        _______ \n" +
				"\\__    _/\\__   __/(  ____ )(  ___  )       (  ____ \\( \\      (  ___  )( (    /|(  ____ \\\n" +
				"   )  (     ) (   | (    )|| (   ) |       | (    \\/| (      | (   ) ||  \\  ( || (    \\/\n" +
				"   |  |     | |   | (____)|| (___) | _____ | |      | |      | |   | ||   \\ | || (__    \n" +
				"   |  |     | |   |     __)|  ___  |(_____)| |      | |      | |   | || (\\ \\) ||  __)   \n" +
				"   |  |     | |   | (\\ (   | (   ) |       | |      | |      | |   | || | \\   || (      \n" +
				"|\\_)  )  ___) (___| ) \\ \\__| )   ( |       | (____/\\| (____/\\| (___) || )  \\  || (____/\\\n" +
				"(____/   \\_______/|/   \\__/|/     \\|       (_______/(_______/(_______)|/    )_)(_______/ all rights are reserved");
	}

}
