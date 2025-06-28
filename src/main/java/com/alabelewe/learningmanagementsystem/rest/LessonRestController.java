package com.alabelewe.learningmanagementsystem.rest;


import com.alabelewe.learningmanagementsystem.entity.Lesson;
import com.alabelewe.learningmanagementsystem.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class LessonRestController {

    private LessonService lessonService;

    @Autowired
    public LessonRestController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lessons")
    public List<Lesson> getLessons() {
        return lessonService.findAll();
    }

    @GetMapping("/lessons/{lessonId}")
    public Lesson getLessonById(@PathVariable int lessonId) {
        Lesson lesson = lessonService.findById(lessonId);

        if(lesson == null){
            throw new RuntimeException("Lesson with id " + lessonId + " not found");
        }
        return lesson;
    }

    @PostMapping("/lessons")
    public Lesson addLesson(@RequestBody Lesson lesson) {

        lesson.setId(0);

        Lesson lesson1 = lessonService.save(lesson);

        return lesson1;

    }

    @PutMapping("/lessons")
    public Lesson updateLesson(@RequestBody Lesson lesson) {
        Lesson lesson1 = lessonService.save(lesson);
        return lesson1;
    }

    @DeleteMapping("/lessons/{lessonId}")
    public String deleteLesson(@PathVariable int lessonId) {

        Lesson lesson = lessonService.findById(lessonId);

        if(lesson == null){
            throw new RuntimeException("Lesson with id " + lessonId + " not found");
        }
        lessonService.deleteById(lessonId);

        return "Deleted employee Id " +  lessonId;
    }








}
