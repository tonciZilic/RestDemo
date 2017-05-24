 package com.buddy.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.buddy.model.User;

import com.buddy.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


import scala.util.parsing.json.JSONObject;

@Api(value  ="/api", description = "User service")
@Controller
public class UserApiController {
	
	@Autowired  
	UserService userService;
	
	
	String encodedKey="oFmTm2sriYFMEiCaIvGhVg==";

	
	@Autowired
	private HttpServletRequest context;
	
	
	/**
	 * Insert record for registered User.
	 * @param registeredUser
	 * @return
	 */
	@RequestMapping(value = { "/api/registration.json" }, method = { RequestMethod.GET } , headers="Accept=application/xml, application/json")  
	@ResponseBody
    public User createUser(HttpServletRequest request, HttpServletResponse response) {  
     	String userId ="0";
     	
     	User registeredUser=new User();
     	String jsonInString="";
     	try {  
        	
        	
        	registeredUser.setUsername(request.getParameter("username"));
    		 registeredUser.setName(request.getParameter("name"));
    		 registeredUser.setPassword(request.getParameter("password"));
    		 
    		 
    		 
    		 System.out.println(request.getParameter("username")+","+request.getParameter("name")+","+request.getParameter("password"));
    		 
    		 
    		 registeredUser=  userService.insertNewUser(registeredUser);
    		 
    		
     	
   
        	
        	
        	
        	
        	
			
	         
       	 
       	 
       	 
			
				
        	
         } catch (Exception e) {  
        	
        	 System.out.println(e.getMessage());
         }  
         return registeredUser;
    }  
	
	
	@RequestMapping(value = { "/api/deleteuser.json" }, method = { RequestMethod.GET } , headers="Accept=application/xml, application/json")  
	@ResponseBody
    public User DeleteUser(HttpServletRequest request, HttpServletResponse response) {  
     	String userId ="0";
    	User registeredUser =new User();
    	
    	String jsonInString="";
     	try {  
     		
     		registeredUser.setUsername(request.getParameter("username"));	
        	registeredUser=  userService.DeleteUser(registeredUser);
        	
        	
           
        	
        	
         } catch (Exception e) {  
        	 e.printStackTrace();
         }  
         return registeredUser;
    }  
	
	
	
	
	
	
	@RequestMapping(value = { "/api/updateinfo.json" }, method = { RequestMethod.GET } , headers="Accept=application/xml, application/json")  
	@ResponseBody
    public User UpdateInfo(HttpServletRequest request, HttpServletResponse response) {  
     	int userId = 1;
     	
     	User registeredUser=new User();
     	String jsonInString="";
     	try {  
     		
     		
     		
     		 registeredUser.setUsername(request.getParameter("username"));
     		 registeredUser.setName(request.getParameter("name"));
     		
        	 userId = userService.UpdateInfo(registeredUser);
        	 
        	 
        	 
            registeredUser.setOperation_status(userId);
        	
        	
        	 
         } catch (Exception e) {  
        	 e.printStackTrace();
         }  
     	return registeredUser;
    }  
	
	
	

	
	
	
	@RequestMapping(value = { "/api/getuser.json" }, method = { RequestMethod.GET } , headers="Accept=application/xml, application/json")  
	@ResponseBody
    public User getUserDetails(HttpServletRequest request, HttpServletResponse response) {  
		User registeredUser = null;
		
		String jsonInString="";
		
		User reg=new User();
         try {  
         
        	 reg.setUsername(request.getParameter("username"));
        	 registeredUser = userService.getUser(reg.getUsername());
        	 
        	
         } catch (Exception e) {  
              e.printStackTrace();
         }  
         return registeredUser;
    } 
	
	
	
	
	
	
	
	
	
	
}
