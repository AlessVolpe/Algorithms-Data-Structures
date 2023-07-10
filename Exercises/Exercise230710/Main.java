package Exercise230710;

import java.io.*;
import java.util.*;

public class Main {
    public static void driver(Autostrada autostrada, String filePath) {
        try {
            File toRead = new File(filePath);
            Scanner sc = new Scanner(toRead);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] array = line.split(" ");

                switch (array[0]) {
                    case "aggiungi-stazione":
                        try {
                            Stazione stazione = autostrada.aggiungiStazione(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                            for (int i = 3; i <= Integer.parseInt(array[2]) + 2; i++) {
                                stazione.aggiungiVeicolo(Integer.parseInt(array[i]));
                            }
                            System.out.println("Aggiunta stazione con " + array[2]  + " veicoli al km " + array[1]);
                        } catch (Exception e) {
                            System.out.println("Stazione non aggiunta");
                            e.printStackTrace();
                        }
                        
                        break;
                    case "aggiungi-auto":
                        try {
                            for (Stazione elem : autostrada.stazioniServizio) {
                                if (elem.distanza == Integer.parseInt(array[1])) {
                                    elem.aggiungiVeicolo(Integer.parseInt(array[2]));
                                    System.out.println("Aggiunto veicolo con autonomia " + array[2] + " alla stazione al km " + array[1]);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Veicolo non aggiunto");
                            e.printStackTrace();
                        }
                        break;
                    case "demolisci-stazione":
                        try {
                            for (Stazione elem : autostrada.stazioniServizio) {
                                if (elem.distanza == Integer.parseInt(array[1])) 
                                    autostrada.demolisciStazione(elem);
                                else
                                    throw new Exception("Impossibile trovare stazione al km " + array[1]);
                            }
                            System.out.println("Rimossa stazione al km: " + array[1]);
                        } catch (Exception e) {
                            System.out.println("Stazione non rimossa");
                            e.printStackTrace();
                        }
                        break;
                    case "pianifica-percorso":
                        try {
                            List<Stazione> percorso = autostrada.trovaPercorso(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                            if (percorso != null) {
                                for (Stazione elem : autostrada.stazioniServizio) {
                                    if (elem.distanza == Integer.parseInt(array[1]))
                                        percorso.add(0, elem);
                                    else ;
                                }
                                
                                System.out.println("Percorso il percorso più veloce passa per: " + percorso.toString().replace(" ,", ",").replace(" ]", "]"));
                            } else throw new Exception("Percorso non trovato");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println(array[0] + ": Funzione non supportata");
                        break;
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Autostrada autostrada = new Autostrada();
        driver(autostrada, "C:\\Users\\aless\\OneDrive\\Documenti\\Universit\u00E0\\Lezioni\\ASD\\Exercises\\Exercise230710\\open_1.txt");
        System.out.println(autostrada.toString());
    }
}
