package Ricorsione.PuzzleSolve;

import java.util.*;

public class PuzzleSolve {
    public static String strPuzzle;
    public static ArrayList<Character> letters = new ArrayList<Character>();
    public static int solutionCount;

    public static void puzzleSolve(int k, ArrayList<String> S, ArrayList<String> U){
        for (int i = 0; i < U.size(); i++) {
            String e = U.get(i);
            S.add(e); U.remove(e);

            if (k == 1) checkSolution(S);
            else puzzleSolve(k - 1, S, U);

            S.remove(e); U.add(i, e);
        }
    }

    public static void checkSolution(ArrayList<String> S) {
        String strResult = strPuzzle;
        int index = 0, sum = 0, result;

        for (int i = 0; i < letters.size(); i++) {
            strResult = strResult.replaceAll(letters.get(i).toString(), S.get(index));
            index++;
            if (index > S.size()) index = 0;
        }

        String[] strParts = strResult.replaceAll("\\s", "").split("[\\+=]");

        for (int i = 0; i < strParts.length -1; i++) sum += Integer.parseInt(strParts[i]);

        result = Integer.parseInt(strParts[strParts.length - 1]);

        if (sum == result) {
            System.out.println(strResult);
            solutionCount++;
        }
    }

    public static boolean isOnlyLetters(String s) {
        return s.matches("[a-zA-Z]+");
    }
}
