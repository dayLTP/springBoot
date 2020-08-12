package com.day.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName: HelloWorldController 
 * @Description: (HelloWorld)
 * @author Day   
 * @date 2020年8月10日 上午11:57:02
 */
@RestController
@Slf4j
public class HelloWorldController {
	/**
	 * 
	 * @Title: hello
	 * @Description:TODO (测试)
	 * @param @return    设定文件
	 * @author Day  
	 * @date 2020年8月10日 上午11:57:32
	 * @return String  返回值类型
	 * @throws
	 */
	@RequestMapping("/hello")
	public static String hello() {
		System.out.println("你好！ 世界！");
		log.info("ssssssssss");
		return "你好！ 世界！";
		 
	}
}
