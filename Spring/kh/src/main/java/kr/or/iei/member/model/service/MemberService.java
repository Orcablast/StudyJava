package kr.or.iei.member.model.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	public int memberRegister(HashMap<String, String> paraMap) {
		
		if(paraMap.get("userid") == null) {
			throw new NullPointerException();
		}
		System.out.println("회원 아이디 : "+paraMap.get("userid"));
		System.out.println("비밀번호 : "+paraMap.get("passwd"));
		System.out.println("회원 이름 : "+paraMap.get("name"));
		System.out.println("이메일 주소 : "+paraMap.get("email"));
		System.out.println("전화번호 : "+paraMap.get("tel"));
		
		return 0;
	}
	
	
}
