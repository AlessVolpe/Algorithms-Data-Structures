package Exercise230710;

import java.util.*;

public class Stazione implements Comparable<Stazione> {
    public int distanza; // identificatore
    public HashSet<Veicolo> parcoAuto;

    public Stazione(int distanza, int numVeicoli) {
        this.distanza = distanza;
        this.parcoAuto = new HashSet<>(numVeicoli);
    }

    public Veicolo aggiungiVeicolo(int autonomia) {
        Veicolo veicolo = new Veicolo(autonomia);
        parcoAuto.add(veicolo);
        return veicolo;
    }

    @Override
    public String toString() {
        String returnValue = "Stazione a " + this.distanza + "km: ";
        for (Veicolo veicolo : this.parcoAuto) {
            returnValue += veicolo.toString() + " ";
        }
        return returnValue;
    }

    @Override
    public int compareTo(Stazione o) {
        int cmp = Integer.compare(this.distanza, o.distanza);
        return cmp;
    }
}
