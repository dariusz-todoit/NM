package com.example.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.example.Message;
import com.example.NMInterface;
import com.example.Project;
import com.example.client.MessageService;
// import java.io.IOException;
// import java.io.InputStream;
// import java.net.MalformedURLException;
import java.util.ArrayList;
// import java.util.Properties;

import javax.ejb.EJB;
// import javax.servlet.ServletContext;
import javax.servlet.ServletException;
// import com.todoit.training.server.DbMgmt;



public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
  NMInterface dbmgmt; 
	
  public MessageServiceImpl() {
    super();
  }

    
  // Properties prop = new Properties();
  
  public void init() throws ServletException {
    
    
  }
    
  
  public ArrayList<Message> getMessages () {
    
    ArrayList<Message> messageList = new ArrayList<Message> ();
    
    for (Object[] row : dbmgmt.getNotes()) {
    	Message message = new Message ((Integer) row[0], (String) row[1], (Integer) row[2], (String) row[3]);
    	messageList.add(message);
    }
        
    return messageList;    
  }  // public ArrayList<Message> getMessages ()
  
  public ArrayList<Project> getProjects () {
   
    ArrayList<Project> projectList = new ArrayList<Project> ();
    for (Project  project: dbmgmt.getProjects()) {
    	projectList.add(project);    		
    }
        
    return projectList;    
  }
  
  
  public Integer createNewMessage (String newNote, Integer projectID) {    
    int newID = dbmgmt.newNote (newNote, projectID);
               
    return newID;    
  } // public createNewMessage (String newNote)
  
  public Boolean removeMessage (Integer messageID) {    
    dbmgmt.deleteNote (messageID);
            
    return true; 
  } // public Boolean removeMessage (String messageID)
  
  public Boolean updateMessage (Message newMessage) {
    dbmgmt.updateNote (newMessage.getMessageID(), newMessage.getNote());
       
    return true;  
  } // public Boolean updateMessage (Message newMessage)
  
}  // public class MessageServiceImpl
