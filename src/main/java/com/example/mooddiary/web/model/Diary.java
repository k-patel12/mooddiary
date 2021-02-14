package com.example.mooddiary.web.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Diary implements Comparable<Diary> {

    private int id;

    private String user;

    @NotNull
    private String note;

    @NotNull
    private Date date;

    @NotNull
    @Min(value = 0, message = "Mood should not be less than 0")
    @Max(value = 10, message = "Mood should not be greater than 10")
    private int mood;

    public Diary() {
    
        super();
    
    }
    
    public Diary(int id, String user, String note, Date date, int mood) {
    
        super();
        this.id = id;
        this.user = user;
        this.note = note;
        this.date = date;
        this.mood = mood;
    
    }

    public int getId() {
    
        return id;
    
    }

    public void setId(int id) {
    
        this.id = id;
    
    }

    public String getUser() {
    
        return user;
    
    }

    public void setUser(String user) {
    
        this.user = user;
    
    }

    public String getNote() {
    
        return note;
    
    }

    public void setNote(String note) {
    
        this.note = note;
    
    }

    public Date getDate() {
    
        return date;
    
    }

    public void setDate(Date date) {
    
        this.date = date;
    
    }

    public int getMood() {
    
        return mood;
    
    }

    public void setMood(int mood) {
    
        this.mood = mood;
    
    }

    @Override
    public boolean equals(Object obj) {
    
        if (this == obj) {
    
            return true;
    
        }
    
        if (obj == null) {
    
            return false;
    
        }
    
        if (getClass() != obj.getClass()) {
    
            return false;
    
        }
    
        Diary other = (Diary) obj;
    
        if (id != other.id) {
        
            return false;
        
        }
        
        return true;
    
    }

    @Override
    public int hashCode() {
    
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    
    }

    @Override
    public String toString() {
        
        return String.format("Diary [id=%s, user=%s, note=%s, date=%s, mood=%s]", id, user, note, date, mood);
    
    }

    @Override
    public int compareTo(Diary diary) {

        return diary.getDate().compareTo(date);

    }

}
