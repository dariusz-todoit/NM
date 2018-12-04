package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="NOTES")
public class Note implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="NOTEID", nullable=false)
  private int noteId;
  @Column(name="NOTE", nullable=true)
  private String note;
  @Column(name="PROJECT_ID", nullable=false)
  private int projectID;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="PROJECT_ID", referencedColumnName="ID", insertable=false, updatable=false)
  protected Project project;
  

  public Note(){};
  
  public Note (int noteId, String note, int projectID) {
    this.noteId = noteId;
    this.note = note;
    this.projectID = projectID;    
  }

  public void setNote (String note) {
    this.note = note;
  }
  
  public void setProjectID (int projectID) {
    this.projectID = projectID;
  }
  
  public String getNote () {
    return note;
  }
  
  public int getNoteID () {
    return noteId;
  }
  
  public int getProjectID () {
    return projectID;
  }
  
}
