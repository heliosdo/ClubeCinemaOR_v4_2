package entities;

import entities.Filme;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.9.v20200130-rNA", date="2024-06-18T18:35:45")
@StaticMetamodel(Ator.class)
public class Ator_ { 

    public static volatile SingularAttribute<Ator, Integer> totalOscars;
    public static volatile SingularAttribute<Ator, String> nome;
    public static volatile ListAttribute<Ator, Filme> filmes;
    public static volatile SingularAttribute<Ator, Long> id;

}