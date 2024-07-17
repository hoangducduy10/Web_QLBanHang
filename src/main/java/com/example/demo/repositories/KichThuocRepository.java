package com.example.demo.repositories;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    @Query("SELECT kt FROM KichThuoc kt WHERE kt.ten LIKE %:keyword%")
    List<KichThuoc> findByTen(@Param("keyword") String keyword);
}
