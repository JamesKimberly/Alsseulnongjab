package com.asnj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asnj.entity.Member;
import com.asnj.mapper.MemberMapper;


@Controller
public class MainController {
	
	@Autowired
	private MemberMapper mapper;
	
	// 페이지 이동
	// 메인페이지 -> json 받아오려면 restcontroller 페이지에서 따로 지정해야 함
	// 메인 페이지에 비동기 통신이 들어가게 바뀌면 컨트롤러 타입을 변경하거나 이동할 예정
	@GetMapping("/Mainpage.do")
	public String Main() {
		System.out.print("main.jsp로 이동\n");
		return "main";
	}
	
	@GetMapping("/introduce.do")
	public String Intro() {
		System.out.print("introduce.jsp로 이동\n");
		return "introduce";
	}
	
	@GetMapping("/notice.do")
	public String Notice() {
		System.out.print("notice.jsp로 이동\n");
		return "notice";
	}
	
	@GetMapping("/Loginpage.do")
	public String Loginpage() {
		return "logintest";
	}
	
	@GetMapping("/Joinpage.do")
	public String Joinpage() {
		return "jointest";
	}
	
	@GetMapping("/Memberpage.do")
	public String Memberpage() {
		return "membertest";
	}
	
	// 기능 
	// 로그인 기능
	@PostMapping("/Login.do")
	public String Login(Member mem, HttpServletRequest request) {
		// 입력받은 id, pw와 같은 정보가 있는지 확인하고 그 값에 해당하는
		// 회원의 정보를 가져온다.
		Member loginMember = mapper.memberLogin(mem);
		
		// 만약에 회원의 정보를 가져왔다면, 즉 로그인 할 회원의 정보가 있다면
		// 세션에 저장
		if(loginMember != null) {
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 2. 세션에 값 저장(회원정보 데이터를 객체 바인딩)
			session.setAttribute("loginMember", loginMember);
		}
		return "redirect:/Loginpage.do";
	}
	
	// 회원가입 기능 --> 라디오 박스 관련으로 공부해야 함
	@PostMapping("/Join.do")
	public String Join(Member mem) {
		
		int joinMember = mapper.memberJoin(mem);
		
		if(joinMember > 0) {
			return "redirect:/Mainpage.do";
		} else {
			System.out.println("회원가입 실패!");
			return "redirect:/Joinpage.do";	
		}
	}
	
	// 로그아웃 기능
	@RequestMapping("/Logout.do")
	public String Logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/Mainpage.do";
	}
	
	

}
