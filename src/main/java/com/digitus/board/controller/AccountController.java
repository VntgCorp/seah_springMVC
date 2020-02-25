/*
 * Copyright 2020 The Spring Example Project
 * 
 * 회원정보 관련 요청을 처리하기위한 Controller 클래스
 * 화면의 요청에 따른 페이지 전환과 각 페이지별 기능 요청을 처리 한다.
 * 
 * by Davis.
 */


package com.digitus.board.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitus.board.service.MemberService;
import com.digitus.board.vo.Member;

@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	MemberService service;
	
	/**
	 * 로그인 페이지로 이동. session에 이미 로그인 정보가 있는 경우 게시판 목록으로 이동.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		logger.debug("" + request.getSession().getAttribute("member"));
		if (request.getSession().getAttribute("member") != null) {
			return "redirect:/board";
		}
		
		
		return "account/login";
	}

	/**
	 * 로그인 처리.
	 * 화면에서 제공된 Id, password 로 로그인 한다.
	 */
	@RequestMapping(value = "/login-check", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
		
		try {
			Member result = service.read(member);
			if (result == null) {
				model.addAttribute("message", "로그인에 실패 하였습니다.");
				return "redirect:/login";
			} else {
				request.getSession().setAttribute("member", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "account/login";
		}
		
		return "redirect:board";
	}
	
	/**
	 * 회원 추가 페이지로 이동
	 * */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
		return "account/signup";
	}
	
	/**
	 * 회원 가입 처리
	 * id, password, name 정보를 받아 회원 가입 처리.
	 * */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
		
		try {
			service.signup(member);
		} catch (Exception e) {
			model.addAttribute("message", "회원 가입에 실패 하였습니다.");
			e.printStackTrace();
		}
		model.addAttribute("message", "회원 가입이 완료 되었습니다.");
		return "account/loginWarning";
	}
	
	/**
	 * 회원 정보 수정 페이지로 이동.
	 * session에 로그인 정보가 없으면 로그인 페이지로 이동시킨다.
	 * */
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String memberUpdatePage(Model model, HttpServletRequest request) {
		try {
			Member result = (Member) request.getSession().getAttribute("member");
			if (result == null) {
				model.addAttribute("message", "사용자 정보가 없습니다.");
				return "redirect:/login";
			}
			model.addAttribute("member", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "account/update";
	}
	
	/**
	 * 회원 정보 수정 처리
	 * id, name을 받아 해당 id의 사용자 정보를 업데이트 한다.
	 * */
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String memberUpdate(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
		
		try {
			service.update(member);
			request.getSession().setAttribute("member", member);
		} catch (Exception e) {
			model.addAttribute("message", "회원정보 수정에 실패 하였습니다.");
			e.printStackTrace();
		}
		model.addAttribute("message", "회원정보 수정이 완료 되었습니다.");
		return "account/loginWarning";
	}
	
	/**
	 * 로그아웃 처리.
	 * session만 null 처리 하여 로그아웃 한다.
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().setAttribute("member", null);
		model.addAttribute("message", "로그아웃 되었습니다.");
		return "account/loginWarning";
	}
	
	
	/**
	 * 로그인 실패 처리.
	 * */
	@RequestMapping(value = "/login-fail", method = RequestMethod.GET)
	public String loginFail(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("message", "로그인 후 이용해 주시기 바랍니다.");
		return "account/loginWarning";
	}
	
}
