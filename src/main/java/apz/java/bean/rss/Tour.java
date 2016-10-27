package apz.java.bean.rss;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Tour {
	
	String title;
	String link;
	String description;
	String category;
	
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

	public String getCategory() {
		return category;
	}

	@XmlElement
	public void setCategory(String category) {
		this.category = category;
	}

}