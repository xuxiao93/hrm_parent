package com.xurui.hrm.service;

import com.xurui.hrm.domain.Systemdictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISystemdictionaryServiceTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;
    @Test
    public void test() throws Exception{
        for (Systemdictionary systemdictionary : systemdictionaryService.selectList(null)) {
            System.out.println(systemdictionary);
        }
    }
}