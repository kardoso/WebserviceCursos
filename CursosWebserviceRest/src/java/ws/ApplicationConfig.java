package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("recursos")
public class ApplicationConfig extends Application{
    
    private void addResourceClasses(Set<Class<?>> resources){
        resources.add(ws.CursoResource.class);
    }
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addResourceClasses(resources);
        return resources;
    }
}
