package no.hvl.dat102.oving5.oppgave2;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
    private DobbelNode<T> foerste;
    private DobbelNode<T> siste;
    private int antall;

    // Oppgave a

    public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
        foerste = new DobbelNode<>(minVerdi);
        siste = new DobbelNode<>(maksVerdi);
        foerste.setNeste(siste);
        siste.setForrige(foerste);
        antall = 0;
    }

    @Override
    public void leggTil(T el) {
        DobbelNode<T> nyNode = new DobbelNode<>(el);
        DobbelNode<T> aktuell = foerste.getNeste();
        while ((el.compareTo(aktuell.getElement()) > 0)) {
            aktuell = aktuell.getNeste();
        }
        // Legg inn foran aktuell
        nyNode.setNeste(aktuell);
        nyNode.setForrige(aktuell.getForrige());
        aktuell.getForrige().setNeste(nyNode);
        aktuell.setForrige(nyNode);
        antall++;
    }

    @Override
    public T fjern(T el) {
        T resultat = null;
        if (erTom())
            throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
        DobbelNode<T> aktuell = finn(el);
        if (aktuell != null) { // returner og slett
            resultat = aktuell.getElement();
            aktuell.getForrige().setNeste(aktuell.getNeste());
            aktuell.getNeste().setForrige(aktuell.getForrige());
        }
        return resultat;
    }

    /**
     * Returnerer referansen til noden hvis el fins, ellers returneres
     * null-referansen
     */
    private DobbelNode<T> finn(T el) {
        DobbelNode<T> node = foerste.getNeste();
        while (node != siste && node.getElement().compareTo(el) <= 0) {
            if (node.getElement().equals(el)) {
                return node;
            }
            else {
                node = node.getNeste();
            }
        }
        return null;
    }

    // Oppgave b

    public boolean fins(T el) {
        DobbelNode<T> node = foerste.getNeste();
        while (node != siste && node.getElement().compareTo(el) <= 0) {
            if (node.getElement().equals(el)) {
                return true;
            }
            else {
                node = node.getNeste();
            }
        }
        return false;
    }

    @Override
    public boolean erTom() {
        return (antall == 0);
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public String toString() {
        String resultat = "";
        DobbelNode<T> aktuell = foerste.getNeste();
        while (aktuell != siste) {

            resultat = resultat + aktuell.getElement().toString();
            aktuell = aktuell.getNeste();
        }

        return resultat;
    }

    // Oppgave c

    public void visListe() {
        System.out.println(this);
    }

    public String tilStrengBaklengs() {
        String resultat = "";
        DobbelNode<T> aktuell = siste.getForrige();
        while (aktuell != foerste) {

            resultat = resultat + aktuell.getElement().toString();
            aktuell = aktuell.getForrige();
        }

        return resultat;

    }

}