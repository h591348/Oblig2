package no.hvl.dat102.oving4.oppgave1.kjedet;

//****************************************************************

//    Representerer en iterator for en kjedet struktur av noder 
//    kjedet lineært.
//****************************************************************
import no.hvl.dat102.LinearNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ole olsen
 * 
  */

public class KjedetIterator<T> implements Iterator<T> {
	private LinearNode<T> aktuell; // den aktuelle posisjonen.

	/*************************************************************
	 * Lager en iterator (oppramsar)..
	 *************************************************************/
	/**
	 * @param samling
	 */
	public KjedetIterator(LinearNode<T> samling) {
		aktuell = samling;
	}

	/************************************************************
	 * Returnerer sann hvis iteratoren har minst ett element igjen.
	 *************************************************************/
		
	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	/*************************************************************
	 * Returnerer neste element hvis det fins.
	 *************************************************************/

	@Override
	public T next() {
		T resultat;
		if (!hasNext())
			throw new NoSuchElementException();
		resultat = aktuell.getElement();
		aktuell = aktuell.getNeste();
		
		return resultat;
	}

	/*************************************************************
	 * Fjern er ikke implementert..
	 *************************************************************/
	@Override
	public void remove() {
		System.out.println("Denne er ikke implementert.");
	}

}
