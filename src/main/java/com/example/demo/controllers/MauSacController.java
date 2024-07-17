package com.example.demo.controllers;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.MauSacRepository;
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
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    private MauSacRepository repo;

    @RequestMapping("index")
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model
    ){
        PageRequest p = PageRequest.of(pageNo, pageSize);
        Page<MauSac> lists;
        if (keyword != null && !keyword.isEmpty()) {
            List<MauSac> searchResults = this.repo.findByTen(keyword);
            lists = new PageImpl<>(searchResults, p, searchResults.size());
        } else {
            lists = this.repo.findAll(p);
        }
        model.addAttribute("lists", lists);
        return "mau_sac/index";
    }

    @PostMapping("store")
    public String store(Model model, @Valid MauSac sp, BindingResult vldResult){
        if(vldResult.hasErrors()){
            List<FieldError> listsFE = vldResult.getFieldErrors();
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: listsFE) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            PageRequest p = PageRequest.of(0, 10);
            Page<MauSac> lists = this.repo.findAll(p);
            model.addAttribute("lists", lists);
            return "mau_sac/index";
        }

        this.repo.save(sp);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.repo.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MauSac sp = this.repo.findById(id).get();
        model.addAttribute("data",sp);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(MauSac sp){
        this.repo.save(sp);
        return "redirect:/mau-sac/index";
    }

}
