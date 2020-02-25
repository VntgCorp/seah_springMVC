/*
 * Copyright 2020 The Spring Example Project
 * 
 * 단순 로그인을 구현하기 위한 Dao 인터페이스
 * 로그인시에 데이터 요청을 정의한다.
 * 
 * by Davis.
 */

package com.digitus.board.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.digitus.board.vo.Member;

@Mapper
public interface MemberMapper {

	public Member selectOne(Member member) throws SQLException;

	public void create(Member member) throws SQLException;

	public void update(Member member) throws SQLException;
}
