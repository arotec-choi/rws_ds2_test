/**
 * 
 */
package com.arotec.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.arotec.vo.Rws_ds2Vo;


/**
 * @author 최수혁
 *
 */
public interface Rws_ds2Dao {
	public List<Rws_ds2Vo> selectRwsds2();
	public Rws_ds2Vo getAllSelect();	
	public String setData(HashMap<String, Object> map);
	
	
}
