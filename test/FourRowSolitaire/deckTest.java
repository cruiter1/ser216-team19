package FourRowSolitaire;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Deck;

public class deckTest {
	
	Deck testDeck1, testDeck2;

	@Before
	public void setUp() throws Exception {
		testDeck1 = new Deck(1);
		
	}

	@Test
	public void testInitalization() {
		boolean works = false;
		
		if(testDeck1.getDeck().getFirst().getFullNumber() >= 0 && testDeck1.getDeck().getFirst().getFullNumber() <= 52){
			works = true;
		}
		assertTrue(works);
	}
	
	@Test
	public void testGetDeck2() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(1);
		
		boolean works = false;
		
		if(testDeck1.getDeck(numbers).getFirst().getFullNumber() >= 0 && testDeck1.getDeck(numbers).getFirst().getFullNumber() <= 52){
			works = true;
		}
		assertTrue(works);
	}

}
