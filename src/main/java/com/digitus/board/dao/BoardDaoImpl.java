/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Dao 클래스
 * 게시판에 대한 데이터 요청을 처리한다.
 * 
 * by Davis.
 */

package com.digitus.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitus.board.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// board-mapper.xml에서 정의한 namespace 값을 지정한다.
	private static String NAMESPACE = "com.digitus.board.mapper.BoardMapper";

	@Override
	public void create(Board board) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", board);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public Board read(int bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", bno);
	}

	@Override
	public void update(Board board) throws Exception {
		sqlSession.update(NAMESPACE + ".update", board);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public void hitUpdate(int bno) throws Exception {
		sqlSession.update(NAMESPACE + ".hitUpdate", bno);
	}

}
