package com.javatechie.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.security.api.model.LoginInfoMaster;

public interface UserRepository extends JpaRepository<LoginInfoMaster, Integer>{

	LoginInfoMaster findByUsername(String userName);

}
