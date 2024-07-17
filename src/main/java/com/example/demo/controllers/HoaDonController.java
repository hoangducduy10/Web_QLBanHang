package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.HoaDon;
import com.example.demo.repositories.HoaDonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonRepository repo;

    @RequestMapping("index")
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name = "filter", defaultValue = "-1") int trangThai,
            Model model
    ){
        PageRequest p = PageRequest.of(pageNo, pageSize);

        if (trangThai != -1) {
            List<HoaDon> searchResults = this.repo.findByTrangThai(trangThai);
            model.addAttribute("lists", searchResults);
        } else {
            Page<HoaDon> page = repo.findAll(p);
            model.addAttribute("lists", page.getContent());
        }
        return "hoa_don/index";
    }

    @PostMapping("store")
    public String store(Model model, @Valid HoaDon sp, BindingResult vldResult){
        if(vldResult.hasErrors()){
            List<FieldError> listsFE = vldResult.getFieldErrors();
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: listsFE) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",sp);
            return "hoa_don/index";
        }

        this.repo.save(sp);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.repo.deleteById(id);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDon sp = this.repo.findById(id).get();
        model.addAttribute("data",sp);
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(HoaDon sp){
        this.repo.save(sp);
        return "redirect:/hoa-don/index";
    }

}
