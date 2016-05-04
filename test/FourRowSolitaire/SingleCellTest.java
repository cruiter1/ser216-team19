package FourRowSolitaire;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class SingleCellTest {
	Card testCard, testCard2;
	SingleCell testCell;
	Deck testDeck;

	@Before
	public void setUp() throws Exception {
		testCell = new SingleCell();
		testDeck = new Deck(1);
		testCard = testDeck.getDeck().getFirst();
		testCard2 = testDeck.getDeck().get(1);
	}

	@Test
	public void getCardAtLocationTest() {
		assertNull(testCell.getCardAtLocation(0));
		assertNull(testCell.getCardAtLocation(new Point(0,0)));
	}
	
	@Test
	public void pushCardTest() {
		testCell.push(testCard);
		
		assertTrue(testCell.getCardAtLocation(0).getFullNumber()==testCard.getFullNumber());
		assertNull(testCell.push(testCard2));
	}
	
	@Test
	public void validMoveTest() {
		assertTrue(testCell.isValidMove(testCard));
		testCell.addCard(testCard);
		assertFalse(testCell.isValidMove(testCard2));
		assertFalse(testCell.isValidMove(new CardStack()));
		
	}

}
