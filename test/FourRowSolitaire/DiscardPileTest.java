package FourRowSolitaire;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscardPileTest 
{
	DiscardPile d;
	static int drawCount, cardsLeftFromDraw;
	Card aceOClubs, threeOSpades, nineOHearts, fiveODiamonds, fourOClubs, threeOHearts, invalSuit,
	invalNum;
	@Before
	public void setUp() throws Exception 
	{
		drawCount = 1;
		cardsLeftFromDraw = 0;
		d = new DiscardPile(1);
	}

	@After
	public void tearDown() throws Exception 
	{
		drawCount = 0;
		cardsLeftFromDraw = 0;
		d = null;	
	}
//=======================================================================
	@Test
	public void testAddCard() 
	{
		d = new DiscardPile(1);
		fiveODiamonds = new Card("Diamonds", 5, 3, 31);
		cardsLeftFromDraw = 0;
		d.addCard(fiveODiamonds);
		assertTrue(d.getNumViewableCards() == 1);
		
		//bug evidence
		invalNum = new Card("Diamonds", 33, 3, 31);
		d.addCard(invalNum);
		assertTrue(d.getNumViewableCards() == 2); 
		assertFalse(d.getNumViewableCards() == 1); 
		 
		//bug evidence
		invalSuit = new Card("fake", 1, 3, 31);
		d.addCard(invalSuit);  
		assertTrue(d.getNumViewableCards() == 3);
		assertFalse(d.getNumViewableCards() == 1);
		 
		fiveODiamonds = null;  
		invalSuit = null; 
		d = null;
		invalNum = null;
	}

	@Test
	public void testSetView() {
		d = new DiscardPile(1);
		cardsLeftFromDraw = 0;
		d.setView(5);
		assertTrue(d.getNumViewableCards() == 5);
		d = null;
	} 
 
	@Test 
	public void testGetCardAtLocation() 
	{
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades);
		cs.addCard(nineOHearts);
		assertTrue(cs.getCardAtLocation(0) == aceOClubs);
		assertFalse(cs.getCardAtLocation(0) == threeOSpades);
		assertTrue(cs.getCardAtLocation(1) == threeOSpades);
		assertTrue(cs.getCardAtLocation(2) == nineOHearts);
		aceOClubs = null;
		threeOSpades = null;
		nineOHearts = null; 
		cs = null;
	}

	@Test
	public void testDiscardPile() {
		drawCount = 0;
		assertTrue(drawCount == 0);
	}

	@Test 
	public void testSetDrawCount() 
	{
		d = new DiscardPile(1);
		assertTrue(drawCount == 1);
		d.setDrawCount(5);
		assertTrue(d.getDrawCount() == 5);
		d = null;
	}

	@Test
	public void testGetNumViewableCards() 
	{
		//this is pointless
		cardsLeftFromDraw = 10;
		assertTrue(cardsLeftFromDraw == 10);
	}
	
	@Test
	public void testAddStack()
	{ 
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades); 
		d.addStack(cs);  
		assertTrue(d.getNumViewableCards() == 2);
		assertFalse(d.getNumViewableCards() == 1);
		cs.addCard(nineOHearts); 
		d.addStack(cs);  
		assertTrue(d.getNumViewableCards() == 3);
		assertFalse(d.getNumViewableCards() == 1);
		
		aceOClubs = null; 
		threeOSpades = null;  
		nineOHearts = null;
		cs = null;
		d = null;
	}
	 
	@Test
	public void testPush()  
	{ 
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		assertTrue(d.push(aceOClubs) == aceOClubs);
		assertFalse(d.push(aceOClubs) == nineOHearts);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		assertTrue(d.push(nineOHearts) == nineOHearts);
		assertFalse(d.push(nineOHearts) == aceOClubs);

		//bug evidence
		assertTrue(d.getNumViewableCards() == 4); 
		
		d = null;
		aceOClubs = null; 
		nineOHearts = null;
	} 
	
	@Test
	public void testCardStackPush() 
	{
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades); 
		d.addStack(cs);  
		assertTrue(d.getNumViewableCards() == 2);
		assertFalse(d.getNumViewableCards() == 1);
		cs.addCard(nineOHearts); 
		d.addStack(cs);  
		assertTrue(d.getNumViewableCards() == 3);
		assertFalse(d.getNumViewableCards() == 1);
		
		assertTrue(d.push(cs) == cs);
		
		aceOClubs = null;  
		threeOSpades = null;  
		nineOHearts = null;
		cs = null;
		d = null;
	}
	
	@Test
	public void testPop() 
	{
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades);
		cs.addCard(nineOHearts);
		d.addStack(cs);
		assertTrue(d.getNumViewableCards() == 3);
		assertTrue(d.pop() == aceOClubs);
		assertTrue(d.pop() == threeOSpades);
		assertTrue(d.pop() == nineOHearts);
		assertTrue(d.getNumViewableCards() == 0);
		  
		aceOClubs = null;   
		threeOSpades = null;  
		nineOHearts = null;
		cs = null;
		d = null;
	}
	
	@Test
	public void testUndoPop() 
	{
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades);
		cs.addCard(nineOHearts);
		d.addStack(cs);
		assertTrue(d.getNumViewableCards() == 3);
		assertTrue(d.pop() == aceOClubs);
		assertTrue(d.pop() == threeOSpades);
		assertTrue(d.undoPop() == nineOHearts); 
		assertTrue(d.getNumViewableCards() == 1);
		aceOClubs = null;   
		threeOSpades = null;  
		nineOHearts = null;
		cs = null;
		d = null;
	}
	 
	@Test
	public void testIsValidMove()
	{
		d = new DiscardPile(0);
		fourOClubs = new Card("Clubs", 4, 3, 14);
		assertTrue(d.isValidMove(fourOClubs) == false);
	} 
	
	@Test
	public void testIsValidMoveStack()
	{
		d = new DiscardPile(0);
		aceOClubs = new Card("Clubs", 1, 3, 14);
		threeOSpades = new Card("Spades", 3, 3, 3);
		nineOHearts = new Card("Hearts", 9, 1, 48);
		CardStack cs = new CardStack();
		cs.addCard(aceOClubs);
		cs.addCard(threeOSpades); 
		cs.addCard(nineOHearts);
		assertTrue(d.isValidMove(cs) == false);
	}
	
}
