package Exercise230710;

import java.util.*;

public class Percorso extends ArrayList<Stazione> implements Comparable<Percorso>{
    public List<Stazione> stazioniPercorso;
    public int numeroStazioni;
    public int distanzaTotale;

    public Percorso(List<Stazione> stazioniPercorso) {
        super();
        this.stazioniPercorso = stazioniPercorso;
    }

    @Override
    public int compareTo(Percorso o) {
        if (numeroStazioni != o.numeroStazioni) {
            return Integer.compare(this.numeroStazioni, o.numeroStazioni);
        } else {
            return Integer.compare(this.distanzaTotale, o.distanzaTotale);
        }
    }
}
