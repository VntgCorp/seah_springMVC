/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 게시판 정보 클래스
 * 게시판에서 사용되는 Model을 정의 한다.
 * 
 * by Davis.
 */

package com.digitus.board.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	private int mid;
	private String userId;
	private String name;
	private String password;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modified;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	
}
