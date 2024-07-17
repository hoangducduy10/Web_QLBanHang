package com.example.demo.repositories;

import com.example.demo.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query("SELECT sp FROM SanPham sp WHERE sp.ten LIKE %:keyword%")
    List<SanPham> findByTen(@Param("keyword") String keyword);
}
