package Ricorsione.DrawRuler;

public class DrawTicks {
    public static void drawOneTick(int tickLenght) {
        drawOneTick(tickLenght, -1); 
    }
    
    public static void drawOneTick(int tickLenght, int tickLabel) {
        for (int i = 0; i < tickLenght; i++) System.out.print("-");
        if (tickLabel >= 0) System.out.print(" " + tickLabel);
        System.out.print("\n");
    }
    
    public static void drawTicks(int tickLenght) {
        if (tickLenght > 0) {
            drawTicks(tickLenght-1);
            drawOneTick(tickLenght);
            drawTicks(tickLenght-1);
        }
    }
}