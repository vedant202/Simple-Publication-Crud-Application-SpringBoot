package com.Publication.Publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Publication.Publication.Model.UserPublications;

public interface UserRepository extends JpaRepository<UserPublications, Integer> {
	public UserPublications findByEmail(String email);
}
