package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@Controller		// 자동 생성하게 해주는 Annotation : component-scan 설정 : servlet-context.xml || root-context.xml
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	@Qualifier("bsi")
	private BoardService service;
	
	private final String MODUEL = "board";
	
	// 1. 게시판 리스트
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		
		log.info(MODUEL + " list()....");		
		
		model.addAttribute("list", service.list());
		
		return MODUEL + "/list";
		
	}
	
	// 2. 게시판 글 보기
	@GetMapping("/view")
	public String view(Model model, long no, int inc) throws Exception {
		
		log.info(MODUEL + "글 보기 -------------------------------");
		
		model.addAttribute("vo", service.view(no, inc));
		
		return MODUEL + "/view";
		
	}
	
	// 3. 게시판 등록 FORM
	@GetMapping("/write")
	public String writeForm() throws Exception {
		
		log.info(MODUEL + "리스트 -------------------------------");
		
		return MODUEL + "/write";
		
	}
	
	// 3-1 게시판 등록 처리
	@PostMapping("/write")
	public String write(BoardVO vo) throws Exception {
		
		log.info(MODUEL + "리스트 -------------------------------");
		
		return "redirect:list.do";
		
	}
	
	// 4. 게시판 수정 FORM
	@GetMapping("/update")
	public String updateForm(Model model) throws Exception {
		
		log.info(MODUEL + "리스트 -------------------------------");
		
		
		return MODUEL + "/update";
		
	}
	
	// 4-1 게시판 수정 처리
	@PostMapping("/update")
	public String update(BoardVO vo) throws Exception {
		
		log.info(MODUEL + "리스트 -------------------------------");
		
		
		return  "redirect:view.do?no=" + vo.getNo() + "&inc=0";
		
	}
	
	// 5. 게시판 삭제
	@GetMapping("/delete")
	public String delete(long no) throws Exception {
		
		log.info(MODUEL + "리스트 -------------------------------");
		
		
		return "redirect:list.do";
		
	}
	
}
