package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "topic") //tên table trong csdl
public class Topic {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idtopic", nullable = false) //tên column trong csdl
    private String idtopic;
	
	@Column(name = "nametopic")
    private String nametopic;
	
	@Column(name = "describetopic")
    private String describetopic;

	public Topic() {

	}

	public Topic(String idtopic, String nametopic, String describetopic) {
		this.idtopic = idtopic;
		this.nametopic = nametopic;
		this.describetopic = describetopic;
	}

	public String getIdtopic() {
		return idtopic;
	}

	public void setIdtopic(String idtopic) {
		this.idtopic = idtopic;
	}

	public String getNametopic() {
		return nametopic;
	}

	public void setNametopic(String nametopic) {
		this.nametopic = nametopic;
	}

	public String getDescribetopic() {
		return describetopic;
	}

	public void setDescribetopic(String describetopic) {
		this.describetopic = describetopic;
	}
}
