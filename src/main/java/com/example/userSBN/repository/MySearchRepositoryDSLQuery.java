package com.example.userSBN.repository;

import com.example.userSBN.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MySearchRepositoryDSLQuery extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
