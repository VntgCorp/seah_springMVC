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

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	MemberService service;
	
	/**
	 * .
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		logger.debug("" + request.getSession().getAttribute("member"));
		if (request.getSession().getAttribute("member") != null) {
			return "redirect:board/list";
		}
		
		
		return "account/login";
	}
	
	@RequestMapping(value = "/login-check", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
		
		try {
			Member result = service.read(member);
			if (result == null) {
				model.addAttribute("message", "로그인에 실패 하였습니다.");
				return "account/login";
			} else {
				request.getSession().setAttribute("member", result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "account/login";
		}
		
		return "redirect:board";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().setAttribute("member", null);
		model.addAttribute("message", "로그아웃 되었습니다.");
		return "account/login";
	}
	
	@RequestMapping(value = "/login-fail", method = RequestMethod.GET)
	public String loginFail(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("message", "로그인 후 이용해 주시기 바랍니다.");
		return "account/loginWarning";
	}
	
}
