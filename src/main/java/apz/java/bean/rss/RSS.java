package apz.java.bean.rss;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rss")
public class RSS {
	
	Channel channel;

	public Channel getChannel() {
		return channel;
	}
	
	@XmlElement
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
}
