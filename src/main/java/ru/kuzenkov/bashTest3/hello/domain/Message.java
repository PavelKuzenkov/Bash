package ru.kuzenkov.bashTest3.hello.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;
    private Date date = new Date();
    private String dateEndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message() {
//        this.date = new Date();
//        this.dateEndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
//        this.date = new Date();
//        this.dateEndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public String getDateTime() {
        return dateEndTime != null ? getDateEndTime() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateEndTime() {
        return dateEndTime;
    }
}
