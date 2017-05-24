package com.buddy.cron;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.context.support.WebApplicationContextUtils;


public class Cron implements ServletContextListener {
    private Thread t = null;
    
	
    private ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
    	
    	WebApplicationContextUtils
        .getRequiredWebApplicationContext(contextEvent.getServletContext())
        .getAutowireCapableBeanFactory()
        .autowireBean(this);
    	
        t =  new Thread(){
            //task
            public void run(){                
                try {
                    while(true){
                    	
                    	
                    }
                } catch (Exception e) {
                	
                	
                	
                	System.out.println(e.getMessage());
                }
            }            
        };
        t.start();
        context = contextEvent.getServletContext();
        // you can set a context variable just like this
        context.setAttribute("TEST", "TEST_VALUE");
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {
      
    	
        t.interrupt();
    }            
}
