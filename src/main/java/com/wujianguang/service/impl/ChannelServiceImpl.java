package com.wujianguang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wujianguang.dao.CategoryMapper;
import com.wujianguang.dao.ChannelMapper;
import com.wujianguang.domain.Category;
import com.wujianguang.domain.Channel;
import com.wujianguang.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channerMapper;
	
	@Resource
	private CategoryMapper categoryMapper;

	public List<Channel> selects() {
		return channerMapper.selects();
	}

	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectsByChannelId(channelId);
	}

}
