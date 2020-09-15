package no.hvl.dat250.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String name;
	private String phoneNumber;
	private String email;
	private String password;
	private boolean admin;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Poll> pollList = new ArrayList<Poll>();

}
