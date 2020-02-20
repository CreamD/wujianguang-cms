package com.wjg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wujianguang.dao.ArticleMapper;
import com.wujianguang.dao.ArticleRepository;
import com.wujianguang.domain.Article;
import com.wujianguang.service.ArticleService;
import com.wujianguang.utils.StreamUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class TestMysqlDB2ES {
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticleMapper articleMapper;
	
	@Test
	public void importES() {
		Article article = new Article();
		article.setStatus(1);
		PageInfo<Article> selects = articleService.selects(article, 1, 1000);
		articleRepository.saveAll(selects.getList());
	}
	
	@Test
	public void add() {
		List<Article> all = articleMapper.all();
		articleRepository.saveAll(all);
	}
	
	@Test
	public void insert() throws IOException {
		File file=new File("D:Articles");
		InputStream ips=new FileInputStream(file);
		Article article=new Article();
		List<String> read = StreamUtil.read(ips);
		for (String string : read) {
			String[] split = string.split(",");
			article.setTitle(string);
		}
	}
	
	
}
