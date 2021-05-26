package com.arotec.mapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.arotec.vo.Rws_ds2Vo;


public interface Rws_ds2Mapper {
	
	public List<Rws_ds2Vo> selectRwsds2();	
	public Rws_ds2Vo getAllSelect();
	public String setData(HashMap<String, Object> map);
	//public void setData(@Param(value = "key") String key, @Param(value = "value") Object FMETE_FORM);

}
