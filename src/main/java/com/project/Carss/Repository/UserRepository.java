package com.project.Carss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Carss.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
