package apz.java.bean.rss;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "channel")
public class Channel {
	
	String title;
	String link;
	String description;
	String copyright;
	List<Tour> tours;
	
	public String getTitle() {
		return title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	@XmlElement
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	@XmlElement
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	@XmlElement(name = "item")
	public List<Tour> getTours() {
		return tours;
	}
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
	
	

}
