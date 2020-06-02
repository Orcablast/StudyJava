package kr.or.iei.notice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticePageData;

@Controller
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private NoticeService service;
	
	@RequestMapping(value = "/modifyNotice.do")
	public String modifyNotice(Notice n, HttpServletRequest request, Model m, MultipartFile file) {
		
		File f = null;
		
		if(file != null && !file.isEmpty()) {
			// 저장 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/notice/");
			
			// 저장한 실제 파일명
			String originFileName = file.getOriginalFilename();
			
			// 확장자를 제외한 파일명
			String onlyFileName = originFileName.substring(0,originFileName.lastIndexOf("."));
			
			// 파일의 확장자
			String extension = originFileName.substring(originFileName.lastIndexOf("."));
			
			String filepath = onlyFileName+"_"+getCurrentTime()+extension;
			
			String fullpath = savePath+filepath;
			
			try {
				byte[] bytes = file.getBytes();
				
			} catch (IOException e) {
			}
		}
		
		
		return null;
	}
	
	
	@RequestMapping(value = "/modifyNoticeFrm.do")
	public String modifyNoticeFrm(Notice n, Model m) {
		
		Notice selectNotice = service.selectOneNotice(n);
		m.addAttribute("n", selectNotice);
		
		return "notice/modifyNotice";
	}
	
	@RequestMapping(value = "/deleteNotice.do")
	public String deleteNotice(Notice n, Model m) {
		
		int result = service.deleteNotice(n);
		
		if(result>0) {
			m.addAttribute("msg","게시글 삭제 성공");
			m.addAttribute("loc","/noticeList.do?reqPage=1");
		} else {
			m.addAttribute("msg","게시글 삭제 실패");
			m.addAttribute("loc","/noticeView.do?noticeNo="+n.getNoticeNo());
		}
		return "common/msg";
	}
	
	@RequestMapping(value = "/noticeView.do")
	public String noticeView(Notice n, Model m) {
		
		Notice selectNotice = service.selectOneNotice(n);
		
		m.addAttribute("n",selectNotice);
		
		return "notice/noticeView";
	}
	
	@RequestMapping(value = "/noticeList.do")
	public String noticeList(String reqPage, Model m) {
		
		NoticePageData pd = service.noticeList(Integer.parseInt(reqPage));
		
		m.addAttribute("list", pd.getList());
		m.addAttribute("pageNavi",pd.getPageNavi());
		
		return "notice/noticeList";
	}
	
	@RequestMapping(value="/noticeWriteFrm.do")
	public String noticeWriteFrm() {
		return "notice/noticeFrm";
	}
	
	@RequestMapping(value = "/noticeWrite.do")
	public String noticeWrite(HttpServletRequest request, MultipartFile file, Notice n, Model m) {
		System.out.println(n.getNoticeTitle());
		System.out.println(n.getNoticeWriter());
		System.out.println(n.getNoticeContent());
		
		File f = null;
		
		if(!file.isEmpty()) {
			// 저장 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/notice/");
			
			// 업로드한 파일의 실제 파일명
			String originFileName = file.getOriginalFilename();
			
			// 확장자를 제외한 파일명
			String onlyFilename = originFileName.substring(0,originFileName.lastIndexOf("."));
			
			// 확장자 -> .txt
			String extension = originFileName.substring(originFileName.lastIndexOf("."));
			
			String filepath = onlyFilename+"_"+getCurrentTime()+extension;
			
			String fullpath = savePath+filepath;
			
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fullpath)));
				bos.write(bytes);
				bos.close();
				System.out.println("파일 업로드 완료");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			n.setFilename(originFileName);
			n.setFilepath(filepath);
			f = new File(fullpath);
		}
		
		
		int result = service.insertNotice(n);
		
		if(result>0) {
			m.addAttribute("msg", "등록 성공");
			m.addAttribute("loc","/");
			
		} else {
			if(f != null && f.exists()) {
				f.delete();
				System.out.println("파일 삭제됨");
			}

			m.addAttribute("msg", "등록 실패");
			m.addAttribute("loc","/");
		}
		
		return "common/msg";
	}
	
	public long getCurrentTime() {
		Calendar today = Calendar.getInstance();		
		return today.getTimeInMillis();
	}
	
}
