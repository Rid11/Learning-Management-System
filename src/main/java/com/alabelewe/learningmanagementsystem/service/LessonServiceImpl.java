package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.dao.LessonRepository;
import com.alabelewe.learningmanagementsystem.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {


   private LessonRepository lessonRepository;

   @Autowired
   public LessonServiceImpl(LessonRepository lessonRepository) {
       this.lessonRepository = lessonRepository;
   }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findById(int id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);

        Lesson newLesson = null;

        if (lesson.isPresent()){
            newLesson = lesson.get();
        }else{
            throw new RuntimeException("Lesson not found");
        }

        return newLesson;

    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteById(int id) {

        Optional<Lesson> lesson = lessonRepository.findById(id);

        Lesson newLesson = null;

        if (lesson.isPresent()){
            lessonRepository.deleteById(id);
        }else{
            throw new RuntimeException("Lesson not found");
        }



    }

}
