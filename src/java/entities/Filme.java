package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Filme implements Serializable, PersistentEntity  {
    private String titulo;
    private int ano;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private boolean oscarMelhorFilme;
    
    @ManyToOne
     private Diretor diretor;

    @ManyToMany
    private List<Ator> atores;

    public void addAtor(Ator ator) { 
        atores.add(ator); 
    }

    
    public enum Genero{
        ACAO("Acao"),
        AVENTURA("Aventura"),
        COMEDIA("Comedia"),
        DRAMA("Drama"),
        FAROESTE("Faroeste"),
        FICCAO("Ficcao"),
        GUERRA("Guerra"),
        INFANTIL("Infantil"),
        MUSICAL("Musical"),
        ROMANCE("Romance"),
        SUSPENSE("Suspense"),
        TERROR("Terror");
        

        private final String label;

        private Genero(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    }
    

    public Filme() {
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isOscarMelhorFilme() {
        return oscarMelhorFilme;
    }

    public void setOscarMelhorFilme(boolean oscarMelhorFilme) {
        this.oscarMelhorFilme = oscarMelhorFilme;
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Filme[ id=" + id + " ]";
    }
}
