package mb;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Curso;

@ManagedBean
@SessionScoped
public class CursoMB implements Serializable{
    private Curso curso = new Curso();
    private List<Curso> cursos = new ArrayList();
    private Client client = ClientBuilder.newClient();
    private Gson gson = new Gson();
    
    public CursoMB(){
        recarregar();
    }
    
    public void recarregar(){
        WebTarget webtarget = client.target("http://localhost:8080/CursosWebserviceRest/recursos/curso");
        Invocation.Builder invocationBuilder = webtarget.request("application/json;charset=utf-8");
        String json = invocationBuilder.get(String.class);
        
        cursos = gson.fromJson(json, new TypeToken<List<Curso>>(){}.getType());
    }
    
    public String salvar() {
        WebTarget webtarget = client.target("http://localhost:8080/CursosWebserviceRest/recursos/curso");
        Invocation.Builder invocationBuilder = webtarget.request("application/json;charset=utf-8");
        Response response = invocationBuilder.post(Entity.entity(curso, "application/json;charset=utf-8"));
        
        curso = new Curso();
        recarregar();
        return "index";
    }
    
    public void editar(Curso c){
        this.curso = c;
    }
    
    public void remover(Curso c){
        WebTarget webtarget = client.target("http://localhost:8080/CursosWebserviceRest/recursos/curso/" + c.getId());
        Invocation.Builder invocationBuilder = webtarget.request("application/json;charset=utf-8");
        Response response = invocationBuilder.delete();
        recarregar();
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
