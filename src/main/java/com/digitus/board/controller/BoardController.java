/*
 * Copyright 2020 The Spring Example Project
 * 
 * 간단한 게시판을 구현하기 위한 Controller 클래스
 * 화면의 요청에 따른 페이지 전환과 각 페이지별 기능 요청을 처리 한다.
 * 
 * by Davis.
 */

package com.digitus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitus.board.service.BoardService;
import com.digitus.board.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	/** 게시판 목록 화면으로 이동 */
	@RequestMapping("")
	public String list(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
		return "board/list";
	}

	/** 
	 * 게시글의 상세 페이지로 이동 한다.
	 * 
	 * bno (게시판 아이디) : url 경로중 /board/{bno} 위치에 있는 값을 사용하여 int형 게시판 아이디 값을 갖는다.
	 */
	@RequestMapping("/{bno}")
	public String read(@PathVariable("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "board/view";
	}

	/** 
	 * 게시글의 수정 페이지로 이동 한다.
	 * 
	 * bno (게시판 아이디) : url 경로중 /board/{bno} 위치에 있는 값을 사용하여 int형 게시판 아이디 값을 갖는다.
	 */
	@RequestMapping("/update/{bno}")
	public String update(@PathVariable("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "board/update";
	}

	/** 
	 * 게시글의 작성 페이지로 이동한다.
	 */
	@PostMapping("/write")
	public String write(Model model) throws Exception {
		return "board/write";
	}

	/** 
	 * 게시글을 작성한다.
	 * 
	 * Board : write 페이지의 Form에서 입력된 값을 받는다.
	 */
	@PostMapping("/add-board")
	public String addBoard(@ModelAttribute("board") Board board) throws Exception {
		System.out.println(board);
		service.insert(board);
		return "board/list";
	}

	/**
 	 * 작성된 게시물을 수정한다.
 	 * 
 	 * Board : write 페이지의 Form에서 입력된 값을 받는다.
	 */
	@RequestMapping("/update")
	public String modify(@ModelAttribute("board") Board board) throws Exception {
		service.modify(board);
		return "board/list";
	}

	/** 
	 * 게시물을 삭제 한다. 
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("bno") int bno) throws Exception {
		service.delete(bno);
		return "board/list";
	}

}
