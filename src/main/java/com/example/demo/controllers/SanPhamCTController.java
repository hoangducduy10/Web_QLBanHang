package com.example.demo.controllers;

import com.example.demo.entities.SanPham;
import com.example.demo.entities.SanPhamCT;
import com.example.demo.repositories.SanPhamCTRepository;
import com.example.demo.repositories.SanPhamRepository;
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
@RequestMapping("san-pham-chi-tiet")
public class SanPhamCTController {

    @Autowired
    private SanPhamRepository spRepo;

    @Autowired
    private SanPhamCTRepository repo;

    @RequestMapping("index")
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int pageNo,
            @RequestParam(name = "limit", defaultValue = "10") int pageSize,
            @RequestParam(name="spId", defaultValue = "-1") int spId,
            Model model
    ){
        PageRequest p = PageRequest.of(pageNo, pageSize);

        List<SanPham> sanPhamList = spRepo.findAll();
        model.addAttribute("sanPhamList", sanPhamList);

        if (spId != -1) {
            List<SanPhamCT> sanPhamCTList = repo.finBySpID(spId);
            model.addAttribute("lists", sanPhamCTList);
        } else {
            Page<SanPhamCT> page = repo.findAll(p);
            model.addAttribute("lists", page.getContent());
        }

        return "san_pham_ct/index";
    }

    @PostMapping("store")
    public String store(Model model, @Valid SanPhamCT sp, BindingResult vldResult){
        if(vldResult.hasErrors()){
            List<FieldError> listsFE = vldResult.getFieldErrors();
            Map<String,String> errors = new HashMap<>();
            for (FieldError e: listsFE) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",sp);
            return "san_pham_ct/index";
        }

        this.repo.save(sp);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.repo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPhamCT sp = this.repo.findById(id).get();
        model.addAttribute("data",sp);
        return "san_pham_ct/edit";
    }

    @PostMapping("update/{id}")
    public String update(SanPhamCT sp){
        this.repo.save(sp);
        return "redirect:/san-pham-chi-tiet/index";
    }

}
