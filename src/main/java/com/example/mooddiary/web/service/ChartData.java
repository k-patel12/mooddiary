package com.example.mooddiary.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.mooddiary.web.model.Diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ChartData {
 
	private Map<Object,Object> map = null;
	private List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	private List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
    private List<Diary> diaryList = new ArrayList<Diary>();

    @Autowired
    DiaryService diaryService;

	public void setData() {

        list.clear();
        diaryList = diaryService.retrieveDiary(getLoggedInUsername());

        for (Diary diary : diaryList) {

            map = new HashMap<Object,Object>();
            map.put("x", diary.getDate().getTime());
            map.put("y", diary.getMood());
            dataPoints.add(map);
            
        }
 
		list.add(dataPoints);
	
    }
 
	public List<List<Map<Object, Object>>> getDataList() {
	
        return list;
	
    }

    private String getLoggedInUsername() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails) {

            return ((UserDetails) principal).getUsername();

        }

        return principal.toString();

    }

}                        