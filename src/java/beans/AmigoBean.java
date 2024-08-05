package beans;

import entities.Amigo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import services.AmigoService;
import util.RequestParameters;

@Named(value = "amigoBean")
@ViewScoped
public class AmigoBean implements Serializable {

    @EJB
    private AmigoService amigoService;

    @Inject
    private RequestParameters parameters;
    private Amigo value;
    private boolean consultar;
    private List<Amigo> amigosFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Amigo();
        } else {
            value = amigoService.find(Long.valueOf(id));
        }
    }

    public Amigo getValue() {
        return value;
    }

    public void setValue(Amigo value) {
        this.value = value;
    }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Amigo> getAmigosFiltrados() {
        return amigosFiltrados;
    }

    public void setAmigosFiltrados(List<Amigo> amigosFiltrados) {
        this.amigosFiltrados = amigosFiltrados;
    }

    public void reset() {
        value = new Amigo();
    }

    public void inserir() {
        reset();
        setConsultar(false);
    }

    public void consultar(Amigo value) {
        setValue(value);
        setConsultar(true);
    }
    
    public List<Amigo> getAll() { 
        return amigoService.getAll();
    }

    public void save() {
        try {
            amigoService.create(value);
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            amigoService.edit(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            amigoService.remove(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SelectItem[] getEstadosCivis(boolean filtrar) {
        SelectItem[] items;
        int length = Amigo.EstadoCivil.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }
        for (Amigo.EstadoCivil estadoCivil : Amigo.EstadoCivil.values()) {
            items[n++] = new SelectItem(estadoCivil, estadoCivil.getLabel());
        }
        return items;
    }

    public SelectItem[] getSexos(boolean filtrar) {
        SelectItem[] items;
        int length = 3;
        int n = 0;

        if (filtrar) {
            items = new SelectItem[length];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length - 1];
        }

        items[1] = new SelectItem("masculino", "Masculino");
        items[2] = new SelectItem("feminino", "Feminino");

        return items;
    }


    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
}
