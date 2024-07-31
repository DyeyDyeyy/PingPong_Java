package myPingPong;

import java.util.Scanner;

public class PingPongCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tableWidth = 20;
        int ballPosition = tableWidth / 2;
        int ballDirection = 1; // 1 for moving right, -1 for moving left

        int paddle1Position = 1; // initial position for paddle 1
        int paddle2Position = tableWidth - 2; // initial position for paddle 2

        while (true) {
            // Print the table
            for (int i = 0; i < tableWidth; i++) {
                if (i == ballPosition) {
                    System.out.print("*");
                } else if (i == paddle1Position || i == paddle2Position) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

            // Move the ball
            ballPosition += ballDirection;

            // Check for collision with paddles
            if (ballPosition == paddle1Position || ballPosition == paddle2Position) {
                ballDirection *= -1; // Change direction
            }

            // Check for collision with walls
            if (ballPosition == 0 || ballPosition == tableWidth - 1) {
                // Game over
                System.out.println("Game Over!");
                break;
            }

            // Move the paddles
            if (scanner.hasNext()) {
                String input = scanner.next();
                if (input.equals("a") && paddle1Position > 0) {
                    paddle1Position--;
                } else if (input.equals("d") && paddle1Position < tableWidth - 3) {
                    paddle1Position++;
                } else if (input.equals("j") && paddle2Position > 0) {
                    paddle2Position--;
                } else if (input.equals("l") && paddle2Position < tableWidth - 3) {
                    paddle2Position++;
                }
            }

            // Sleep for some time to control the speed of the game
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        scanner.close();
    }
}


