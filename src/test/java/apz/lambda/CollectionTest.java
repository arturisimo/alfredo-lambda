package apz.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class CollectionTest {

	/**
	 * Arrays is a fixed size list which is unmodifiable.
	 * It will fail with runtime exception on add operation
	 */
	@Test
	public void testArray() {
		List<Integer> digits = Arrays.asList(1);
	    assertThrows(UnsupportedOperationException.class,() -> {
	    	digits.add(2);
        });	    
	}
	
	@Test
	public void testCopy() {
		List<String> source = Arrays.asList("a", "b", "c", "d");
		List<Object> target = new ArrayList<>();
		cloneList(source, target);
		assertEquals(4, target.size());
	}

	private <T> void cloneList(List<? extends T> source, List<T> target) {
		source.forEach(item -> {
			target.add(item);
		});
	}
	
	@Test
	public void testTokenizer() {
        StringTokenizer st = new StringTokenizer("a,b,c,v,e", ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        Arrays.stream("a,b,c,v,e".split(",")).forEach(System.out::println);
	}
	
}
