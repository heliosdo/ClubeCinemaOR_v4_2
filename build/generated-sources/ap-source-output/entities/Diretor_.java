package entities;

import entities.Filme;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-18T18:35:45")
@StaticMetamodel(Diretor.class)
public class Diretor_ { 

    public static volatile SingularAttribute<Diretor, Integer> totalOscars;
    public static volatile SingularAttribute<Diretor, String> nome;
    public static volatile ListAttribute<Diretor, Filme> filmes;
    public static volatile SingularAttribute<Diretor, Long> id;

}