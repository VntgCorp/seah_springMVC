/*
 * Copyright 2020 The Spring Example Project
 * 
 * 단순 로그인을 구현하기 위한 Service 인터페이스
 * 로그인에서 사용되는 Service를 정의한다.
 * 
 * by Davis.
 */
package com.digitus.board.service;

import com.digitus.board.vo.Member;

public interface MemberService {

	public Member read(Member member) throws Exception;

	public void signup(Member member) throws Exception;

	public void update(Member member) throws Exception;

}
