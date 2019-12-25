package hw.controller;

import hw.model.Greeting;
import hw.model.Searching;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class SearchController {
    @GetMapping("/gresearch")
    public String greetingForm(Model model) {
        //model.addAttribute("greeting", new Greeting());
        model.addAttribute("gresearch", new Searching());
        return "gresearch";
    }
    @PostMapping("/gresearch")
    public String gettingInfo(@ModelAttribute Searching searching) {
        if (searching.searchInfor()!=null){
        return "/search";}
        return "/unsearch";
    }


}


