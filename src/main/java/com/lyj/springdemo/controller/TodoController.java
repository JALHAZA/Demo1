package com.lyj.springdemo.controller;


import com.lyj.springdemo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {
    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("/list")
    public void list(){
      log.info("todo list...");    // localhost:8080/
    }

    //@RequestMapping(value = "register",method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGet(){
        log.info("todo GET register...");
    }

    //@RequestMapping(value = "register",method = RequestMethod.POST)
    @PostMapping("/register")

    //Model model 추가 해주면 .jsp 를 찿아간다
    public String registerPost(@ModelAttribute TodoDTO todoDTO, Model model){
        log.info("todo POST register...");
        //model.addAttribute("dto",todoDTO);   //@ModelAttribute 대체 후 list 에서 todoDTO. 으로 수정
        return "redirect:/todo/list";  // redirect:/ 컨트롤러함수 list() 찿는다.
    }
}
