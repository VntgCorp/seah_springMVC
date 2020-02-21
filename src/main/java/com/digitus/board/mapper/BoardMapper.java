/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Dao 인터페이스
 * 게시판에 대한 데이터 요청을 정의한다.
 * 
 * by Davis.
 */

package com.digitus.board.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.digitus.board.vo.Board;
import com.digitus.board.vo.PagingTO;

@Mapper
public interface BoardMapper {
	public void create(Board board) throws SQLException;

	public List<Board> selectAll(PagingTO pagingTO) throws SQLException;

	public Board selectOne(int bno) throws SQLException;

	public void modify(Board board) throws SQLException;

	public void remove(int bno) throws SQLException;

	public void hitUpdate(int bno) throws SQLException;

	public int selectAllCount() throws SQLException;

}
