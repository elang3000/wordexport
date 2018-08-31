package com.imooc.eurekaclient;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordexportController {
	
	
	@RequestMapping("/exportcgqs")
    public @ResponseBody void exportCGQS(HttpServletRequest request,HttpServletResponse response){
             //获得数据  
            Map<String, Object> map = new HashMap<String, Object>(); 
            map.put("munit", "长工局");
            map.put("myear", "2008");
            map.put("mnumb", "123");
            map.put("msigner", "张三");
            map.put("mexpnm", "李四");
            map.put("mcgtotal", "100");
            map.put("mmonth", "5");
            map.put("mday", "11");
            

            try {
                WordUtils.exportMillCertificateWord(request,response,map,"方案","cgqs.ftl");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }    
    }
	
	@RequestMapping("/exportcgsh")
	public @ResponseBody void exportCGSH(HttpServletRequest request,HttpServletResponse response){
		//获得数据  
		Map<String, Object> map = new HashMap<String, Object>(); 

		map.put("mexpnm", "李四");
		map.put("mtotal", "100");
		map.put("mtotaltoz", "40");
		map.put("mtotaltozn", "60");
		map.put("myear", "2008");
		map.put("mmonth", "5");
		map.put("mday", "11");
		
		
		try {
			WordUtils.exportMillCertificateWord(request,response,map,"方案","cgsh.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	@RequestMapping("/exportgwyqs")
	public @ResponseBody void exportGWYQS(HttpServletRequest request,HttpServletResponse response){
		//获得数据  
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("nunit", "长江三峡");
		map.put("nexpnm", "李四");
		map.put("ntotal", "100");
		map.put("nyear", "2008");
		map.put("nmonth", "5");
		map.put("nday", "11");
		map.put("nnumb", "12");
		map.put("nsigner", "张飞");
		
		
		try {
			WordUtils.exportMillCertificateWord(request,response,map,"方案","gwyqs.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	@RequestMapping("/exportgwysh")
	public @ResponseBody void exportGWYSH(HttpServletRequest request,HttpServletResponse response){
		//获得数据  
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("nexpnm", "李四");
		map.put("ntotal", "100");
		map.put("nyear", "2008");
		map.put("nmonth", "5");
		map.put("nday", "11");
		map.put("ntotaltoz", "12");
		map.put("ntotaltozn", "78");
		
		
		try {
			WordUtils.exportMillCertificateWord(request,response,map,"方案","gwysh.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	
	
	/*//获得图片的base64码
    @SuppressWarnings("deprecation")
    public String getImageBase(String src,HttpServletRequest request,HttpServletResponse response) {
        if(src==null||src==""){
            return "";
        }
        File file = new File(request.getRealPath("/")+src.replace(request.getContextPath(), ""));
        if(!file.exists()) {
            return "";
        }
        InputStream in = null;
        byte[] data = null;  
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {  
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        } catch (IOException e) {  
          e.printStackTrace();  
        } 
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }*/
}
