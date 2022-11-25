package com.asnj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.asnj.mapper.MemberMapper;

@Controller
public class MainController {
	
	// 페이지 이동
	// 메인페이지 -> json 받아오려면 restcontroller 페이지에서 따로 지정해야 함
	// 메인 페이지에 비동기 통신이 들어가게 바뀌면 컨트롤러 타입을 변경하거나 이동할 예정
	@GetMapping("/Mainpage.do")
	public String Main() {
		System.out.print("main.jsp로 이동\n");
		return "main";
	}
	
	@GetMapping("/Introduce.do")
	public String Intro() {
		System.out.print("introduce.jsp로 이동\n");
		return "introduce";
	}
	
	@GetMapping("/Notice.do")
	public String Notice() {
		System.out.print("notice.jsp로 이동\n");
		return "notice";
	}
	
	@GetMapping("/Diary.do")
	public String Diary() {
		System.out.print("diary.jsp로 이동\n");
		return "diary";
	}
	
	@GetMapping("/Prediction.do")
	public String Prediction() {
		System.out.print("prediction.jsp로 이동\n");
		return "prediction";
	}
	
	@GetMapping("/Disease.do")
	public String Disease() {
		System.out.print("disease.jsp로 이동\n");
		return "disease";
	}
	
	@GetMapping("/Pests.do")
	public String Pests() {
		System.out.print("pests.jsp로 이동\n");
		return "pests";
	}
	
	@PostMapping("/PredictionInfoPage.do")
	public String PredictionInfoPage() {
		System.out.print("prediction_Info.jsp로 이동\n");
		return "prediction_Info";
	}
	
	@GetMapping("/Questions.do")
	public String Questions() {
		System.out.print("questions.jsp로 이동\n");
		return "questions";
	}
	
	@GetMapping("/Loginpage.do")
	public String Loginpage() {
		return "login";
	}
	
	@GetMapping("/Joinpage.do")
	public String Joinpage() {
		return "join";
	}
	@GetMapping("/Mypage.do")
	public String Mypage() {
		return "mypage";
	}

}
