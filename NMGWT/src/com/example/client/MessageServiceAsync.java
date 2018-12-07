package com.example.client;

import java.util.ArrayList;
import com.example.Project;
import com.example.Message;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync {
  void getMessages (AsyncCallback<ArrayList<Message>> callback);
  void getProjects (AsyncCallback<ArrayList<Project>> callback);
  void createNewMessage (String newNote, Integer projectID, AsyncCallback<Integer> callback);
  void removeMessage (Integer messageID, AsyncCallback<Boolean> callback);
  void updateMessage (Message newMessage, AsyncCallback<Boolean> callback);  
}