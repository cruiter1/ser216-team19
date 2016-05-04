package FourRowSolitaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class drawPileTest {
	
	DiscardPile testDiscard;
	Deck testDeck;
	CardStack testStack;

	@Before
	public void setUp() throws Exception {
		testDiscard = new DiscardPile(1);
		testDeck = new Deck(1);
		testStack = new CardStack();
	}

	@Test
	public void setViewTest() {
		testDiscard.setView(4);
		assertTrue(testDiscard.getNumViewableCards() == 4);
	}

	
	@Test
	public void addCardTest() {
		Card card1, card2, card3, card4;
		card1 = testDeck.getDeck().getFirst();
		card2 = testDeck.getDeck().get(1);
		card3 = testDeck.getDeck().get(2);
		card4 = testDeck.getDeck().get(3);
		
		testDiscard.addCard(card1);
		
		assertTrue(testDiscard.getCardAtLocation(0).getFullNumber() == card1.getFullNumber());
		
		testDiscard = new DiscardPile(1);
		
		testDiscard.push(card1);
		assertTrue(testDiscard.getCardAtLocation(0).getFullNumber() == card1.getFullNumber());
		
		
	}
	
	@Test
	public void addCardStackTest() {
		Card card1, card2, card3, card4;
		card1 = testDeck.getDeck().getFirst();
		card2 = testDeck.getDeck().get(1);
		card3 = testDeck.getDeck().get(2);
		card4 = testDeck.getDeck().get(3);
		
		testStack.addCard(card1);
		testStack.addCard(card2);
		testStack.addCard(card3);
		testStack.addCard(card4);
		
		testDiscard.addStack(testStack);
		
		assertTrue(testDiscard.getCardAtLocation(3).getFullNumber() == card1.getFullNumber());
		assertTrue(testDiscard.getCardAtLocation(2).getFullNumber() == card2.getFullNumber());
		assertTrue(testDiscard.getCardAtLocation(1).getFullNumber() == card3.getFullNumber());
		assertTrue(testDiscard.getCardAtLocation(0).getFullNumber() == card4.getFullNumber());
		
		testDiscard = new DiscardPile(1);
		testDiscard.setDrawCount(2);
		testDiscard.push(testStack);
		
		
	}
	@Test
	public void validMoveTest() {
		Card card1;
		card1 = testDeck.getDeck().getFirst();
		
		assertFalse(testDiscard.isValidMove(card1));
		
		assertFalse(testDiscard.isValidMove(new CardStack()));
		
		
		
	}
}
