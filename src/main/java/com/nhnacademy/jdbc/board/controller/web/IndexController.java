package com.nhnacademy.jdbc.board.controller.web;

import com.nhnacademy.jdbc.board.student.domain.Student;
import com.nhnacademy.jdbc.board.student.service.StudentService;
import com.nhnacademy.jdbc.board.student.service.impl.DefaultStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping
@Slf4j
public class IndexController {

    @GetMapping(value = {"/","/index"})
    public String index(){

        return "index/index";
    }
}
