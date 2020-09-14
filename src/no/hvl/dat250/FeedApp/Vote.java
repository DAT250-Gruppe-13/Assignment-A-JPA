package no.hvl.dat250.FeedApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Vote {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private boolean value;
	private int user;
	
	

}
