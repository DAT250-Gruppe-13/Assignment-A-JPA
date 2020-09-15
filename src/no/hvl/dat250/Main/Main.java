package no.hvl.dat250.Main;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import no.hvl.dat250.Model.Poll;
import no.hvl.dat250.Model.User;
import no.hvl.dat250.Model.Vote;

public class Main {
	
	private static final String PERSISTENCE_UNIT_NAME = "feedback";
    private static EntityManagerFactory factory;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.clear();

        em.getTransaction().begin();
        
        User user = createUser();
        Poll poll = createPoll(user);
        Vote vote = createVote(user);
        
        vote.setPoll(poll);
       

        em.persist(user);
        em.persist(poll);
        em.persist(vote);

        em.getTransaction().commit();
        
        Query q = em.createQuery("select t from User t");
        List<User> pollList = q.getResultList();
        for (User p : pollList) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getEmail());
        }
        
        em.close();

	}
	
	public static User createUser() {
        User user = new User();
        user.setAdmin(true);
        user.setEmail("kjetil@gmail.com");
        user.setName("Kjetil");
        user.setPhoneNumber("123");
        return user;
    }
	
	public static Poll createPoll(User user) {
		Poll poll = new Poll();
		poll.setDescription("Stem");
		poll.setCode("123");
		poll.setPrivat(true);
		poll.setTimeLimit(new Date(System.currentTimeMillis()));
		poll.setUser(user);
		return poll;
		
		
	}
	
	public static Vote createVote(User user) {
		Vote vote = new Vote();
		vote.setValue(true);
		vote.setUser(user);
		return vote;
		
	}

}
