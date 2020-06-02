package kr.or.iei.notice.model.vo;

import java.util.ArrayList;

public class NoticePageData {
	ArrayList<Notice> list;
	String pageNavi;
	public NoticePageData(ArrayList<Notice> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public NoticePageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Notice> getList() {
		return list;
	}
	public void setList(ArrayList<Notice> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
}
