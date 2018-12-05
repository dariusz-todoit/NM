package com.example;

import java.util.List;

public interface NMInterface {
  void deleteNote (int id);
  void updateNote (int id, String text);
  int newNote (String text, int projectId);
  List<Object[]> getNotes ();
  public List<Project> getProjects ();
}
