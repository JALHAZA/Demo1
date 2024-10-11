package com.lyj.springdemo.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";    //servlet-context.xml에서 /WEB-INF/views/hello.jsp 로 논리뷰가 된다
    }

    @GetMapping("/ex1")
    public void ex1(String name,int age,String gender,Model model) {
        log.info("ex1...");
        log.info("name:"+name);
        log.info("age:"+age);
        log.info("gender:"+gender);
    }


    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name",defaultValue = "AAA",required = true) String name,
                    @RequestParam(name="age",required = false) Integer age,
                    @RequestParam String gender,
                    Model model) {
        log.info("ex2...");
        log.info("name:"+name);
        log.info("age:"+age);
        log.info("gender:"+gender);

        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("gender",gender);
    }

    //model 은 뷰로 전달
    @GetMapping("/ex3")
    public void ex3(@RequestParam("dueDate") @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate dueDate,Model model) {
        log.info("ex3...");
        log.info("dueDate:"+dueDate);

        model.addAttribute("dueDate",dueDate);
    }

    @GetMapping("/ex4")
    public String ex4(RedirectAttributes redirectAttributes) {
        log.info("ex4...");
        redirectAttributes.addAttribute("name","ABC");
        redirectAttributes.addFlashAttribute("result","success");
        return "redirect:/ex5";
    }

    @GetMapping("/ex5")
    public void ex5(@RequestParam("name") String name, Model model) {
        log.info("ex5...");
        log.info("name:"+name);

        model.addAttribute("name",name);
    }

    @GetMapping("/ex6/{name}")
    public void ex6(@PathVariable("name") String name) {
        log.info("ex6...");
        log.info("name:"+name);
    }

    @GetMapping("/ex7")
    public void ex7(@RequestParam("p1") String p1,
                    @RequestParam("p2") int p2){
        log.info("ex7...");
        log.info("p1:"+p1);
        log.info("p2:"+p2);
    }

}
