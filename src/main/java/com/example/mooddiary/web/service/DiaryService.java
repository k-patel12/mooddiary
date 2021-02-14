package com.example.mooddiary.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mooddiary.web.model.Diary;

@Service
public class DiaryService {

    private static List<Diary> diaryList = new ArrayList<>();

    static {

        diaryList.add(new Diary(1, "user", "Played a game", new Date(), 9));
        diaryList.add(new Diary(2, "user", "Cooked some food", new Date(), 7));
        diaryList.add(new Diary(3, "user", "Revised all day", new Date(), 3));
    
    }

    public List<Diary> retrieveDiary(String user) {
        
        List<Diary> filteredDiary = new ArrayList<>();
        
        for (Diary diary : diaryList) {
        
            if (diary.getUser().equals(user)) {
        
                filteredDiary.add(diary);
        
            }
    
        }
        
        Collections.sort(filteredDiary);

        return filteredDiary;
    
    }

    public void addDiary(String name, String note, Date date, int mood) {
        
        diaryList.add(new Diary(diaryList.size() + 1, name, note, date, mood));
        Collections.sort(diaryList);
    
    }

    public void deleteDiary(int id) {
    
        Iterator<Diary> iterator = diaryList.iterator();
        
        while (iterator.hasNext()) {
        
            Diary diary = iterator.next();
        
            if (diary.getId() == id) {
        
                iterator.remove();
        
            }
    
        }

        Collections.sort(diaryList);
    
    }
    
    public Diary getDiary(int id) {
        
        Diary requestedDiary = null;
        Iterator<Diary> iterator = diaryList.iterator();
    
        while (iterator.hasNext()) {
    
            Diary diary = iterator.next();
    
            if (diary.getId() == id) {
    
                requestedDiary = diary;
                break;
    
            }
    
        }
    
        return requestedDiary;
    
    }
    
    public void updateDiary(Diary diary) {
    
        diaryList.remove(diary);
        diaryList.add(diary);
        Collections.sort(diaryList);

    }

}
