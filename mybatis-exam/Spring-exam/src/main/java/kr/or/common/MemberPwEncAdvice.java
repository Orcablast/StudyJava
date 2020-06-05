package kr.or.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.member.model.vo.Member;

@Service
@Aspect
public class MemberPwEncAdvice {

	@Autowired
	@Qualifier("SHA256Util")
	private SHA256Util enc;
	
	@Pointcut("execution(* kr.or.member.model.service.MemberService.*Member(kr.or.member.model.vo.Member))")
	public void encPwPointcut() {}
	
	@Before("encPwPointcut()")
	public void passwordEnc(JoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		System.out.println(methodName+" 에 대하여 pw 암호화 실행");
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		
		if(m.getMemberPw() != null) {
			m.setMemberPw(enc.encData(m.getMemberPw()));
		}
	}
	
}
