package uitdrukkingen;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @immutable
 */
public abstract class Uitdrukking {
	
	/**
	 * @throws IllegalArgumentException | variabelenaam == null
	 * 
	 * @post | 0 <= result
	 * 
	 * Behavioral subtyping betekent dat de specificatie van een
	 * overschrijvende methode een verstrenging moet zijn van de
	 * specificatie van de overschreven methode. De
	 * specificaties van de methodes 'getAantalVoorkomens' in klassen
	 * LetterlijkeUitdrukking, VariabeleUitdrukking, en Optelling
	 * moeten dus verstrengingen zijn van deze specificatie.
	 */
	public abstract int getAantalVoorkomens(String variabelenaam);
	
	public Iterator<Uitdrukking> getDeeluitdrukkingenIterator() {
		return new Iterator<Uitdrukking>() {
			@Override
			public boolean hasNext() {
				return false;
			}
			
			@Override
			public Uitdrukking next() {
				return null;
			}
		};
	}
	
	public abstract void forEachVariabeleUitdrukking(Consumer<? super VariabeleUitdrukking> consumer);

}
