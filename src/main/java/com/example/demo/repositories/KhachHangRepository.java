package com.example.demo.repositories;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    @Query("SELECT kh FROM KhachHang kh WHERE kh.ten LIKE %:keyword%")
    List<KhachHang> findByTen(@Param("keyword") String keyword);
}
