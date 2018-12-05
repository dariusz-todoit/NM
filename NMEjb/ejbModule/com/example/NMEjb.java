package com.example;



import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;



@Stateless @Remote
public class NMEjb implements NMInterface {
  
 
  @PersistenceContext(unitName="something")
  private EntityManager entityManager;
  
  
 
  
  // inner join n.Project p
  
  @Override
  public List<Object[]> getNotes () {
    Query query = entityManager.createQuery 
        ("SELECT n.noteId, n.note, n.projectID, p.name FROM Note n  INNER JOIN n.project p ORDER BY n.noteId");
   
    @SuppressWarnings("unchecked")
    List<Object[]> rs = (List<Object[]>) query.getResultList();     
    
    return rs;    
  }
  
  @Override
  public List<Project> getProjects () {
    Query query = entityManager.createQuery ("SELECT p FROM Project p");
   
    @SuppressWarnings("unchecked")
    List<Project> rs = (List<Project>) query.getResultList();     
    
    return rs;    
  }
  
  @Override
  public void deleteNote (int id) {
    Note note = entityManager.find(Note.class, id);
    entityManager.remove(entityManager.merge(note));
  }
  
  @Override
  public void updateNote (int id, String text) {
    Note note = entityManager.find (Note.class, id);
    note.setNote(text);
    entityManager.persist(note);
  }
  
  @Override
  public int newNote (String text, int projectId) {
    Note note = new Note();
    note.setNote(text);
    note.setProjectID(projectId);
    entityManager.persist(note);
    entityManager.flush();    
    
    return note.getNoteID();
  }
  
 
  

}
