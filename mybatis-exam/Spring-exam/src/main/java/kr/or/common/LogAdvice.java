package kr.or.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* kr.or..*Service.*(..))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		String methodName = pjp.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		// 비지니스 메소드를 수행, 리턴값을 obj에 저장
		Object obj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println("["+methodName+"] 수행시간 : "+stopwatch.getTotalTimeMillis());
		
		
		return obj;
	}
	
	
}
