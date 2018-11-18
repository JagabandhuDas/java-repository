package com.security.SpringBootSecurity.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.security.SpringBootSecurity.controller.EmployeeController;

@Component
@Aspect
public class EmployeeControllerAspect {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	//It will join the advice on all class within the specified package which annotated with RestController
	@Pointcut("@target(org.springframework.web.bind.annotation.RestController)")
    public void targetRestControllers(){}
 
    
	
    //@Before("within(com.security.SpringBootSecurity.controller..*)")
    @Before("within(com.security.SpringBootSecurity.controller..*) && targetRestControllers()")
    private void before(JoinPoint joinPoint){
        String caller = joinPoint.getSignature().toShortString();
        
        logger.info(caller + " method called.");
    }
	 
	
}
