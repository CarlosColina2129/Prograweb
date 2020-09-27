package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	@Column(name = "emailuser", nullable = false, length = 30)
	private String emailuser;

	@Column(name = "username", nullable = false, length = 30)
	private String username;

	@Column(name = "password", nullable = false, length = 80)
	private String password;

	@Column(name = "state", nullable = false, length = 1)
	private String state;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id_user, String emailuser, String username, String password, String state, Rol roluser) {
		super();
		this.id_user = id_user;
		this.emailuser = emailuser;
		this.username = username;
		this.password = password;
		this.state = state;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmailuser() {
		return emailuser;
	}

	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
