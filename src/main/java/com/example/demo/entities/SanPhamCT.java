package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SanPhamChiTiet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPhamCT {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IdMauSac")
    private Integer idMS;

    @Column(name = "IdKichThuoc")
    private Integer idKT;

    @Column(name = "IdSanPham")
    private Integer idSP;

    @Column(name = "MaSPCT")
    @NotBlank(message = "Mã không được để trống!")
    private String maSPCT;

    @Column(name = "SoLuong")
    @NotNull(message = "Số lượng không được để trống!")
    @DecimalMin(value = "0", message = "Số lượng phải lớn hơn 0!")
    private Integer soLuong;

    @Column(name = "DonGia")
    @NotNull(message = "Đơn giá không được để trống!")
    @DecimalMin(value = "100", message = "Đơn giá phải lớn hơn 100!")
    private Double donGia;

    @Column(name = "TrangThai")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;

}
