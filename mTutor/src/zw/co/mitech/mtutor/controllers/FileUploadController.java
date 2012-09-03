package zw.co.mitech.mtutor.controllers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import zw.co.mitech.mtutor.entities.User;

import com.csvreader.CsvReader;

@Controller
public class FileUploadController {
	
	
	/*@SuppressWarnings("static-access")
	@RequestMapping(value={"/user/uploaduser","/user/uploadfile/"},method=RequestMethod.POST)
	public ModelAndView uploadfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	 
	   
	 
	    try {
	        if (servletFileUpload.isMultipartContent(request)) {
	 
	            @SuppressWarnings("rawtypes")
	            List fileItemsList = servletFileUpload.parseRequest(request);
	 
	            @SuppressWarnings("rawtypes")
	            Iterator it = fileItemsList.iterator();
	            while (it.hasNext()) {
	                FileItem actualFile = (FileItem) it.next();
	 
	                String name = actualFile.getName();
	                File fileTodDisc = new File(name);
	 
	                fileTodDisc = new File("c:/uploads/" + fileTodDisc.getName());
	 
	                actualFile.write(fileTodDisc);
	 
	                *//**
	                 * Open and file the csv file
	                 * *//*
	 
	                FileReader freader = new FileReader(fileTodDisc);
	                CsvReader csvReader = new CsvReader(freader);
	                String[] headers = null;           
	 
	                if(csvReader.readHeaders()) {
	                     headers = csvReader.getHeaders();
	                     logger.info("------- HEADERS OF FILE ------------");
	                     for(int i=0;i<headers.length;i++) {
	                         logger.info(headers[i]);
	                     }
	                     logger.info("-----------------------------------------------------");
	                }          
	 
	                logger.info("------- READING EACH LINE - EACH USER ------------");
	                while(csvReader.readRecord()) {
	                    String firstname = csvReader.get(headers[0]);
	 
	                    User user = new User();   
	 
	                    user.setFirstName(firstname);
	                    user.setLastName(lastname);
	                    user.setEmail(email);
	                    user.setTelephone(telephone);
	                    user.setAddress(address);
	                    user.setStatus(1);
	                    user.setRegDate(new java.util.Date());                        
	 
	                    this.userService.persist(user);
	 
	                    logger.info("User =" + user );
	                }
	                logger.info("-----------------------------------------------------");
	            }
	        }
	 
	    } catch (FileUploadException ex) {
	        logger.error("Can't Upload Files.");
	        ex.printStackTrace();
	    } catch (Exception ex) {
	        logger.error("Can't Upload Files.");
	        ex.printStackTrace();
	    }
	    return new ModelAndView("user/csvok");
	}
*/
}
