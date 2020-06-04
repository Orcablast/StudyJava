package kr.or.iei.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import kr.or.iei.member.model.vo.Member;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* kr.or.iei..MemberService.*(kr.or.iei.member.model.vo.Member))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		
		// 비지니스 메소드를 수행, 리턴값을 obj에 저장
		Object obj = pjp.proceed(); 
		
		stopwatch.stop();
		System.out.println(methodName+" 메소드 수행시간 : "+stopwatch.getTotalTimeMillis());
		
		return obj;
	}
	
//	@AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
//	public void afterThrowingAdvice(JoinPoint jp, Exception exceptObj) {
//		String methodName = jp.getSignature().getName();
//		System.out.println(methodName+" 메소드 호출");
//		System.out.println("예외 : "+exceptObj);
//		
//	}
	
//	@AfterReturning(pointcut = "allPointcut()", returning = "returnObj")	
//	public void afterReturningAdvice(JoinPoint jp, Object returnObj) {
//		String methodName = jp.getSignature().getName();
//		
//		System.out.println(methodName+" 메소드 호출");
//		if(returnObj instanceof Member) {
//			Member m = (Member)returnObj;
//			System.out.println("["+m.getMemberName()+"] 님이 로그인하셨습니다.");
//		}
//	}
	
//	@Before("allPointcut()")
//	public void printLog(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		
//		Member m = (Member)args[0];
//		
//		System.out.println(methodName);
//		System.out.println(m);
//		System.out.println(m.getMemberId());
//		System.out.println(m.getMemberPw());
//	}
}
