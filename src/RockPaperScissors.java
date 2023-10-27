import java.util.Scanner;

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Player A, enter your move (R/P/S): ");
            String playerAMove = scanner.next().toLowerCase();

            while (!isValidMove(playerAMove)) {
                System.out.print("Invalid move. Please enter R, P, or S: ");
                playerAMove = scanner.next().toLowerCase();
            }

            System.out.print("Player B, enter your move (R/P/S): ");
            String playerBMove = scanner.next().toLowerCase();

            while (!isValidMove(playerBMove)) {
                System.out.print("Invalid move. Please enter R, P, or S: ");
                playerBMove = scanner.next().toLowerCase();
            }

            String result = determineWinner(playerAMove, playerBMove);

            System.out.println("Result: " + result);

            System.out.print("Play again? (Y/N): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("y");
        }

        System.out.println("Thanks for playing!");
    }

    private static boolean isValidMove(String move) {
        return move.equals("r") || move.equals("p") || move.equals("s");
    }

    private static String determineWinner(String moveA, String moveB) {
        if (moveA.equals(moveB)) {
            return "It's a Tie!";
        } else if ((moveA.equals("r") && moveB.equals("s")) || (moveA.equals("s") && moveB.equals("p"))
                || (moveA.equals("p") && moveB.equals("r"))) {
            return "Player A wins! " + moveA.toUpperCase() + " beats " + moveB.toUpperCase();
        } else {
            return "Player B wins! " + moveB.toUpperCase() + " beats " + moveA.toUpperCase();
        }
    }
}