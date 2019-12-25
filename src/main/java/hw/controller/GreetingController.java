package hw.controller;

import hw.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/*import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;*/

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Scanner;


@Controller
public class GreetingController  {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSave(@ModelAttribute Greeting greeting, HttpServletResponse response) {

        Cookie cookie = new Cookie("e-mail", greeting.getEmail());
        cookie.setMaxAge(24*60*60);


        response.addCookie(cookie);
        try(FileOutputStream nFile = new FileOutputStream("C://Users//Лилия//IdeaProjects//SpringHW//output//outputfile.txt",true);){

            String str = greeting.toString();
            byte[] strToBytes = str.getBytes();
            nFile.write(strToBytes);
            //nFile.write("\n");

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return "result";
    }

    /*@GetMapping("/greeting")
    public String greetingFormSearch(Model model) {
        Scanner myScanner = new Scanner(System.in);
        String sn;
        String info;
        myScanner.findInLine(sn);
        return "search";
    }
*/
}
