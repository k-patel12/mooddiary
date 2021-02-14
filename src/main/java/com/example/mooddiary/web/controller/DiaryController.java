package com.example.mooddiary.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mooddiary.web.model.Diary;
import com.example.mooddiary.web.service.DiaryService;

@Controller
public class DiaryController {

    @Autowired
    DiaryService diaryService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }

    @RequestMapping(value = "/diaryList", method = RequestMethod.GET)
    public String showDiaryList(ModelMap model) {

        String name = getLoggedInUsername();
        model.put("diaryList", diaryService.retrieveDiary(name));
        return "diaryList";

    }

    private String getLoggedInUsername() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails) {

            return ((UserDetails) principal).getUsername();

        }

        return principal.toString();

    }

    @RequestMapping(value = "/add-diary", method = RequestMethod.GET)
    public String showAddDiaryPage(ModelMap model) {

        model.addAttribute("diary", new Diary(0, getLoggedInUsername(), "Default Note", new Date(), 10));
        return "diary";
    
    }

    @RequestMapping(value = "/delete-diary", method = RequestMethod.GET)
    public String deleteDiary(ModelMap model, @RequestParam int id) {

        diaryService.deleteDiary(id);
        return "redirect:/diaryList";

    }
    
    @RequestMapping(value = "/update-diary", method = RequestMethod.GET)
    public String showUpdateDiaryPage(ModelMap model, @RequestParam int id) {
    
        Diary diaryUpdate = diaryService.getDiary(id);
        model.addAttribute("diary", diaryUpdate);
        return "diary";
    
    }
    
    @RequestMapping(value = "/update-diary", method = RequestMethod.POST)
    public String updateDiary(ModelMap model, @Valid Diary diary, BindingResult result) {
    
        if(result.hasErrors()) {
    
            return "diary";
    
        }
    
        diary.setUser(getLoggedInUsername());
        diaryService.updateDiary(diary);
        return "redirect:/diaryList";
    
    }

    @RequestMapping(value = "/add-diary", method = RequestMethod.POST)
    public String addDiary(ModelMap model, @Valid Diary diary, BindingResult result) {
        
        if(result.hasErrors()) {
        
            return "diary";
        
        }
        
        diaryService.addDiary(getLoggedInUsername(), diary.getNote(), diary.getDate(), diary.getMood());
        return "redirect:/diaryList";
    
    }

}
