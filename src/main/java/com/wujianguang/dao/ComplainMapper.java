package com.wujianguang.dao;

import java.util.List;

import com.wujianguang.domain.Complain;
import com.wujianguang.vo.ComplainVO;

public interface ComplainMapper {
	
	int insert(Complain complain);
	
	//查询举报
	List<Complain> selects(ComplainVO complainVO);

}
