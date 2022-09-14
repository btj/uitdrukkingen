package uitdrukkingen;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @immutable
 */
public class LetterlijkeUitdrukking extends Uitdrukking {
	
	private int waarde;
	
	public int getWaarde() { return waarde; }
	
	/**
	 * @post | getWaarde() == waarde
	 */
	public LetterlijkeUitdrukking(int waarde) {
		this.waarde = waarde;
	}
	
	/**
	 * @throws IllegalArgumentException | variabelenaam == null
	 * 
	 * @post | result == 0
	 */
	@Override
	public int getAantalVoorkomens(String variabelenaam) {
		if (variabelenaam == null)
			throw new IllegalArgumentException("`variabelenaam` is null");
		
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof LetterlijkeUitdrukking u && waarde == u.waarde;
	}
	
	@Override
	public int hashCode() {
		return waarde;
	}

	@Override
	public void forEachVariabeleUitdrukking(Consumer<? super VariabeleUitdrukking> consumer) {}
	
}
