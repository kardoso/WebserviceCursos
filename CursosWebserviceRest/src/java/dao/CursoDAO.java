package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Curso;

public class CursoDAO {
    private final EntityManager em;
    
    public CursoDAO(EntityManager em){
        this.em = em;
    }
    
    public Curso salvar(Curso curso){
        if(curso.getId() == 0){
            em.persist(curso);
        }
        else{
            curso = em.merge(curso);
        }
        return curso;
    }
    
    public void remover(int id){
        Curso curso = em.find(Curso.class, id);
        em.remove(curso);
    }
    
    public Curso consultarPorId(int id){
        return em.find(Curso.class, id);
    }
    
    public List<Curso> consultarTodos(){
        Query q = em.createNamedQuery("Curso.consultarTodos");
        return q.getResultList();
    }
}
