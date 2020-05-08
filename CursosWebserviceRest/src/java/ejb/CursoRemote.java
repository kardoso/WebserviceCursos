package ejb;

import java.util.List;
import javax.ejb.Remote;
import modelo.Curso;

@Remote
public interface CursoRemote {
    public Curso salvar(Curso curso);
    public void remover(int id);
    public Curso consultarPorId(int id);
    public List<Curso> consultarTodos();
}
