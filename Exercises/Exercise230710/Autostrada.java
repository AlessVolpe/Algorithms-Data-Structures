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

    public List<Stazione> trovaPercorso(int distanzaPartenza, int distanzaArrivo) {
        PriorityQueue<List<Stazione>> queue = new PriorityQueue<List<Stazione>>();

        for (Stazione stazione : this.stazioniServizio) {
            if (stazione.distanza <= distanzaPartenza && stazione.distanza > 0) {
                List<Stazione> percorso = new ArrayList<Stazione>();
                percorso.add(stazione);
                queue.offer(percorso);
            }
        }

        while (!queue.isEmpty()) {
            List<Stazione> percorsoCorrente = queue.poll();
            Stazione stazioneCorrente = percorsoCorrente.get(percorsoCorrente.size() - 1);
            int distanzaCorrente = stazioneCorrente.distanza;

            if (distanzaCorrente == distanzaArrivo) return percorsoCorrente;

            for (Stazione prossimaStazione : this.stazioniServizio) {
                int prossimaDistanza = prossimaStazione.distanza;

                for (Veicolo veicolo : stazioneCorrente.parcoAuto) {
                    if (prossimaDistanza > distanzaCorrente && prossimaDistanza - distanzaCorrente <= veicolo.autonomia) {
                        List<Stazione> nuovoPercorso = new ArrayList<>(percorsoCorrente);
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
