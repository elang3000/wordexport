package com.imooc.eurekaclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordexportController {
	
	@GetMapping("hello")
	public String exportWord(){
		return "123";
	}
	
	@RequestMapping("/exportSellPlan")
    public @ResponseBody void exportSellPlan(Long id,HttpServletRequest request,HttpServletResponse response){
        Calendar calendar = Calendar.getInstance();// 取当前日期。
             //获得数据  
            Map<String, Object> map = new HashMap<String, Object>(); 
            map.put("bYear", 1);
            map.put("lYear", 2);
            map.put("leader",3); 
            map.put("phone", 4);
            map.put("curYear", 5);
            try {
                WordUtils.exportMillCertificateWord(request,response,map,"方案","sellPlan.ftl");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }    
    }
	
	@RequestMapping("/exportExcel")
	@ResponseBody
	public void exportExcel(HttpServletRequest request,HttpServletResponse response) {
		List<Servant> list=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			Servant servant=new Servant();
			servant.setSerialNumber(i);
			servant.setName("张三1");
			servant.setIdCardNumb(System.currentTimeMillis()+"");
			servant.setEmployNumb(System.currentTimeMillis()+"");
			servant.setXl("小学"+i);
			servant.setIsShanghai("是的");
			servant.setIsGraduating("是的");
			servant.setIsDesc("奥斯迪加多久哦爱上的"+this.hashCode());
			list.add(servant);
		}

		Map<String,Object> map=new HashMap<>();
		map.put("size",10 );
		map.put("list", list);
		
		try {
			ExcelUtils.exportMillCertificateWord(request, response, map, "aaa", "dwshhz.ftl");
		} catch (IOException e) {
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
