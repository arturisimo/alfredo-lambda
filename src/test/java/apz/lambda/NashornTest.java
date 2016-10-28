package apz.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apz.java.Nashorn;

public class NashornTest {

	Nashorn nashorn = new Nashorn();
	
	@Test
	public void evalTest() {
		assertEquals("hola pepe", nashorn.eval("pepe"));
	}
	
	@Test
	public void rssTest() {
		assertEquals("Explore California Tours", nashorn.getRSS().getChannel().getTitle());
	}

}
