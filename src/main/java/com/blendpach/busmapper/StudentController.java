package com.blendpach.busmapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {

        return new Student("Ushira", "Tissera");

    }

    @GetMapping("/students")
    public List<Student> getstudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Dinith", "Shavindu"));
        students.add(new Student("Name1", "Surname1"));
        students.add(new Student("Name2", "Surname2"));
        students.add(new Student("Name3", "Surname3"));
        students.add(new Student("Name4", "Surname4"));
        students.add(new Student("Name5", "Surname5"));
        students.add(new Student("Name6", "Surname6"));

        return students;

    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {

        return new Student(firstName, lastName);

    }

}
