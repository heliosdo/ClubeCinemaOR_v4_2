package beans;

import entities.Filme; 
import java.io.Serializable; 
import util.RequestParameters; 
import java.util.List; 
import javax.annotation.PostConstruct;
import javax.ejb.EJB; 
import javax.faces.model.SelectItem;
import javax.inject.Named; 
import javax.faces.view.ViewScoped; 
import javax.inject.Inject; 
import services.FilmeService; 

@Named (value = "filmeBean") 
@ViewScoped
public class FilmeBean implements Serializable {
    
    @EJB
    private FilmeService filmeService;

    @Inject 
    private RequestParameters parameters;
    private Filme value; 
    private boolean consultar; 
    List<Filme> filmesFiltrados; 

    @PostConstruct 
    public void init() { 
        String id = parameters.get("id"); 
        if(id == null) {
            value = new Filme(); 
        } else {
            value = filmeService.find(Long.valueOf(id)); 
        }
    }
    
    public Filme getValue() { 
        return value;
    }
    
    public void setValue(Filme value) { 
        this.value = value;
    }

    public boolean isConsultar() { 
        return consultar;
    }

    public void setConsultar(boolean consultar) { 
        this.consultar = consultar;
    }

    public List<Filme> getFilmesFiltrados() {
        return filmesFiltrados;
    }

    public void setFilmesFiltrados(List<Filme> filmesFiltrados) {
        this.filmesFiltrados = filmesFiltrados;
    }

    public FilmeService getFilmeService() {
        return filmeService;
    }

    public void setFilmeService(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public RequestParameters getParameters() {
        return parameters;
    }

    public void setParameters(RequestParameters parameters) {
        this.parameters = parameters;
    }

    
        
    public void reset() { 
        value = new Filme(); 
    }
    
    public void inserir() { 
        reset();
        setConsultar(false); 
    } 
    
    public void consultar(Filme value) { 
        setValue(value); 
        setConsultar(true);
    }
    
    public List<Filme> getAll() { 
        return filmeService.getAll();
    }
    
    public String save() {
        try {
            filmeService.create(value);
            reset();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String update() {
        try {
            filmeService.edit(value);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String delete() {
        try {
            filmeService.remove(value);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
    public SelectItem[] getOptionsOscarMelhorFilme() {
        return new SelectItem[]{
            new SelectItem("", ""),
            new SelectItem(Boolean.TRUE.toString(), "Sim"),
            new SelectItem(Boolean.FALSE.toString(), "Não")
        };
    }
    
    
    public SelectItem[] getGeneros(boolean filtrar) {
        SelectItem[] items;
        int length = Filme.Genero.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }
        for (Filme.Genero genero : Filme.Genero.values()) {
            items[n++] = new SelectItem(genero, genero.getLabel());
        }
        return items;
    }
        
}
