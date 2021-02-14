package com.example.mooddiary.web.service;
 
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class ChartServiceImpl implements ChartService {
 
	@Autowired
	private Chart chart;
 
	public void setChart(Chart chart) {
	
        this.chart = chart;
	
    }
 
	@Override
	public List<List<Map<Object, Object>>> getChartData() {
	
        return chart.getChartData();
	
    }
 
}                        
