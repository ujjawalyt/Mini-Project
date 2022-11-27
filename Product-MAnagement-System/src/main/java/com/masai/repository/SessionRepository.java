package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {
	
	public CurrentUserSession findByUuid(String uuid);
}
