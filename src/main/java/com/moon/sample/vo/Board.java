package com.moon.sample.vo;


import javax.persistence.*;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String subject;

    @Column
    private String content;

    public Board() {
    }

    public Board(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
