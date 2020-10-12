package com.example.userSBN.repository;

import com.example.userSBN.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyStudentQueryDSLRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
