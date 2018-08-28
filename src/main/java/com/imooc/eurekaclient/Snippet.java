package com.imooc.eurekaclient;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Snippet { 
	@RequestMapping("/exportSellPlan")
	    public @ResponseBody void exportSellPlan(Long id,HttpServletRequest request,HttpServletResponse response){
	        Calendar calendar = Calendar.getInstance();// 取当前日期。
	        if(id!=null){
	            SellPlan plan=new SellPlan();
	             //获得数据  
	            Map<String, Object> map = new HashMap<String, Object>(); 
	            map.put("bYear", plan.getBusinessYear()!=null?plan.getBusinessYear():"");
	            map.put("lYear", plan.getLiveYear()!=null?plan.getLiveYear():"");
	            map.put("leader",plan.getLeader()!=null?plan.getLeader():""); 
	            map.put("phone", plan.getPhone()!=null?plan.getPhone():"");
	            map.put("curYear", calendar.get(Calendar.YEAR)+"");
	            try {
	                WordUtils.exportMillCertificateWord(request,response,map,"方案","sellPlan.ftl");
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }    
	        }
	    }
}

