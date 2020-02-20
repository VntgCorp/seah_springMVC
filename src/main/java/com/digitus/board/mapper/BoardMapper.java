/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Mapper 인터페이스
 * board-mapper.xml에 정의 되어있는 기능에 접근하여 데이터를 처리한다. 
 * 
 * board-mapper.xml에 입력된 Query Set의 ID와 Method명 과 파라미터, 리턴 타입이 동일하다.
 * 
 * by Davis.
 */

package com.digitus.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.digitus.board.vo.Board;

@Mapper
public interface BoardMapper {
	public void create(Board board) throws Exception;

	public List<Board> listAll() throws Exception;

	public Board read(int bno) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(int bno) throws Exception;

	public void hitUpdate(int bno) throws Exception;

}
