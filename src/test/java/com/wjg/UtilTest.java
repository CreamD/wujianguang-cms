package com.wjg;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wujianguang.dao.CollectMapper;
import com.wujianguang.domain.Collect;
import com.wujianguang.util.StringUtil;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class UtilTest {
	@Autowired
	private CollectMapper collectMapper;
	/*URL路径判断*/
	@Test
	public void testURL() {
		String str="123456789";
		String httpUrl = StringUtil.isHttpUrl(str);
		System.out.println(httpUrl);
	}
	
	
	/**
	 * 测试按时间倒序查询收藏
	 */
	@Test
	public void testOrder() {
		Collect collect = collectMapper.selectByPrimaryKey(23);
		List<Collect> selects = collectMapper.selects(collect);
		for (Collect collect2 : selects) {
			System.out.println(collect2);
		}
	}
	
	/*测试添加收藏*/
	@Test
	public void addCollect() {

		
		try {
			Collect collect=new Collect();
			collect.setUser_id(150);
			collect.setText("123");
			collect.setUrl("http://localhost/article?id=279");
	        String url = StringUtil.isHttpUrl(collect.getUrl());
	        collectMapper.insert(collect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
