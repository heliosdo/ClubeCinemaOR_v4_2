package entities;

import entities.Ator;
import entities.Diretor;
import entities.Filme.Genero;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-18T18:35:45")
@StaticMetamodel(Filme.class)
public class Filme_ { 

    public static volatile SingularAttribute<Filme, Boolean> oscarMelhorFilme;
    public static volatile SingularAttribute<Filme, Integer> ano;
    public static volatile SingularAttribute<Filme, Genero> genero;
    public static volatile ListAttribute<Filme, Ator> atores;
    public static volatile SingularAttribute<Filme, String> titulo;
    public static volatile SingularAttribute<Filme, Long> id;
    public static volatile SingularAttribute<Filme, Diretor> diretor;

}