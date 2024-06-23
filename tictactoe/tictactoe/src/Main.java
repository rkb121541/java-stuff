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

            

                // check if computerchoice is ok
                while (true) {
                    computer_choice = rand.nextInt(1, 10);
                    if (isvalidmove(board, Integer.toString(computer_choice)) == true) {
                        break;
                    }
                }
            
        
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
