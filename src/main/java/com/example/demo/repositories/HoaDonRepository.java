package com.example.demo.repositories;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    @Query("SELECT hd FROM HoaDon hd WHERE hd.trangThai = :status")
    List<HoaDon> findByTrangThai(@Param("status") int status);
}
