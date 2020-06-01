package kr.or.iei.notice.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.iei.notice.model.dao.NoticeDao;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticePageData;

@Service("noticeService")
public class NoticeService {

	@Autowired
	@Qualifier("noticeDao")
	private NoticeDao dao;
	
	public int insertNotice(Notice n) {
		return dao.insertNotice(n);
	}

	public NoticePageData noticeList(int reqPage) {
		
		int totalCount = dao.countNotice();
		
		int numPerPage = 10;
		
		int totalPage = 0;
		
		if(totalCount % numPerPage == 0) {
			totalPage = totalCount/numPerPage; 
		} else {
			totalPage = totalCount/numPerPage +1;
		}
		
		int start = (reqPage - 1)*numPerPage+1;
		int end = reqPage*numPerPage;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("end", end);
		
		List list = dao.selectNoticeList(map); 
		
		StringBuffer pageNavi = new StringBuffer();
		
		int pageNaviSize = 5;
		int pageNo = 1;
		
		if(pageNo != 1) {
			pageNavi.append("<a href='/noticeList.do?reqPage="+(pageNo-1)+"'>이전</a>");
		}
		
		for(int i=0; i<pageNaviSize; i++) {
			if(reqPage==pageNo) {
				pageNavi.append("<span>"+pageNo+"</span>");
			} else {
				pageNavi.append("<a href='/noticeList.do?reqPage="+pageNo+"'>"+pageNo+"</a>");
			}
			
			pageNo++;
			
			if(pageNo > totalPage) {
				break;
			}			
		}
		
		if(pageNo <= totalPage) {
			pageNavi.append("<a href='noticeList.do?reqPage="+(pageNo)+"'>다음</a>");
		}
			
		
		return new NoticePageData((ArrayList<Notice>)list, pageNavi.toString());
	}

	public Notice selectOneNotice(Notice n) {
		return dao.selectOneNotice(n);
	}

	public int deleteNotice(Notice n) {		
		return dao.deleteNotice(n);
	}

}
