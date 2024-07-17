package com.example.demo.repositories;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query("SELECT nv FROM NhanVien nv WHERE nv.ten LIKE %:keyword%")
    List<NhanVien> findByTen(@Param("keyword") String keyword);
}
