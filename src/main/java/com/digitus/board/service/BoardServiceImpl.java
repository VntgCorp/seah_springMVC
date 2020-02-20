/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Service 클래스
 * 게시판에서 사용되는 Service를 구현한다.
 * 
 * by Davis.
 */

package com.digitus.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitus.board.dao.BoardDao;
import com.digitus.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;

	/** 게시글 전체 목록을 불러온다. */
	@Override
	public List<Board> listAll() throws Exception {
		return dao.listAll();
	}

	/** 게시글을 등록 한다. */
	@Override
	public void insert(Board board) throws Exception {
		dao.create(board);
	}

	/** 게시글 상세 정보를 불러온다.
	 *  상세 정보 요청시 해당 게시글의 hit 값을 증가 시킨다.
	 * */
	@Override
	public Board read(int bno) throws Exception {
		dao.hitUpdate(bno);
		return dao.read(bno);
	}
	
	/** 게시글을 수정한다. */
	@Override
	public void modify(Board board) throws Exception {
		dao.update(board);
	}

	/** 게시글을 삭제 한다. */
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
}
