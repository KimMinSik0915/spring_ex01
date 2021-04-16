package org.zerock.board.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

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
	// @ModelAttribute : 전달 받은 변수의 값을 model에 담아서 JSP까지 보낸다 => 변수 이름으로 사용한다.
	public String list(Model model, @ModelAttribute PageObject pageObject) throws Exception {
		
		log.info(MODUEL + " list()....");		
		
		log.info(pageObject + " list()....");		
		
		model.addAttribute("list", service.list(pageObject));
		
		return MODUEL + "/list";
		
	}
	
	// 2. 게시판 글 보기
	@GetMapping("/view")
	public String view(Model model, long no, int inc,  @ModelAttribute PageObject pageObject) throws Exception {	// 처리된 Data를 JSP에 전달 || no & inc = 숫자 Type : 원래는 String Type으로 Data 전달, 없으면 null => null을 숫자로 변환하는 과정에서 오류가 발생
		
		log.info(MODUEL + " view -------------------------------");
		
		model.addAttribute("vo", service.view(no, inc));
		
		return MODUEL + "/view";
		
	}
	
	// 3. 게시판 등록 FORM
	@GetMapping("/write")
	public String writeForm() throws Exception {
		
		log.info(MODUEL + " writeForm() -------------------------------");
		
		return MODUEL + "/write";
		
	}
	
	// 3-1 게시판 등록 처리
	@PostMapping("/write")
	public String write(BoardVO vo, RedirectAttributes rttr, int perPageNum) throws Exception {
		
		log.info(MODUEL + " write() -------------------------------");
		
		log.info(vo + " write()-------------------------------");
		
		service.write(vo);
		
		rttr.addFlashAttribute("msg", "게시판 글 등록이 완료되었습니다.");
		
		return "redirect:list.do?perPageNum=" + perPageNum;
		
	}
	
	// 4. 게시판 수정 FORM
	@GetMapping("/update")
	public String updateForm(Model model, Long no) throws Exception {
		
		log.info(MODUEL + " updateForm() -------------------------------");
		
		log.info(no + " updateForm() -------------------------------");
		
		model.addAttribute("vo", service.view(no, 0));
		
		return MODUEL + "/update";
		
	}
	
	// 4-1 게시판 수정 처리
	@PostMapping("/update")
	public String update(BoardVO vo, RedirectAttributes rttr, @ModelAttribute PageObject pageObject) throws Exception {
		
		log.info(MODUEL + " update() -------------------------------");
		
		log.info(vo + " update() -------------------------------");
		
		int result = service.update(vo);
		
		if(result == 0) {
			
			rttr.addFlashAttribute("msg", "비밀번호가 맞지 않습니다. 비밀번호를 확인해 주세요");
			
		} else {
			
			rttr.addFlashAttribute("msg", "글 수정이 완료되었습니다.");
			
		}
		
		log.info(result + " update() -------------------------------");
		
		// URL로 요청되는 경우 서버의 한글이 적용되므로 UTF-8로 encode 시켜서 보내야 한다.
		return  "redirect:view.do?no=" + vo.getNo() + "&inc=0&page=" + pageObject.getPage() + "&perPageNum=" + pageObject.getPerPageNum() + "&key=" + pageObject.getKey() + "&word=" + URLEncoder.encode(pageObject.getWord(), "UTF-8") ;
		
	}
	
	// 5. 게시판 삭제
	@PostMapping("/delete")
	public String delete(BoardVO vo, RedirectAttributes rttr, int perPageNum) throws Exception {
		
		log.info(MODUEL + " delete() -------------------------------");
		
		int result =  service.delete(vo);
		
		if(result == 0) {
			
			rttr.addFlashAttribute("msg", "비밀번호가 맞지 않습니다. 비밀번호를 확인해 주세요");
			
			return  "redirect:view.do?no=" + vo.getNo() + "&inc=0";
			
		} else {
			
			rttr.addFlashAttribute("msg", "글 삭제가 완료되었습니다.");
			
			return "redirect:list.do?perPageNum=" + perPageNum;
		}
		
		
	}
	
}
