package FourRowSolitaire;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.Deck;

public class CardStackTest {
	
	CardStack testStack;
	Card testCard;
	Deck testDeck;

	@Before
	public void setUp() throws Exception {
		testStack = new CardStack();
		testDeck = new Deck(0);
		testCard = testDeck.getDeck().getFirst();
	}

	@Test
	public void addCardTest() {
		testStack.addCard(testCard);
		assertTrue(testCard.getFullNumber() == testStack.getCardAtLocation(0).getFullNumber());
	}
	
	@Test
	public void addStackTest() {
		Card card1, card2, card3, card4;
		card1 = testDeck.getDeck().getFirst();
		card2 = testDeck.getDeck().get(1);
		card3 = testDeck.getDeck().get(2);
		card4 = testDeck.getDeck().get(3);
		
		CardStack tempStack = new CardStack();
		
		tempStack.addCard(card1);
		tempStack.addCard(card2);
		tempStack.addCard(card3);
		tempStack.addCard(card4);
		
		testStack.addStack(tempStack);
		
		assertTrue(testStack.getCardAtLocation(3).getFullNumber() == card1.getFullNumber());
		assertTrue(testStack.getCardAtLocation(2).getFullNumber() == card2.getFullNumber());
		assertTrue(testStack.getCardAtLocation(1).getFullNumber() == card3.getFullNumber());
		assertTrue(testStack.getCardAtLocation(0).getFullNumber() == card4.getFullNumber());
	}
	
	@Test
	public void emptyTest() {
		assertTrue(testStack.isEmpty());
		assertNull(testStack.peek());
		testStack.addCard(testCard);
		assertFalse(testStack.isEmpty());
	}
	
	@Test
	public void searchTest() {
		Card card1, card2, card3, card4;
		card1 = testDeck.getDeck().getFirst();
		card2 = testDeck.getDeck().get(1);
		card3 = testDeck.getDeck().get(2);
		card4 = testDeck.getDeck().get(3);
		
		testStack.addCard(card1);
		testStack.addCard(card2);
		testStack.addCard(card3);
		testStack.addCard(card4);
		
		assertTrue(2 == testStack.search(card3));
		assertTrue(-1 == testStack.search(testDeck.getDeck().get(4)));
		
	}
	
	@Test
	public void pushAndPeekTest() {
		testStack.push(testCard);
		assertTrue(testStack.peek().getFullNumber() == testCard.getFullNumber());
	}
	
	@Test
	public void eptyGetLocationTest() {
		assertNull(testStack.getCardAtLocation(0));
		testStack.addCard(testCard);
		assertNull(testStack.getCardAtLocation(1));
	}
	
	@Test
	public void pushStackTest() {
		Card card1, card2, card3, card4;
		card1 = testDeck.getDeck().getFirst();
		card2 = testDeck.getDeck().get(1);
		card3 = testDeck.getDeck().get(2);
		card4 = testDeck.getDeck().get(3);
		
		CardStack tempStack = new CardStack();
		
		tempStack.addCard(card1);
		tempStack.addCard(card2);
		tempStack.addCard(card3);
		tempStack.addCard(card4);
		
		testStack.push(tempStack);
		
		assertTrue(testStack.getCardAtLocation(3).getFullNumber() == card1.getFullNumber());
		assertTrue(testStack.getCardAtLocation(2).getFullNumber() == card2.getFullNumber());
		assertTrue(testStack.getCardAtLocation(1).getFullNumber() == card3.getFullNumber());
		assertTrue(testStack.getCardAtLocation(0).getFullNumber() == card4.getFullNumber());
	}
	
	@Test
	public void validCardTest() {
		Card card1, card2;
		
		card1 = new Card("Spades", 3, 3, 3);
		card2 = new Card("Hearts", 4, 3, 17);
		
	}

}
