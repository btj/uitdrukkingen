package uitdrukkingen;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @immutable
 * 
 * @invar | getVariabelenaam() != null
 */
public class VariabeleUitdrukking extends Uitdrukking {

	/**
	 * @invar | variabelenaam != null
	 */
	private String variabelenaam;
	
	public String getVariabelenaam() { return variabelenaam; }
	
	/**
	 * @throws IllegalArgumentException | variabelenaam == null
	 * 
	 * @post | getVariabelenaam() == variabelenaam
	 */
	public VariabeleUitdrukking(String variabelenaam) {
		if (variabelenaam == null)
			throw new IllegalArgumentException("`variabelenaam` is null");
		
		this.variabelenaam = variabelenaam;
	}
	
	/**
	 * @throws IllegalArgumentException | variabelenaam == null
	 * 
	 * @post | result == (variabelenaam.equals(getVariabelenaam()) ? 1 : 0)
	 */
	@Override
	public int getAantalVoorkomens(String variabelenaam) {
		if (variabelenaam == null)
			throw new IllegalArgumentException("`variabelenaam` is null");
		
		return variabelenaam.equals(this.variabelenaam) ? 1 : 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof VariabeleUitdrukking u && variabelenaam.equals(u.variabelenaam);
	}
	
	@Override
	public int hashCode() {
		return variabelenaam.hashCode();
	}
	
	@Override
	public void forEachVariabeleUitdrukking(Consumer<? super VariabeleUitdrukking> consumer) {
		consumer.accept(this);
	}

}
