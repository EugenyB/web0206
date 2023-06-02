package com.example.web0206;

import com.example.web0206.data.Student;
import com.example.web0206.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MyController {

    private StudentService studentService;

    @GetMapping("/hello/{color}/{name}")
    public String hello(@PathVariable String color, @PathVariable String name, Model model) {
        model.addAttribute("username", name);
        model.addAttribute("color", color);
        return "hello";
    }

    @GetMapping("/students")
    public String showList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam String name, @RequestParam int age) {
        studentService.addStudent(new Student(name, age));
        return "redirect:/students";
    }
}
