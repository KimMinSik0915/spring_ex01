package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

/*자동 생성 : @Controller, @Service(처리), @Repository(DB), @RestController, @Component(이것저것),  @Advice(에외가 발생하였을 때 예외처리를 하기 위해서 사용)
servlet-context.xml에 component-scan으로 설정되어 있어야 한다.*/

@Controller // URL과 실행을 Mapping : RestMapping, getMapping, postMapping
@RequestMapping("/sample") // Mapping이 중복되면 서버가 동작하지 않는다.
@Log4j
public class SampleController {

	@RequestMapping("") // return type이 void이면 JSP정보가 없으므로 URL 자체가 JSP정보가 된다.
	// EX : /localhost/board/list일 경우 return을 void로 지정할 수 있다.
	public void basic() {

		log.info("basic ------------------------");

	}

	// get 방식으로 넘어오는 URL 받기
	// /smaple/basic
	@RequestMapping(value = "/basic", method = { RequestMethod.GET })
	public void basicGet() {

		log.info("basic get -----------------------------");

	}

	// get 방식으로 넘어오는 URL 받기 : @GetMapping(URL)
	// /sample/basicGet
	@GetMapping("/basicGet")
	public void basicGet2() {

		log.info("basic get : 2 -----------------------------------");

	}

	// get 방식으로 넘어오는 URL 받기 : /sample/ex02
	// get 방식으로 넘어오는 Data 받기 : 이름과 나이
	// URL : localhost/sample/ex02?name=kim&age=28
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {

		log.info("name : " + name);
		
		log.info("age : " + age);
		
		// WEB-INF/views + ex02 + .jsp
		return "ex02";

	}
	
	@GetMapping("/ex03")
	public String ex03(String name, int age) {
		
		log.info("ex03() ----------------------------------- ");
		
		log.info("name : " + name);
		
		log.info("age : " + age);
		
		// WEB-INF/views + ex02 + .jsp
		return "ex03";
		
	}
	
	// ArrayList로 Data 받기
	// /sample/ex02List?ids=111&ids=222&ids=333
	// ArrayList는 @RequsetParam이 없으면 Data를 받아올 수 없다.
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("ids : " + ids);
		
		return "ex02List";
		
	}
	
	// ArrayList로 Data 받기
	// /sample/ex02List?ids=111&ids=222&ids=333
	@GetMapping("/ex01List")
	public String ex01List(ArrayList<String> ids) {
		
		log.info("ids : " + ids);
		
		return "ex01List";
		
	}
	
	// ArrayList로 Data 받기
	// /sample/ex02List?ids=111&ids=222&ids=333
	// String[]인 경우 이름만 맞으면 Data를 받아 올 수 있다.
	@GetMapping("/ex03List")
	public String ex03List(String[] ids) {
		
		for(String s : ids) {
			
			log.info("ids : " + s);
			
		}
		
		return "ex03List";
		
	}
	
	// /sample/ex02DTO?name=test
	@GetMapping("/ex02DTO")
	public String ex02DTO(SampleDTO dto) {
		
		log.info("dto : " + dto);
		
		return "ex02DTO";
		
	}
	
	// /sample/ex02Bean[0].name=park&[1].name=im : [ ] = URL로 주소로 사용할 수 없다.
	// /sample/ex02Bean?%5B0%5D.name=park&%5B1%5D.name=im : 따라서 [ 대신 %5B를, ]는 %5D로 사용해야 한다.
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list : " + list);
		
		return "ex02Bean";
		
	}
	
	// @ModelAttribute test
	// /WEB-INF/views/sample/ex04.jsp
	//  @ModelAttribute("page") int page : 넘어오는 Data 데이터를 받아서 바로 Model에 넣어준다.
	// JSP로 Page 정보를 바로 넘겨줄 수 있다. 
	@GetMapping("/ex04")
	public void ex04(@ModelAttribute("dto") SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto : " + dto);
		
		log.info("page : " + page);
		
	}	
	
	// 객체 타입의 데이터를 순수 데이터로 전송 -> JSON Data 활용
	// 순수한 데이터를 전달하는 mehtod만 모아서 RestController를 만든다.
	// /sample//ex06
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		
		log.info("ex06 ... dto Date Return");
		
		SampleDTO dto = new SampleDTO();
		
		dto.setName("홍길동");
		dto.setAge(10);
		
		return dto;
		
	}
	
	// 처리된 상태코드와 함께 보내는 ResponseEntity Type
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		
		log.info("ex06 ... ResponseEntity return.....");
		
		String msg = "{'name':'홍길동'}";
		
		HttpHeaders header = new HttpHeaders();
		
		header.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
		
	}
	
	// File Upload Form
	@GetMapping("/exUpload")
	public void exUpload() {
		
		log.info("/exUpload.. input Form.....");
		
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			
			if(!file.getOriginalFilename().equals("") && file.getSize() > 0) {
				
				log.info("[upload File List] -------------------------------------");
				
				log.info("name : " + file.getOriginalFilename());
				
				log.info("size : " + file.getSize());
				
			}
			
		});
		
		// 반복문(for-each) : 람다식을 이용
		/*
		 * for(MultipartFile file : files) {
		 * 
		 * log.info("[upload File List] -------------------------------------");
		 * 
		 * log.info("name : " + file.getOriginalFilename());
		 * 
		 * log.info("size : " + file.getSize());
		 * 
		 * }
		 */
		 
	}
	
	// Model&View : Method에서 생성해서 Date를 담은 후 돌려준다
	@GetMapping("/mav")
	public ModelAndView exMav() {
		
		ModelAndView mav = new ModelAndView();
		
		// Model.addAttirbute와 동일
		mav.addObject("name", "김민식");		// Data 담기 -> Model 대신 사용
		
		// return mav와 동일
		mav.setViewName("mav");		// jsp 정보 담기
		
		return mav;
	}
	
	@GetMapping("/map")
	public void map() {
		
		
		
	}
	
}