package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data	// 자동으로 getter // setter // toString // 생성자 생성
public class SampleDTOList {

	private List<SampleDTO> list;
	
	public SampleDTOList() {
		
		list = new ArrayList<>();
		
	}
	
}
