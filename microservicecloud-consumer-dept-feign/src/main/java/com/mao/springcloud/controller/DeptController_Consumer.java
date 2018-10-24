package com.mao.springcloud.controller;

import com.mao.springcloud.entities.Dept;
import com.mao.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/10/15/015.
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;


    @RequestMapping(value = "/feign/dept/add")
    public boolean add(@RequestBody  Dept dept){
         return deptClientService.add(dept);
    }

    @RequestMapping(value = "/feign/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/feign/dept/list")
    public List<Dept> list()
    {
        return deptClientService.list();
    }

}
