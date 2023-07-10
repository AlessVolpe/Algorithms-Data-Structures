package Exercise230710;

public class Veicolo implements Comparable<Veicolo> {
    public int autonomia; // identificatore

    public Veicolo(int autonomia) {
        this.autonomia = autonomia;
    } 

    @Override
    public String toString() {
        return String.valueOf(this.autonomia);
    }

    @Override
    public int compareTo(Veicolo o) {
        int cmp = Integer.compare(this.autonomia, o.autonomia);
        return cmp;
    }
}
