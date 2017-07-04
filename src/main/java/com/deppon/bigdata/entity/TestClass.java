package com.deppon.bigdata.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("TESTCLASS")
public class TestClass {
	/*
     * 设置属性显示
     */
    @XStreamAsAttribute
    @XStreamAlias("名称")
    private String name;

    private List<User> users = new ArrayList<User>();


    private int num = 0;
    
	public String getName() {
		return name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
    
    
}
