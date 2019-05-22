package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Banner;
import model.Viewer;

class bannerTest {
	private Banner b;
	
	public void setupScenary1() throws Exception {
		Viewer v1 = new Viewer("09", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v2 = new Viewer("05", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v3 = new Viewer("08", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v4 = new Viewer("02", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v5 = new Viewer("03", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v6 = new Viewer("04", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		Viewer v7 = new Viewer("01", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		b.add(v1);
		b.add(v2);
		b.add(v3);
		b.add(v4);
		b.add(v5);
		b.add(v6);
		b.add(v7);
	}
	@Test
	void addTest() throws Exception {
		setupScenary1();
		Viewer v8 = new Viewer("44", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		b.add(v8);
		assertTrue(b.getWeight(b.getRoot()) == 8 ,"A new viewer was added");
	}
	@Test
	void inOrderTest() throws Exception {
		setupScenary1();
	}
}
