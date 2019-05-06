package myweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video") //tên table trong csdl
public class Video {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idvideo", nullable = false) //tên column trong csdl
    private String idvideo;
	
	@Column(name = "url")
    private String url;
	
	@Column(name = "namevideo")
    private String namevideo;
	
	@Column(name="describevideo")
	private String describevideo;
	
	@Column(name = "level")
    private int level;
	
	@Column(name = "topic")
    private String topic;

	public Video() {
	}

	public Video(String idvideo, String url, String namevideo, String describevideo, int level, String topic) {
		this.idvideo = idvideo;
		this.url = url;
		this.namevideo = namevideo;
		this.describevideo = describevideo;
		this.level = level;
		this.topic = topic;
	}

	public String getIdvideo() {
		return idvideo;
	}

	public void setIdvideo(String idvideo) {
		this.idvideo = idvideo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNamevideo() {
		return namevideo;
	}

	public void setNamevideo(String namevideo) {
		this.namevideo = namevideo;
	}

	public String getDescribevideo() {
		return describevideo;
	}

	public void setDescribevideo(String describevideo) {
		this.describevideo = describevideo;
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
