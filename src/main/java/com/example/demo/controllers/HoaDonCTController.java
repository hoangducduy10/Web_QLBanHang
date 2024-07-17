package com.example.demo.controllers;

import com.example.demo.entities.HoaDonCT;
import com.example.demo.repositories.HoaDonCTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("hoa-don-chi-tiet")
public class HoaDonCTController {

    @Autowired
    private HoaDonCTRepository repo;

    @RequestMapping("index")
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "filter", defaultValue = "-1") int trangThai,
            Model model
    ){
        PageRequest p = PageRequest.of(pageNo, pageSize);
        
        if (trangThai != -1) {
            List<HoaDonCT> searchResults = this.repo.findByTrangThai(trangThai);
            model.addAttribute("lists", searchResults);
        } else {
            Page<HoaDonCT> page = repo.findAll(p);
            model.addAttribute("lists", page.getContent());
        }
        
        return "hoa_don_ct/index";
    }


    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDonCT sp = this.repo.findById(id).get();
        model.addAttribute("data",sp);
        return "hoa_don_ct/edit";
    }

    @PostMapping("update/{id}")
    public String update(HoaDonCT sp){
        this.repo.save(sp);
        return "redirect:/hoa-don-chi-tiet/index";
    }

}
