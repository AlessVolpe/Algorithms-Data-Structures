package Exercise230710;

import java.util.*;

public class Autostrada {
    public PriorityQueue<Stazione> stazioniServizio;

    public Autostrada() {
        this.stazioniServizio = new PriorityQueue<>();
    }

    public Stazione aggiungiStazione(int distanza, int numVeicoli) {
        Stazione stazione = new Stazione(distanza, numVeicoli);
        stazioniServizio.add(stazione);
        return stazione;
    }

    public void demolisciStazione(Stazione stazione) throws Exception {
        stazioniServizio.remove(stazione);
    }

    public Percorso trovaPercorso(int distanzaPartenza, int distanzaArrivo) {
        PriorityQueue<Percorso> queue = new PriorityQueue<Percorso>();
        Percorso percorsoCorrente;
        Percorso nuovoPercorso;
        Stazione stazioneCorrente;
        int prossimaDistanza;
        
        for (Stazione stazione : this.stazioniServizio) {
            if (stazione.distanza <= distanzaPartenza && stazione.distanza > 0) {
                Percorso percorso = new Percorso(new ArrayList<>());
                percorso.add(stazione);
                queue.offer(percorso);
            }
        }

        while (!queue.isEmpty()) {
            percorsoCorrente = queue.poll();
            stazioneCorrente = percorsoCorrente.get(percorsoCorrente.size() - 1);
            int distanzaCorrente = stazioneCorrente.distanza;

            if (distanzaCorrente == distanzaArrivo) {
                return percorsoCorrente;
            }

            for (Stazione prossimaStazione : this.stazioniServizio) {
                prossimaDistanza = prossimaStazione.distanza;

                for (Veicolo veicolo : stazioneCorrente.parcoAuto) {
                    if (prossimaDistanza > distanzaCorrente && prossimaDistanza - distanzaCorrente <= veicolo.autonomia) {
                        nuovoPercorso = new Percorso();
                        nuovoPercorso.addAll(percorsoCorrente);
                        nuovoPercorso.add(prossimaStazione);
                        queue.offer(nuovoPercorso); 
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String returnValue = "";
        for (Stazione stazione : this.stazioniServizio) {
            returnValue += stazione.toString() + " ";
        }
        return returnValue;
    }
}
