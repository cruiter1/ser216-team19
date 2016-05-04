package FourRowSolitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Card;

public class CardTest {

	Card aceOClubs, threeOSpades, nineOHearts, fiveODiamonds, invalSuit,
			invalNum;

	@Before
	public void setUp() throws Exception {
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		fiveODiamonds = new Card("Diamonds", 5, 3, 31);
		invalSuit = new Card("Group", 3, 2, 42);
		invalNum = new Card("Spades", 15, 1, 100);
	}

	@Test
	public void testGetSuit() {
		assertTrue(threeOSpades.getSuit() == "Spades");
		assertTrue(nineOHearts.getSuit() == "Hearts");
		assertTrue(fiveODiamonds.getSuit() == "Diamonds");
		assertTrue(aceOClubs.getSuit() == "Clubs");
		assertTrue(invalSuit.getSuit() =="Invalid Suit");
		assertTrue(invalNum.getSuit()=="Invalid Suit");
	}

	@Test
	public void testGetColor() {
		assertTrue(threeOSpades.getColor() == 0);
		assertTrue(nineOHearts.getColor() == 1);
		assertTrue(fiveODiamonds.getColor() == 1);
		assertTrue(aceOClubs.getColor() == 0);
		assertTrue(invalSuit.getColor() == 0);
		assertTrue(invalNum.getColor()== 0);
	}

	@Test
	public void testGetNumber() {
		assertTrue(threeOSpades.getNumber() == 3);
		assertTrue(nineOHearts.getNumber() == 9);
		assertTrue(fiveODiamonds.getNumber() == 5);
		assertTrue(aceOClubs.getNumber() == 1);
		assertTrue(invalSuit.getNumber() == -1);
		assertTrue(invalNum.getNumber()== -1);
	}


}
