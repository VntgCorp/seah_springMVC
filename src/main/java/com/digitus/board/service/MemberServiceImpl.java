/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Service 클래스
 * 게시판에서 사용되는 Service를 구현한다.
 * 
 * by Davis.
 */

package com.digitus.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitus.board.mapper.MemberMapper;
import com.digitus.board.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper dao;
	//private MemberDao dao;

	/** 멤버 상세 정보를 불러온다. */
	@Override
	public Member read(Member member) throws Exception {
		return dao.selectOne(member);
	}

	@Override
	public void signup(Member member) throws Exception {
		dao.create(member);
	}
}
