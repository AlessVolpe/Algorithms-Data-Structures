import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> S = new ArrayList<>();
        ArrayList<String> U = new ArrayList<>();
        PuzzleSolve.solutionCount = 0;

        System.out.print("Enter the puzzle: ");
        PuzzleSolve.strPuzzle = input.nextLine();

        for (int i = 0; i < PuzzleSolve.strPuzzle.length(); i++) {
            char c = PuzzleSolve.strPuzzle.charAt(i);
            if (!PuzzleSolve.letters.contains(c) && PuzzleSolve.isOnlyLetters(Character.toString(c))) 
                PuzzleSolve.letters.add(c);
        }

        for (int i = 0; i < 10; i++) U.add(Integer.toString(i));

        PuzzleSolve.puzzleSolve(PuzzleSolve.letters.size(), S, U);

        if (PuzzleSolve.solutionCount == 1) System.out.println("Found 1 Solution");
        else System.out.println("Found " + PuzzleSolve.solutionCount + " Solutions");

        input.close();
    }
}
