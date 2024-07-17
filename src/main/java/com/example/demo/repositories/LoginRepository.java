package com.example.demo.repositories;

import com.example.demo.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<NhanVien, Integer> {
    NhanVien findByTenDangNhap(String tenDangNhap);
}
