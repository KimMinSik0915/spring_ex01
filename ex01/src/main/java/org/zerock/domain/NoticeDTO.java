package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// NoticeVO 와 동일한 역할을 한다.
@Data
public class NoticeDTO {

	private long no;
	
	private String title, content;
												// 날짜를 입력할 때에만 해당
	@DateTimeFormat(pattern = "yyyy-MM-dd")		// 화면의 날짜 형식은 String Type이므로 날짜 형식에 맞지 않기 때문에 형식을 맞춰주어야 한다.
	private Date startDate, endDate, writeDate, updateDate;
	
}
