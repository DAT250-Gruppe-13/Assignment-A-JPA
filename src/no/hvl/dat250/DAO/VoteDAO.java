package no.hvl.dat250.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import no.hvl.dat250.Model.Vote;

import java.util.List;
import java.util.Optional;

public class VoteDAO implements DAO<Vote> {

    private EntityManager em;

    public VoteDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        em = factory.createEntityManager();
    }

    @Override
    public List<Vote> read() {
        Query q =em.createQuery("Select v from Vote v");
        return q.getResultList();
    }

    @Override
    public Vote read(int id) {
        return em.find(Vote.class, id);
    }

    @Override
    public void create(Vote vote) {
        em.getTransaction().begin();
        em.persist(vote);
        em.getTransaction().commit();
    }

    @Override
    public void update(Vote vote) {
        em.getTransaction().begin();
        em.merge(vote);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Vote v = em.find(Vote.class, id);
        em.getTransaction().begin();
        em.remove(v);
        em.getTransaction().commit();
    }
}
