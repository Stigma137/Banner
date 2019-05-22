package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Participant;

class participantTest {
	private Participant p;
	
	private void setupScenary1() {
	}
	@Test
	void constructorTest() {
		setupScenary1();
		p = new Participant("09", "Daniel", "Legarda", "dan@yahoo.net", "https://robohash.org/officiisveritatisblanditiis.png?size=50x50&set=set1", "Male", "102.102.01", "Germany", "01/01/2000");
		assertNotNull(p ,"Participant created");
	}

}
