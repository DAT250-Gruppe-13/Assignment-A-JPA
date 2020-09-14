package no.hvl.dat250.FeedApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Entity
@Data
@Table(name="votes")
public class Vote {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private boolean value;
	
	@ManyToOne
	@ToString.Exclude
	private User user;
	
	@ManyToOne
	@ToString.Exclude
	private Poll poll;
	
	
	
	

}
