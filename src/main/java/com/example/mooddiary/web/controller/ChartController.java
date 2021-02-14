package com.example.mooddiary.web.controller;

import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.example.mooddiary.web.service.ChartService;
 
@Controller
public class ChartController {
 
	@Autowired
	private ChartService chartService;
 
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
	
        List<List<Map<Object, Object>>> dataList = chartService.getChartData();
        modelMap.put("dataPointsList", dataList);
		return "chart";
	
    }
 
}                        
