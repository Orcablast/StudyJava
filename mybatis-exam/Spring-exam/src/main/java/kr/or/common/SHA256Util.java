package kr.or.common;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("SHA256Util")
public class SHA256Util {
	
	
	
	public SHA256Util() {
		super();
	}

	public String encData(String data) throws Throwable{
		
		// MessageDigest를 이용한 암호화
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		
		// pw값을 바이트 배열로 변경하여 mDigest에 입력
		mDigest.update(data.getBytes());
		
		// SHA-256으로 업데이트된 데이터를 byte배열로 가져옴
		byte[] msgStr = mDigest.digest();
		
		// -128~127 -> 16진수 00~FF값으로 변경
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<msgStr.length; i++) {			
			sb.append(Integer.toString((msgStr[i] & 0xff)+0x100,16).substring(1));
		}
		
		return sb.toString();
	}
}
