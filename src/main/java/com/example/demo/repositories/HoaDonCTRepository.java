package com.example.demo.repositories;

import com.example.demo.entities.HoaDonCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonCT, Integer> {
    @Query("SELECT hdct FROM HoaDonCT hdct WHERE hdct.trangThai = :status")
    List<HoaDonCT> findByTrangThai(@Param("status") int status);
}
