package com.sql.server.sql_server_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sql.server.sql_server_app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{}
