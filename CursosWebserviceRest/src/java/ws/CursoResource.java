package ws;

import com.google.gson.Gson;
import ejb.CursoRemote;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Curso;

@Path("curso")
public class CursoResource {
    
    @EJB
    private CursoRemote ejb;
    
    private final Gson gson = new Gson();
    
    @GET
    @Produces("application/json")
    public String getCursos(){
        return gson.toJson(ejb.consultarTodos());
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public String getCurso(@PathParam("id")String id){
        return gson.toJson(ejb.consultarPorId(Integer.valueOf(id)));
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String salvarCurso(String curso){
        Curso novoCurso = gson.fromJson(curso, Curso.class);
        return gson.toJson(ejb.salvar(novoCurso));
    }
    
    @DELETE
    @Path("{id}")
    public void removerCurso(@PathParam("id")String id){
        ejb.remover(Integer.valueOf(id));
    }
    
    @PUT
    @Consumes("application/json")
    public void atualizarCurso(String curso){
        salvarCurso(curso);
    }
}
