package com.example.demo.controller;

import com.example.demo.entity.Name;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    private List<Name> names = new ArrayList<>();
    @GetMapping
    public ModelAndView basic()
    {
        ModelAndView modelAndView = new ModelAndView("bieuthuc");
        modelAndView.addObject("today", "monday");
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView infoUser()
    {
        ModelAndView modelAndView = new ModelAndView("sub");
//        names.add(new Name("thang", 20,"hn",true));
//        names.add(new Name("Bien", 30,"dn",false));
//        names.add(new Name("Hoang", 15,"tn",true));
//        names.add(new Name("Linh", 15,"tn",false));
        modelAndView.addObject("output",names);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createUser(Model model)
    {
        model.addAttribute("createName", new Name());
        return "create";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("createName") Name name,Model model)
    {
        if (name.getName().isEmpty()) {
            model.addAttribute("errorName","chưa nhập tên");
            return "create";
        }
        if (name.getAge()<=0) {
            model.addAttribute("errorAge","tuổi phải lớn hơn 0");
            return "create";
        }
        if (name.getAddress().isEmpty()) {
            model.addAttribute("errorAddress","bạn chưa thêm địa chỉ");
            return "create";
        }
            names.add(name);
            return "redirect:/info";
    }

}
