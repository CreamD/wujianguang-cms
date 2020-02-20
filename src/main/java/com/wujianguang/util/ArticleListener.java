package com.wujianguang.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wujianguang.dao.ArticleRepository;
import com.wujianguang.domain.Article;
import com.wujianguang.domain.ArticleWithBLOBs;
import com.wujianguang.service.ArticleService;
public class ArticleListener implements MessageListener<String, String>{
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticleRepository articleRepository;
	
	
	public void onMessage(ConsumerRecord<String, String> data) {
		String jsonString = data.value(); 
		if(jsonString.startsWith("add")) {
			ArticleWithBLOBs awb = JSON.parseObject(jsonString.substring(4, jsonString.length()), ArticleWithBLOBs.class);
			System.err.println("添加到es");
			awb.setStatus(1);
			articleRepository.save(awb);
		}
	}
	

}
