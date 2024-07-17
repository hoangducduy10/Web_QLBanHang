package com.example.demo.repositories;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    @Query("SELECT ms FROM MauSac ms WHERE ms.ten LIKE %:keyword%")
    List<MauSac> findByTen(@Param("keyword") String keyword);
}
