package com.alabelewe.learningmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="course_id")
    private int courseId;

    public Lesson() {

    }

    public Lesson(int id, String title, String content, int courseId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.courseId = courseId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
