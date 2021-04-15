package org.zerock.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.notice.vo.NoticeVO;

@Service
public interface NoticeService {

	public List<NoticeVO> list() throws Exception;
	
	public long getTotalRow() throws Exception;
	
	public NoticeVO view(long no) throws Exception;
	
	public int write(NoticeVO vo) throws Exception;
	
	public int update(NoticeVO vo) throws Exception;
	
	public int delete(long no) throws Exception;
	
}
