package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.entity.Lesson;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LessonService {

    public List<Lesson> findAll();

    public Lesson findById(int id);

    public Lesson save(Lesson lesson);

    public void deleteById(int id);

}
