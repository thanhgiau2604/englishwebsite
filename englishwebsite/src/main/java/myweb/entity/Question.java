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
	
	@Column(name = "a")
    private String optionA;
	
	@Column(name = "b")
    private String optionB;
	
	@Column(name = "c")
    private String optionC;
	
	@Column(name = "d")
    private String optionD;
	
	@Column(name = "key")
    private char key;
	
	@Column(name = "level")
    private int level;
	
	@Column(name = "topic")
    private String topic;

	public Question() {
		
	}

	public Question(String idquestion, String content, String optionA, String optionB, String optionC, String optionD,
			char key, int level, String topic) {
		this.idquestion = idquestion;
		this.content = content;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.key = key;
		this.level = level;
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

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
