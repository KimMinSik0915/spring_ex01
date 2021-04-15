package org.zerock.notice.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.notice.service.NoticeService;
import org.zerock.notice.vo.NoticeVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/notice")
@Log4j
public class NoticeController {

	@Inject
	@Qualifier("nsi")
	private NoticeService service;
	
	private final String MODUEL = "notice";
	
	@GetMapping("/list")
	public String List(Model model) throws Exception {
		
		log.info(MODUEL + " list().................");
		
		model.addAttribute("list", service.list());
		
		return MODUEL + "/list";
		
	}
	
	@GetMapping("/write")
	public String write() throws Exception {
		
		log.info(MODUEL + " write()....");
		
		return MODUEL + "/write";
		
	}
	
	@PostMapping("/write")
	public String write(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		
		log.info(MODUEL + " write()....");
		
		log.info(vo + " write()....");
		
		service.write(vo);
		
		rttr.addFlashAttribute("msg", "등록에 성공하였습니다.");
		
		return "redirect:list.do";
		
	}
	
}
