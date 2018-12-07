package com.example.client;


import java.util.ArrayList;
import com.example.Project;
import com.example.Message;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("message")
public interface MessageService extends RemoteService {
  ArrayList<Message> getMessages ();
  ArrayList<Project> getProjects ();
  Integer createNewMessage (String newNote, Integer projectID);
  Boolean removeMessage (Integer messageID);
  Boolean updateMessage (Message newMessage);
}