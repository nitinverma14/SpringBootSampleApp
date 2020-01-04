package com.jarvis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.entity.SecureMessagingAccessToken;


public interface SecureMessagingTokenRepository extends JpaRepository<SecureMessagingAccessToken, Long> {

	//SecureMessagingAccessToken findByActiveFlag(boolean active);
	
	//Void deleteAllTokens();	
	
}
