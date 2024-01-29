package com.pjatk.MPR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class WebController {
    private final Service service;

    @Autowired
    public WebController(Service service) {this.service = service;}

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping(value = "/cats")
    public String getCats(Model model) {
        model.addAttribute("cats", service.getAll());
        return "Cats";
    }
    @GetMapping(value = "/sendCat")
    public String addCat(Model model) {
        model.addAttribute("cat", new Cat(0,"",""));
        return "sendCat";
    }
    @PostMapping(value = "/addCat")
    public String addCat(Cat cat, Model model) {
        service.sendCat(cat);
        return "redirect:/allCats";
    }
    @PutMapping(value = "/edit/{id}")
    public String editCat (Model model, String name, String race) {
        service.editCatName(model.getAttribute("catId"),name,race);
        return "redirect:/allCats";
    }
}
