package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idquestion", nullable = false)
    private String idquestion;
	
	@Column(name = "content")
    private String content;
	
	@Column(name = "optiona")
    private String optiona;
	
	@Column(name = "optionb")
    private String optionb;
	
	@Column(name = "optionc")
    private String optionc;
	
	@Column(name = "optiond")
    private String optiond;
	
	@Column(name = "keyquestion")
    private char keyquestion;
	
	@Column(name = "levelquestion")
    private int levelquestion;
	
	@Column(name = "topic")
    private String topic;

	public Question() {
		
	}

	public Question(String idquestion, String content, String optiona, String optionb, String optionc, String optiond,
			char keyquestion, int levelquestion, String topic) {
		this.idquestion = idquestion;
		this.content = content;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.keyquestion = keyquestion;
		this.levelquestion = levelquestion;
		this.topic = topic;
	}

	public String getIdquestion() {
		return idquestion;
	}

	public void setIdquestion(String idquestion) {
		this.idquestion = idquestion;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public char getKeyquestion() {
		return keyquestion;
	}

	public void setKeyquestion(char keyquestion) {
		this.keyquestion = keyquestion;
	}

	public int getLevelquestion() {
		return levelquestion;
	}

	public void setLevelquestion(int levelquestion) {
		this.levelquestion = levelquestion;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
