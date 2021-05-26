package com.arotec.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.arotec.mapper.Rws_ds2Mapper;
import com.arotec.vo.Rws_ds2Vo;


import lombok.Setter;

@Service
public class Rws_ds2DaoImpl implements Rws_ds2Dao {

	@Autowired
	private Rws_ds2Mapper rwsMapper;
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.arotec.mapper.Rws_ds2Mapper";

	
	
	@Override
	public List<Rws_ds2Vo> selectRwsds2() {
		
		
		return rwsMapper.selectRwsds2();
	}






	@Override
	public Rws_ds2Vo getAllSelect() {
		// TODO Auto-generated method stub
		return rwsMapper.getAllSelect();
	}






	@Override
	public String setData(HashMap<String, Object> map) {
		String msg = "true";
		try {
			sqlSession.update(namespace+".setData",map);
			
			//rwsMapper.setData(map);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="false";
		}
		return msg;
	}

















































/*	@Override
	public HashMap<String, Object> setData(@Param(value = "key") Set<String> key,@Param(value = "value") Object value) {
		// TODO Auto-generated method stub
		return rwsMapper.setData(key, value);
	}
*/


	






















	





	}
	

