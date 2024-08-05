package beans;

import entities.Ator; 
import java.io.Serializable; 
import util.RequestParameters; 
import java.util.List; 
import javax.annotation.PostConstruct;
import javax.ejb.EJB; 
import javax.inject.Named; 
import javax.faces.view.ViewScoped; 
import javax.inject.Inject; 
import services.AtorService; 

@Named (value = "atorBean") 
@ViewScoped
public class AtorBean implements Serializable {
    
    @EJB
    private AtorService atorService;

    @Inject 
    private RequestParameters paramsters; 
    private Ator value; 
    private boolean consultar; 
     private List<Ator> atoresFiltrados; 

    @PostConstruct 
    public void init() { 
        String id = paramsters.get("id"); 
        if(id == null) {
            value = new Ator(); 
        } else {
            value = atorService.find(Long.valueOf(id)); 
        }
    }
    
    public Ator getValue() { 
        return value;
    }
    
    public void setValue(Ator value) { 
        this.value = value;
    }

    public boolean isConsultar() { 
        return consultar;
    }

    public void setConsultar(boolean consultar) { 
        this.consultar = consultar;
    }
    
    public List<Ator> getAtoresFiltrados() {
        return atoresFiltrados;
    }

    public void setAtoresFiltrados(List<Ator> atoresFiltrados) {
        this.atoresFiltrados = atoresFiltrados;
    }

    
    public void reset() { 
        value = new Ator(); 
    }
    
    public void inserir() { 
        reset();
        setConsultar(false); 
    } 
    
    public void consultar(Ator value) { 
        setValue(value); 
        setConsultar(true);
    }
    
    public List<Ator> getAll() { 
        return atorService.getAll();
    }
    
    public String save() {
        try {
            atorService.create(value);
            reset();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String update() {
        try {
            atorService.edit(value);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String delete() {
        try {
            atorService.remove(value);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
    public List<Ator> completaDiretor(String prefixo){
        return atorService.filter(prefixo);
    }
}
