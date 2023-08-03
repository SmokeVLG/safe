package com.maxden.safe.demo;

import com.maxden.safe.domain.Users;
import com.maxden.safe.domain.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Profile("testdata")
public class UserDataLoader {

	private final UserRepository userRepository;

	public UserDataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadUserJobTestData() {
		userRepository.deleteAll();
		var user1 = Users.of(
				"Денисов",
				"Владимирович",
				"Максим",
				Date.valueOf(LocalDate.parse("1989-09-23")),
				"М",
				33,
				"программист",
				false);

		var user2 = Users.of(
				"Иванов",
				"Иванович",
				"Иван",
				Date.valueOf(LocalDate.parse("1993-08-20")),
				"М",
				30,
				"программист",
				false);

		userRepository.saveAll(List.of(user1,user2));
	}

}