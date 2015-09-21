package wwy.biz.impl;

import org.springframework.stereotype.Service;

import wwy.biz.TestBiz;

@Service("testBiz")
public class TestBizImpl implements TestBiz {

    public String getHello(String sayStr) {
        return "hello " + sayStr + "!";
    }
}
