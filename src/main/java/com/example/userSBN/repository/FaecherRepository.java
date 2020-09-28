package com.example.userSBN.repository;

import com.example.userSBN.model.Faecher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaecherRepository extends JpaRepository<Faecher, Integer>, JpaSpecificationExecutor<Faecher> {

    List<Faecher> findAll();

    @Query(value = "SELECT u FROM faecher u WHERE u.name = :keyword or u.abkuerzung = :keyword or u.stufe = :keyword", nativeQuery = true)
    public List<Faecher> search(@Param("keyword") String keyword);

}
