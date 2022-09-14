package uitdrukkingen;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @immutable
 * 
 * @invar | getLinkerdeeluitdrukking() != null
 * @invar | getRechterdeeluitdrukking() != null
 */
public class Optelling extends Uitdrukking {
	
	/**
	 * @invar | linkerdeeluitdrukking != null
	 * @invar | rechterdeeluitdrukking != null
	 */
	private Uitdrukking linkerdeeluitdrukking;
	private Uitdrukking rechterdeeluitdrukking;
	
	public Uitdrukking getLinkerdeeluitdrukking() { return linkerdeeluitdrukking; }
	public Uitdrukking getRechterdeeluitdrukking() { return rechterdeeluitdrukking; }

	/**
	 * @throws IllegalArgumentException | linkerdeeluitdrukking == null
	 * @throws IllegalArgumentException | rechterdeeluitdrukking == null
	 * 
	 * @post | getLinkerdeeluitdrukking() == linkerdeeluitdrukking
	 * @post | getRechterdeeluitdrukking() == rechterdeeluitdrukking
	 */
	public Optelling(Uitdrukking linkerdeeluitdrukking, Uitdrukking rechterdeeluitdrukking) {
		if (linkerdeeluitdrukking == null)
			throw new IllegalArgumentException("`linkerdeeluitdrukking` is null");
		if (rechterdeeluitdrukking == null)
			throw new IllegalArgumentException("`rechterdeeluitdrukking` is null");
		
		this.linkerdeeluitdrukking = linkerdeeluitdrukking;
		this.rechterdeeluitdrukking = rechterdeeluitdrukking;
	}
	
	/**
	 * @throws IllegalArgumentException | variabelenaam == null
	 * 
	 * @post | result == getLinkerdeeluitdrukking().getAantalVoorkomens(variabelenaam) + getRechterdeeluitdrukking().getAantalVoorkomens(variabelenaam)
	 */
	@Override
	public int getAantalVoorkomens(String variabelenaam) {
		return linkerdeeluitdrukking.getAantalVoorkomens(variabelenaam) + rechterdeeluitdrukking.getAantalVoorkomens(variabelenaam);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Optelling o && linkerdeeluitdrukking.equals(o.linkerdeeluitdrukking) && rechterdeeluitdrukking.equals(o.rechterdeeluitdrukking);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(linkerdeeluitdrukking, rechterdeeluitdrukking);
	}
	
	@Override
	public Iterator<Uitdrukking> getDeeluitdrukkingenIterator() {
		return new Iterator<Uitdrukking>() {
			int index;
			@Override
			public boolean hasNext() {
				return index < 2;
			}
			@Override
			public Uitdrukking next() {
				return index++ == 0 ? linkerdeeluitdrukking : rechterdeeluitdrukking;
			}
		};
	}
	
	@Override
	public void forEachVariabeleUitdrukking(Consumer<? super VariabeleUitdrukking> consumer) {
		linkerdeeluitdrukking.forEachVariabeleUitdrukking(consumer);
		rechterdeeluitdrukking.forEachVariabeleUitdrukking(consumer);
	}
	
}
