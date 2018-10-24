package com.mao.springcloud.entities;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor //无参
//@AllArgsConstructor   //全参
@Setter //添加属性set方法
@Getter //添加属性get方法
@ToString //toString方法
@Accessors(chain=true) // 支持链式写法  dept.setDeptno(111L).setDname("RD").setDb_source("DB01");
public class Dept implements Serializable {    // entity --orm--- db_table
	
	private static final long serialVersionUID = 1L;

    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname)
    {
        super();
        this.dname = dname;
    }


}
