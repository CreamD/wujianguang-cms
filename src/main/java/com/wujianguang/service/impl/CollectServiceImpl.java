package com.wujianguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujianguang.dao.CollectMapper;
import com.wujianguang.domain.Collect;
import com.wujianguang.domain.Comment;
import com.wujianguang.service.CollectService;
@Service
public class CollectServiceImpl implements CollectService {
	@Autowired
	private CollectMapper collectMapper;
	
	@Override
	public int insert(Collect collect) {
		// TODO Auto-generated method stub
		return collectMapper.insert(collect);
	}

	@Override
	public PageInfo<Collect> selects(Collect collect, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<Collect> list = collectMapper.selects(collect);
		return new PageInfo<Collect>(list);
	}

	@Override
	public void del(Integer id) {
		collectMapper.del(id);
		
	}

}
