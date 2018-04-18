package com.basic.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.springboot.domain.User;

@Repository
public interface AccountRepository extends JpaRepository<User, Long>{

}
