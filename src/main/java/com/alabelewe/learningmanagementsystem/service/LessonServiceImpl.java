package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {


    private LessonService lessonService;

    @Autowired
    public LessonServiceImpl(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    public Lesson findById(int id) {
        Lesson lesson = lessonService.findById(id);

        if (lesson == null) {
            throw new RuntimeException("Lesson not found" + id);
        }

        return lesson;
    }

    public Lesson save(Lesson lesson) {
        return lessonService.save(lesson);
    }

    public void deleteById(int id) {
        Lesson lesson = lessonService.findById(id);
        if (lesson == null) {
            throw new RuntimeException("Lesson not found" + id);
        }

        lessonService.deleteById(id);

    }

}
