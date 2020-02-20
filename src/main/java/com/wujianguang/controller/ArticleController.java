package com.wujianguang.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wujianguang.dao.ArticleRepository;
import com.wujianguang.domain.Article;
import com.wujianguang.util.HLUtils;
/**
 * 
 * @ClassName: ArticleController 
 * @Description: TODO
 * @author: 吴村长
 * @date: 2019年12月11日 上午11:23:02
 */
@RequestMapping("article")
@Controller
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;

	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	
	@GetMapping("selects")
	public String selects() {
		return "admin/article/articles";
		
	}
	
	@RequestMapping("serach")
	public String serach(String key,Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "2")Integer pageSize) {
		/*
		 * List<Article> list = articleRepository.findByTitle(key); PageInfo<Article>
		 * info = new PageInfo<Article>(list); model.addAttribute("info", info);
		 */
		long start = System.currentTimeMillis();
	    PageInfo<Article> info = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize,new String[] {"title"}, "id", key);
		long end = System.currentTimeMillis();
		System.err.println("es查询一共花费了"+(end-start)+"毫秒");
	    model.addAttribute("info", info);
		model.addAttribute("key", key);
		return "index/index";
	}
	
	@RequestMapping("light")
	public String light(String key,Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = 
	"2")Integer pageSize){
		long start = System.currentTimeMillis();
		PageInfo<?> info = HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize, new String[] {"title"}, "id", key);
		long end = System.currentTimeMillis();
		System.out.println("es一共消耗:"+(end-start)+"ms");
		model.addAttribute("info", info);
		model.addAttribute("key", key);
		
		return "index/index";
		
	}
	

}
