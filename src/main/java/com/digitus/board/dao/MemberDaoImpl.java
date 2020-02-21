/*
 * Copyright 2020 The Spring Example Project
 * 
 * 단순 로그인을 구현하기 위한 Dao 클래스
 * 로그인에 대한 데이터 요청을 처리한다.
 * 
 * by Davis.
 */

package com.digitus.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitus.board.vo.Member;

@Deprecated
@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// member-mapper.xml에서 정의한 namespace 값을 지정한다.
	private static String NAMESPACE = "com.digitus.board.mapper.MemberMapper";

	@Override
	public Member read(Member member) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", member);
	}

}
