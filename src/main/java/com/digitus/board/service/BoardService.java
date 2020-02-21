/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Service 인터페이스
 * 게시판에서 사용되는 Service를 정의한다.
 * 
 * by Davis.
 */
package com.digitus.board.service;

import java.util.List;

import com.digitus.board.vo.Board;
import com.digitus.board.vo.PagingTO;

public interface BoardService {
	public List<Board> listAll(PagingTO pagingTO) throws Exception;
	
	public int listAllCount() throws Exception;

	public void insert(Board board) throws Exception;

	public Board read(int bno) throws Exception;

	public void modify(Board board) throws Exception;

	public void delete(int bno) throws Exception;

}
