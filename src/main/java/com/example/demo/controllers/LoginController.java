package com.example.demo.controllers;

import com.example.demo.entities.NhanVien;
import com.example.demo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository repo;

    @GetMapping("login")
    public String index(Model model) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", new NhanVien());
        }
        return "login/index";
    }

    @GetMapping("trang-chu")
    public String home() {
        return "trang_chu/index";
    }

    @PostMapping("login")
    public String login(
            @ModelAttribute("data") NhanVien nv,
            Model model
    ){
        NhanVien nvForm = repo.findByTenDangNhap(nv.getTenDangNhap());
        if(nvForm != null && nvForm.getMatKhau().equals(nv.getMatKhau())){
            return "redirect:/trang-chu";
        } else {
            model.addAttribute("error", true);
            return "login/index";
        }
    }

}
