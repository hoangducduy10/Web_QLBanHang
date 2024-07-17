package com.example.demo.controllers;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.KhachHang;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository repo;

    @RequestMapping("index")
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model
    ){
        PageRequest p = PageRequest.of(pageNo, pageSize);
        Page<KhachHang> lists;
        if (keyword != null && !keyword.isEmpty()) {
            List<KhachHang> searchResults = this.repo.findByTen(keyword);
            lists = new PageImpl<>(searchResults, p, searchResults.size());
        } else {
            lists = this.repo.findAll(p);
        }
        model.addAttribute("lists", lists);
        return "khach_hang/index";
    }

    @PostMapping("store")
    public String store(Model model, @Valid KhachHang sp, BindingResult vldResult){
        if(vldResult.hasErrors()){
            List<FieldError> listsFE = vldResult.getFieldErrors();
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: listsFE) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            PageRequest p = PageRequest.of(0, 10);
            Page<KhachHang> lists = this.repo.findAll(p);
            model.addAttribute("lists", lists);
            return "khach_hang/index";
        }

        this.repo.save(sp);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.repo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KhachHang sp = this.repo.findById(id).get();
        model.addAttribute("data",sp);
        return "khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(KhachHang sp){
        this.repo.save(sp);
        return "redirect:/khach-hang/index";
    }

}
