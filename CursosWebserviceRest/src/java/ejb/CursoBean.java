package ejb;

import dao.CursoDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Curso;

@Stateless(mappedName = "CursoBean")
public class CursoBean implements CursoRemote {
    @PersistenceContext(unitName = "CursoPU")
    private EntityManager em;

    @Override
    public Curso salvar(Curso curso) {
        CursoDAO dao = new CursoDAO(em);
        return dao.salvar(curso);
    }

    @Override
    public void remover(int id) {
        CursoDAO dao = new CursoDAO(em);
        dao.remover(id);
    }

    @Override
    public Curso consultarPorId(int id) {
        CursoDAO dao = new CursoDAO(em);
        return dao.consultarPorId(id);
    }

    @Override
    public List<Curso> consultarTodos() {
        CursoDAO dao = new CursoDAO(em);
        return dao.consultarTodos();
    }
}
