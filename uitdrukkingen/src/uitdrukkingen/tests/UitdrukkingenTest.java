package uitdrukkingen.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import uitdrukkingen.LetterlijkeUitdrukking;
import uitdrukkingen.Optelling;
import uitdrukkingen.VariabeleUitdrukking;

class UitdrukkingenTest {

	@Test
	void test() {
		LetterlijkeUitdrukking tien = new LetterlijkeUitdrukking(10);
		assertEquals(10, tien.getWaarde());
		
		VariabeleUitdrukking x = new VariabeleUitdrukking("x");
		assertEquals("x", x.getVariabelenaam());
		
		Optelling xPlusTien = new Optelling(x, tien);
		assertEquals(x, xPlusTien.getLinkerdeeluitdrukking());
		assertEquals(tien, xPlusTien.getRechterdeeluitdrukking());
		
		assertEquals(0, tien.getAantalVoorkomens("x"));
		assertEquals(1, x.getAantalVoorkomens("x"));
		assertEquals(0, x.getAantalVoorkomens("y"));
		assertEquals(1, xPlusTien.getAantalVoorkomens("x"));
		assertEquals(2, new Optelling(xPlusTien, x).getAantalVoorkomens("x"));
		
		VariabeleUitdrukking y = new VariabeleUitdrukking("y");
		Optelling xPlusTien2 = new Optelling(new VariabeleUitdrukking("x"), new LetterlijkeUitdrukking(10));
		assertEquals(xPlusTien, xPlusTien2);
		assertNotEquals(x, tien);
		assertNotEquals(tien, x);
		assertNotEquals(new LetterlijkeUitdrukking(0), new LetterlijkeUitdrukking(10));
		assertNotEquals(new VariabeleUitdrukking("x"), y);
		assertNotEquals(new Optelling(tien, x), new Optelling(x, tien));
		
		assertEquals(List.of(), iteratorToList(tien.getDeeluitdrukkingenIterator()));
		assertEquals(List.of(), iteratorToList(x.getDeeluitdrukkingenIterator()));
		assertEquals(List.of(x, tien), iteratorToList(xPlusTien.getDeeluitdrukkingenIterator()));
		
		testInternalIterator(List.of(), c -> tien.forEachVariabeleUitdrukking(c));
		testInternalIterator(List.of(x), c -> x.forEachVariabeleUitdrukking(c));
		testInternalIterator(List.of(x, y), c -> new Optelling(xPlusTien, y).forEachVariabeleUitdrukking(c));
	}
	
	static <T> List<T> iteratorToList(Iterator<T> i) {
		ArrayList<T> result = new ArrayList<>();
		while (i.hasNext())
			result.add(i.next());
		return result;
	}
	
	static <T> void testInternalIterator(List<T> expected, Consumer<Consumer<T>> iterator) {
		List<T> actual = new ArrayList<>();
		iterator.accept(x -> actual.add(x));
		assertEquals(expected, actual);
	}

}
