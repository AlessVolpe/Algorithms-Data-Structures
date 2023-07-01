package Recursion.DrawRuler;

public class DrawRuler {
    public static void drawRuler(int nInches, int majorLenght) {
        DrawTicks.drawOneTick(majorLenght, 0);
        for (int i = 1; i <= nInches; i++) {
            DrawTicks.drawTicks(majorLenght-1);
            DrawTicks.drawOneTick(majorLenght, i);
        }
    }
}
