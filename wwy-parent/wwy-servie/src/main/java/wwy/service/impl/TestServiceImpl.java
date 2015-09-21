package wwy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wwy.biz.TestBiz;
import wwy.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestBiz testBiz;

    public void sayHello(String sayStr) {
        System.out.println(testBiz.getHello(sayStr));
    }
}
