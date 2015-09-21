/*
 * Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * FileName: TestController.java
 * Author:   weiyi.wang
 * Date:     2015年5月29日 下午3:21:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wwy.controller.BaseController;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author weiyi.wang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

	@SuppressWarnings("unused")
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/{id}")
	public String view(@PathVariable("id") Long id) {
		return id + "";
	}
}
