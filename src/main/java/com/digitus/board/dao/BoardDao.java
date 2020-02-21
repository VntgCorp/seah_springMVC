/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Dao 인터페이스
 * 게시판에 대한 데이터 요청을 정의한다.
 * 
 * by Davis.
 */

package com.digitus.board.dao;

import java.util.List;

import com.digitus.board.vo.Board;
import com.digitus.board.vo.PagingTO;
@Deprecated
public interface BoardDao {
	public void create(Board board) throws Exception;

	public List<Board> listAll(PagingTO pagingTO) throws Exception;

	public Board read(int bno) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(int bno) throws Exception;

	public void hitUpdate(int bno) throws Exception;

	public int listAllCount() throws Exception;

}
