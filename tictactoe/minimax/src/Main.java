import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            System.out.println("Welcome to a game of tictactoe!");
            char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
            printboard(board);

            Scanner scanner = new Scanner(System.in);
            String user_input;
            Random rand = new Random();
            int computer_choice;

            while (done(board) != true) {

                // check if userinput is ok
                while (true) {
                    System.out.print("Where do you want to place your marker? (1-9): ");
                    // Scanner only does strings
            
                    user_input = scanner.nextLine();
                    if (isvalidmove(board, user_input) == true) {
                        break;
                    }
                    System.out.println("Invalid move. Please try again.");
                }

                System.out.println("You placed your marker at: " + user_input);
                placemarker(board, user_input, 'X');
                printboard(board);

                if (checkwinner(board) == true) {
                    System.out.println("Congratulations, you won!");
                    break;
                }
        
                if (done(board) == true) {
                    System.out.println("It's a tie!");
                    break;
                }

            

                // for random available spot
                // while (true) {
                //     computer_choice = rand.nextInt(1, 10);
                //     if (isvalidmove(board, Integer.toString(computer_choice)) == true) {
                //         break;
                //     }
                // }

                // minimax method
                computer_choice = bestmove(board) + 1;
        
                System.out.println("The computer placed its marker at: " + computer_choice);
                placemarker(board, Integer.toString(computer_choice), 'O');
                printboard(board);

                if (checkwinner(board) == true) {
                    System.out.println("You lost!");
                    break;
                }
            }

            while (true) {
                System.out.print("Would you like to play again? (y/n): ");
                // Scanner only does strings
        
                user_input = scanner.nextLine();
                if (user_input.equals("y") || user_input.equals("n")) {
                    break;
                }
                System.out.println("Invalid move. Please try again.");
            }

            if (user_input.equals("n")) {
                scanner.close();
                break;
            }
        }
        
    }

    public static void printboard(char[] board) {
        System.out.println(board[0] + "|" + board[1] + "|" + board[2]);
        System.out.println(board[3] + "|" + board[4] + "|" + board[5]);
        System.out.println(board[6] + "|" + board[7] + "|" + board[8]);
    }

    // for minimax alg
    // returns the best move the computer can play as an index on char[] board
    public static int bestmove(char[] board) {
        int bestscore = Integer.MIN_VALUE;
        int move = -1;
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                board[i] = 'O';
                int score = minimax(board, 0, 'X');
                board[i] = Character.forDigit(i+1, 10);
                if (score > bestscore) {
                    bestscore = score;
                    move = i;
                }
            } 
        }
        return move;
    }

    // X is minimizing
    // O is maximizing
    public static int minimax(char[] board, int depth, char turn) {
        if (checkwinner2(board) == 'X') {
            return -1-1/depth;
        }
        else if (checkwinner2(board) == 'O') {
            return 1+1/depth;
        } else if (done(board)) {
            return 0;
        }
        
        if (turn == 'O') {
            int bestscore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] != 'X' && board[i] != 'O') {
                    board[i] = 'O';
                    int score = minimax(board, depth + 1, 'X');
                    board[i] = Character.forDigit(i+1, 10);
                    bestscore = Math.max(score, bestscore);
                } 
            }
            return bestscore;
        } else {
            int bestscore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] != 'X' && board[i] != 'O') {
                    board[i] = 'X';
                    int score = minimax(board, depth + 1, 'O');
                    board[i] = Character.forDigit(i+1, 10);
                    bestscore = Math.min(score, bestscore);
                    
                } 
            }
            return bestscore;
        }

    }

    public static boolean isvalidmove(char[] board, String input) {
        int choice = Integer.parseInt(input);
        if (choice > 9 || choice < 1) {
            return false;
        }
        if (board[choice - 1] == 'X' || board[choice - 1] == 'O') {
            return false;
        }
        return true;
    }

    public static boolean done(char[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return false;
            } 
        }
        return true;
    }

    public static boolean checkwinner(char[] board) {
        if (board[0] == board[1] && board[1] == board[2]) {
            return true;
        }
        else if (board[3] == board[4] && board[4] == board[5]) {
            return true;
        }
        else if (board[6] == board[7] && board[7] == board[8]) {
            return true;
        }
        else if (board[0] == board[3] && board[3] == board[6]) {
            return true;
        }
        else if (board[1] == board[4] && board[4] == board[7]) {
            return true;
        }
        else if (board[2] == board[5] && board[5] == board[8]) {
            return true;
        }
        else if (board[0] == board[4] && board[4] == board[8]) {
            return true;
        }
        else if (board[2] == board[4] && board[4] == board[6]) {
            return true;
        }
        else {
            return false;
        }
    }

    public static char checkwinner2(char[] board) {
        if (board[0] == board[1] && board[1] == board[2]) {
            return board[0];
        }
        else if (board[3] == board[4] && board[4] == board[5]) {
            return board[3];
        }
        else if (board[6] == board[7] && board[7] == board[8]) {
            return board[6];
        }
        else if (board[0] == board[3] && board[3] == board[6]) {
            return board[0];
        }
        else if (board[1] == board[4] && board[4] == board[7]) {
            return board[1];
        }
        else if (board[2] == board[5] && board[5] == board[8]) {
            return board[2];
        }
        else if (board[0] == board[4] && board[4] == board[8]) {
            return board[0];
        }
        else if (board[2] == board[4] && board[4] == board[6]) {
            return board[2];
        }
        else {
            return 'N';
        }
    }

    public static void placemarker(char[] board, String input, char turn) {
        switch(input) {
            case "1":
                board[0] = turn;
                break;
            case "2":
                board[1] = turn;
                break;
            case "3":
                board[2] = turn;
                break;
            case "4":
                board[3] = turn;
                break;
            case "5":
                board[4] = turn;
                break;
            case "6":
                board[5] = turn;
                break;
            case "7":
                board[6] = turn;
                break;
            case "8":
                board[7] = turn;
                break;
            case "9":
                board[8] = turn;
                break;
            default:
                // this should never be printed
                System.out.println("Wrong input");

        }
    }

}
