package com.wujianguang.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wujianguang.domain.Article;



public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
	List<Article> findByTitle(String key);
	  
			//按照标题或者内容查询,方法名称一定要按照规则写
//			List<ArticleWithBLOBs> findByTitleOrContent(String title,String content);
	

}
