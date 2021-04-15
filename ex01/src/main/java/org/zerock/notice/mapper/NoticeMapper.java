package org.zerock.notice.mapper;

import java.util.List;

import org.zerock.notice.vo.NoticeVO;

public interface NoticeMapper {

	public List<NoticeVO> list();
	
	public long getTotalRow();
	
	public NoticeVO view(long no);
	
	public int write(NoticeVO vo);
	
	public int update(NoticeVO vo);
	
	public int delete(long no);
	
}
