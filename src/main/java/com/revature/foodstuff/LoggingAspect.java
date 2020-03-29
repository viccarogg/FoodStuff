package com.revature.foodstuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
	
	@After("execution(* com.revature.foodstuff.controller.EmailController.home(..)))")
	public void checkSentEmail() {
		
		LOGGER.info("Email has been sent");
	}
	
	@After("(execution(* com.revature.foodstuff.controller.UserController.*(..)))")
	public void logUserControllerAction() {
		
		LOGGER.info("method in User Controller Completed successfully");
		
	}
	
	@After("(execution(* com.revature.foodstuff.controller.CommentController.*(..)))")
	public void logCommentControllerAction() {
		
		LOGGER.info("method in Comment Controller Completed successfully");
		
	}
	
	@After("(execution(* com.revature.foodstuff.controller.PostController.*(..)))")
	public void logPostControllerAction() {
		
		LOGGER.info("method in User Controller Completed successfully");
		
	}
	
	
	

}
