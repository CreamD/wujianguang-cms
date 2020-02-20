package com.wujianguang.service;

import com.github.pagehelper.PageInfo;
import com.wujianguang.domain.Collect;
import com.wujianguang.domain.Comment;

public interface CollectService {
	/**
	 * 增加收藏
	 * @Title: insert 
	 * @Description: TODO
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Collect collect);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询评论
	 * @param comment
	 * @return
	 * @return: List<Comment>
	 */
	PageInfo<Collect> selects(Collect collect,Integer page,Integer pageSize);
	
	void del(Integer id);
	
	
	
}
