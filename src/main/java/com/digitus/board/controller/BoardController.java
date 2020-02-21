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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitus.board.service.BoardService;
import com.digitus.board.vo.Board;
import com.digitus.board.vo.Paginator;
import com.digitus.board.vo.PagingTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	/** 게시판 목록 화면으로 이동 */
	@RequestMapping("")
	public String list(Model model, PagingTO pagingTO) throws Exception {

		Paginator paginator = null;
		
		pagingTO.setRowCountPerPage(5);//page 에 보여줄 리스트 수
		pagingTO.init();
		
		int totalCount = service.listAllCount();
		
		paginator = getPaginator(pagingTO.getPages(), pagingTO.getRowCountPerPage(), totalCount, 10, "goList"); // 10 : 페이징 영역에 보여줄 숫자의 개수

		model.addAttribute("list", service.listAll(pagingTO));
		model.addAttribute("paginator", paginator);
		return "board/list";
	}

	/**
	 * 게시글의 상세 페이지로 이동 한다.
	 * 
	 * bno (게시판 아이디) : url 경로중 /board/post/{bno} 위치에 있는 값을 사용하여 int형 게시판 아이디 값을 갖는다.
	 */
	@RequestMapping(value = "/post/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "board/view";
	}

	/**
	 * 게시글의 수정 페이지로 이동 한다.
	 * 
	 * bno (게시판 아이디) : url 경로중 /board/{bno} 위치에 있는 값을 사용하여 int형 게시판 아이디 값을 갖는다.
	 */
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "board/update";
	}

	/**
	 * 게시글의 작성 페이지로 이동한다.
	 */
	@RequestMapping("/write")
	public String write(Model model) throws Exception {
		return "board/write";
	}

	/**
	 * 게시글을 작성한다.
	 * 
	 * Board : write 페이지의 Form에서 입력된 값을 받는다.
	 */
	@RequestMapping("/add-board")
	public String addBoard(@ModelAttribute("board") Board board, Model model) {
		System.out.println(board);
		try {
			service.insert(board);
			model.addAttribute("message", "게시글 작성이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/board/list";
	}

	/**
	 * 작성된 게시물을 수정한다.
	 * 
	 * Board : write 페이지의 Form에서 입력된 값을 받는다.
	 */
	@RequestMapping("/update")
	public String modify(@ModelAttribute("board") Board board, Model model) {
		try {
			service.modify(board);
			model.addAttribute("message", "게시글 수정이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/list";
	}

	/**
	 * 게시물을 삭제 한다.
	 */
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") int bno, Model model) {
		try {
			service.delete(bno);
			model.addAttribute("message", "게시글 삭제가 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/list";
	}

	protected Paginator getPaginator(int pages, int countPerPage, int totalCount, Integer listCountLimit,
			String functionName) throws Exception {

		PagingTO pagingTO = new PagingTO();
		pagingTO.setPages(pages);
		pagingTO.setRowCountPerPage(countPerPage);
		pagingTO.setTotalRowCount(totalCount);

		if (totalCount % countPerPage == 0) {
			pagingTO.setTotalPageCount((totalCount / countPerPage));
		} else {
			pagingTO.setTotalPageCount((totalCount / countPerPage) + 1);
		}

		if (listCountLimit != null) {
			pagingTO.setListCountLimit(listCountLimit);
		}
		pagingTO.init();

		Paginator paginator = new Paginator(pagingTO);
		paginator.makeFrontPagingHtml(functionName);

		return paginator;
	}
}
