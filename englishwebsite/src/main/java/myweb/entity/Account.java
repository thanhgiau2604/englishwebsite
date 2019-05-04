package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account") //tên table trong csdl
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username", nullable = false) //tên column trong csdl
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "fullname")
    private String fullname;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "phone")
    private String phone;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "isad")
    private int isad;

	public Account() {
		
	}

	public Account(String username, String password, String fullname, String email, String phone, String address,
			int isad) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isad = isad;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsAd() {
		return isad;
	}

	public void setIsAd(int isad) {
		this.isad = isad;
	}
}
