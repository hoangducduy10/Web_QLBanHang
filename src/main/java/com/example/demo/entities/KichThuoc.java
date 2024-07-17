package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "KichThuoc")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class KichThuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Ma")
    @NotBlank(message = "Mã không được để trống!")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Tên không được để trống!")
    private String ten;

    @Column(name = "TrangThai")
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private int trangThai;

}
