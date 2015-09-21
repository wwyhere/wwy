package service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import test.BaseSpringTest;

public class Example extends BaseSpringTest {

    // inject the actual template

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOps;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Test
    public void addLink() {
    	Set<String> sets=redisTemplate.opsForSet().members("spring:session:expirations:1432940400000");
    	for (String iterable_element : sets) {
			System.out.println("spring:session:expirations的值:"+iterable_element);
		}
        // valueOps.set(userId, url);
        // listOps.leftPush(userId, url);
        // redisTemplate.boundListOps(new
        // String(redisTemplate.getStringSerializer().serialize(userId))).leftPush(new
        // String(redisTemplate.getStringSerializer().serialize(url)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        if (redisTemplate.hasKey("list")) {
            redisTemplate.delete("list");
        }
        if (redisTemplate.hasKey("user.userid.1")) {
            redisTemplate.delete("user.userid.1");
        }
        if (redisTemplate.hasKey("hash")) {
            redisTemplate.delete("hash");
        }
        System.out.println("---------start------------");
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("中文1");
        listOps.rightPushAll("list", list);
        List<String> rList = redisTemplate.opsForList().range("list", 0, -1);
        for (String str : rList) {
            System.out.println(str);
        }
        redisTemplate.opsForValue().set("user.userid.1", "中文2");
        String str = redisTemplate.opsForValue().get("user.userid.1");
        System.out.println(str);
        redisTemplate.opsForHash().put("hash", "list", list);
        Object obj = redisTemplate.opsForHash().get("hash", "list");
        List<String> temp = (List<String>) obj;
        for (String t : temp) {
            System.out.println(t);
        }
        String listIndex2 = redisTemplate.boundListOps("list").index(2);
        System.out.println(listIndex2);
        List<String> temp2 = (List<String>) redisTemplate.boundHashOps("hash").get("list");
        for (String t : temp2) {
            System.out.println(t);
        }
        System.out.println("----------end-----------");
    }
}
