package com.arotec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.arotec.dao.Rws_ds2Dao;
import com.arotec.vo.Rws_ds2Vo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import lombok.Setter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private Rws_ds2Dao rws_dsservice;

	private Rws_ds2Vo vo;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/rws_ds2", method = RequestMethod.GET)
	public String ds2(Locale locale, Model model) {
		
				
		return "rws_ds2";
	}
	
	@RequestMapping(value = "/wuiView", method = RequestMethod.GET)
	public String wuiView(Locale locale, Model model) {
		
				
		return "wuiView";
	}
	
	@RequestMapping(value = "/viewData", method = RequestMethod.POST)
	@ResponseBody //페이지 이동없이 데이터만 리턴
	public ResponseEntity<String> wuiView(Rws_ds2Vo rwsVo, HttpServletRequest req, HttpServletResponse res){
		
		//db데이터 select
		List<Rws_ds2Vo> rwsList=rws_dsservice.selectRwsds2();
		
		
		
		Gson gson = new Gson();
	    
		String result  = gson.toJson(rwsList);
	    
		HttpHeaders responseHeaders = new HttpHeaders();
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*");
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/wuiEdit", method = RequestMethod.GET)
	public String wuiEdit(Locale locale, Model model) throws Exception {
						

		
		return "wuiEdit";
	}
	
	
	
	@RequestMapping(value = "/dataModify", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> dataModify(String dataList, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("여기 탄다~~~~~~");	
			
		System.out.println(dataList);
	
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>(); 
		ObjectMapper mapper = new ObjectMapper(); 
		list=mapper.readValue(dataList,ArrayList.class); 
		for(int i=0; i<list.size(); i++){ 
			System.out.println ("FLOWMTR_ID==="+list.get(i).get("FLOWMTR_ID"));
			
			
			//LinkService.insertMenu(list.get(i)); //배열 파라미터순서대로 insert문 순차적 실행 }
		}
 
		Gson gson = new Gson();
	    
		
		System.out.println("list====="+list);
		List<Rws_ds2Vo> rwsList=rws_dsservice.selectRwsds2();
		//System.out.println("rwsList.get(1);======"+rwsList.get(1).getFLOWMTR_ID());
		int count=list.size();
		String map=null;
		String result=null;
		HashMap dMap=null;
		String key=null;
		Object value=null;
		for(Object item:list){
			dMap=(HashMap) item;
			System.out.println(dMap+"디맵");				
		}
		
		HashMap<String, Object> mapPut = new HashMap<>();
		
		Iterator<String> keys= dMap.keySet().iterator();
		
		while(keys.hasNext()){
			key = keys.next();
			value = dMap.get(key);
			System.out.println("key++++"+key+"value+++"+value);

			mapPut.put(key,value);			
		}
		
		map =rws_dsservice.setData(mapPut);
		System.out.println("map===="+mapPut);
		result = gson.toJson(map);
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
	    responseHeaders.add("Access-Control-Allow-Origin", "*");
	    
	    return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
	
	
}
}