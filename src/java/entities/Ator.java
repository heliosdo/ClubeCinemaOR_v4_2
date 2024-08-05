package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Ator implements Serializable, PersistentEntity  {
    private String nome;
    private int totalOscars;
    
    
    @ManyToMany (mappedBy = "atores")
    private List<Filme> filmes;


    public Ator() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getTotalOscars(){
        return totalOscars;
    }

    public void setTotalOscars(int totalOscars){
        this.totalOscars = totalOscars;
    }

    public Ator(String nome, int totalOscars) {
        this.nome = nome;
        this.totalOscars = totalOscars;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ator)) {
            return false;
        }
        Ator other = (Ator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ator[ id=" + id + " ]";
    }
    
}
