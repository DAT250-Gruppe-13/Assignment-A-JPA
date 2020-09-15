package no.hvl.dat250.Model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="polls")
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String description;
	private String code;
	private boolean privat;
	private Date TimeLimit;
	
	@ManyToOne
	@ToString.Exclude
	private User user;
	
	@OneToMany(mappedBy = "poll", fetch = FetchType.EAGER)
    private List<Vote> votes = new ArrayList<Vote>();
	

}
