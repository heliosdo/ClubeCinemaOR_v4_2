package services;

import entities.Amigo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AmigoService extends EntityService<Amigo> {

    @PersistenceContext(unitName = "ClubeCinemaORPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public AmigoService() {
        super(Amigo.class);
    }
    
}
