package com.example.demo.repositories;

import com.example.demo.entities.SanPhamCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamCTRepository extends JpaRepository<SanPhamCT, Integer> {
    @Query("SELECT spct FROM SanPhamCT spct WHERE spct.idSP = :id")
    List<SanPhamCT> finBySpID(@Param("id") int id);
}
