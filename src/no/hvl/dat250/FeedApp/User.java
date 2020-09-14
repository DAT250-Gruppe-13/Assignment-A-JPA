package no.hvl.dat250.FeedApp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private int phoneNumber;
	private String email;
	private boolean admin;
	
	@OneToMany
	private List<Poll> creditCardList = new ArrayList<Poll>();

}
