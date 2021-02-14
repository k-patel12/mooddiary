package com.example.mooddiary.web.service;

import java.util.List;
import java.util.Map;
 
public interface ChartService {
 
	List<List<Map<Object, Object>>> getChartData();
 
}