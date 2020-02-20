package com.wjg;
import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wujianguang.domain.ArticleWithBLOBs;
import com.wujianguang.util.FileUtilIO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:producer.xml")
public class SendArticles2Kafka {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;


	@Test
	public void testSendArticles() throws Exception {
		File file = new File("D:/Articles");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			String title = file2.getName().replace(".txt", "");
			String content = FileUtilIO.readFile(file2, "utf8");
			ArticleWithBLOBs awb = new ArticleWithBLOBs();
			awb.setTitle(title);
			awb.setContent(content);
			String jsonString = JSON.toJSONString(awb);
			kafkaTemplate.send("articles",jsonString);
			
		}
	}
	
	
	
}
