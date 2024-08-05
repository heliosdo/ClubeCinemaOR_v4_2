package services;

import entities.Ator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class AtorService extends EntityService<Ator> {

    @PersistenceContext(unitName = "ClubeCinemaORPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public List<Ator> filter(String prefix){
        prefix += "%";
        Query query = em.createQuery("SELECT ator from Ator ator WHERE ator.nome LIKE :prefix");
        query.setParameter("prefix", prefix);
        return query.getResultList();
    }

    public AtorService() {
        super(Ator.class);
    }
    
}
