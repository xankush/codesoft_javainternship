import java.util.Scanner;

public class guess_num {
   // for play again interface

   public static boolean again() {
      Scanner sc = new Scanner(System.in);
      System.out.println("DO YOU WANT TO PLAY AGAIN ? \n 1) true 2)false\n enter your choice:");
      return sc.nextBoolean();
   }

   public static int checkplay(int attempt, boolean play) {
      if (play == true) {
         return 0;
      } else
         System.out.println("thanku");
      return attempt;
   }

   public static void main(String[] args) {
      // for guesing the number
      boolean play = true;
      int attempt = 0;
      int total_attempt = 7;
      int score = 0;
      int i = (int) (Math.random() * 100);

      while (play) {

         // intial interferce of the game
         if (attempt == 0) {
            System.out.println("\n------------------------------------------------\n");
            System.out.print("WELCOME TO THE NUMBER GUESSING GAME");
            System.out.printf("%30s : %d\n", "score", score);
            System.out.println("Guess any num between 1 and 100");
            System.out.println("You hava 7 attempts \n");

         } else { // for try again
            System.out.println("Try again");
            System.out.println("You have " + (7 - attempt) + " left \n");
         }

         // input user choice

         Scanner sc = new Scanner(System.in);
         int guess = sc.nextInt();

         if (guess < i) {
            System.out.println("TO LOW !   [hint : choose bigger number] \n");
            attempt++;
         }
         if (guess > i) {
            System.out.println("TO HIGH !   [hint : choose smaller number]\n ");
            attempt++;
         }
         if (guess == i) {
            System.out.println("<<<<<<<YOU HAVE GUESSED IT CORRECT>>>>>>\n");
            play = guess_num.again();
            attempt = checkplay(attempt, play);
            score++;
            i = (int) (Math.random() * 100);

         }
         if (attempt == total_attempt) {
            System.out.println("You have no attempts left");
            System.out.println("Here is the number  " + "[ " + i + " ]" + "\n");
            play = guess_num.again();
            attempt = checkplay(attempt, play);
            i = (int) (Math.random() * 100);

         }

      }
   }
}
