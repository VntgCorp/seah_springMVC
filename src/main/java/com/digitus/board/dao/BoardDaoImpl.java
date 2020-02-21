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
import com.digitus.board.vo.PagingTO;
@Deprecated
@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// board-mapper.xml에서 정의한 namespace 값을 지정한다.
	private static String NAMESPACE = "com.digitus.board.mapper.BoardMapper";

	@Override
	public void create(Board board) {
		sqlSession.insert(NAMESPACE + ".create", board);
	}

	@Override
	public List<Board> listAll(PagingTO pagingTO) throws Exception {
//		Map<String, PagingTO> paramMap = new HashMap<String, PagingTO>();
//		paramMap.put("pagingTO", pagingTO);
		return sqlSession.selectList(NAMESPACE + ".selectAll", pagingTO);
	}

	@Override
	public int listAllCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectAllCount");
	}

	@Override
	public Board read(int bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", bno);
	}

	@Override
	public void update(Board board) throws Exception {
		sqlSession.update(NAMESPACE + ".modify", board);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".remove", bno);
	}

	@Override
	public void hitUpdate(int bno) throws Exception {
		sqlSession.update(NAMESPACE + ".hitUpdate", bno);
	}

}
