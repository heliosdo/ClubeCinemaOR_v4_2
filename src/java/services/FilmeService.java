package services;

import entities.Filme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FilmeService extends EntityService<Filme> {

    @PersistenceContext(unitName = "ClubeCinemaORPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmeService() {
        super(Filme.class);
    }
    
}
