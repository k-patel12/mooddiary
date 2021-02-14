package com.example.mooddiary.web.service;

import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartImpl implements Chart {
 
    @Autowired
    ChartData chartData;

	@Override
	public List<List<Map<Object, Object>>> getChartData() {
	
        chartData.setData();
        return chartData.getDataList();
	
    }
 
}    