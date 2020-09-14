package no.hvl.dat250.FeedApp;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String desc;
	private int code;
	private boolean privat;
	private Date TimeLimit;
	
	@ManyToOne
	private User user;
	
	@OneToMany
    private List<Vote> votes;
	

}
