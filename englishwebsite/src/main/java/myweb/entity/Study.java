package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userstudy") //tên table trong csdl
public class Study {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username") //tên column trong csdl
    private String username;
	
	@Column(name = "topic")
    private String topic;
	
	@Column(name = "level")
    private int level;
	
	@Column(name = "correct")
    private int correct;
	
	@Column(name = "pass")
    private int pass;

	public Study() {
	}

	public Study(String username, String topic, int level, int correct, int pass) {
		this.username = username;
		this.topic = topic;
		this.level = level;
		this.correct = correct;
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}
}
