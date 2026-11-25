import java.util.*;

public class NumberGuessingGame{

    static Scanner s = new Scanner(System.in);
    public static void printMessage(String message) throws InterruptedException{
        for(int i=0;i<message.length();i++){
            System.out.print(message.charAt(i));
            Thread.sleep(30);
        }
        System.out.println();
    }

    public static int playRound(int number,int attempts,int result) throws InterruptedException {
                while (true) {
                    int guess;
                    printMessage("Enter your guess: ");
                    try {guess = s.nextInt();}
                    catch (InputMismatchException e) {
                        printMessage("Wrong type of input...\nTry again !!"); 
                        s.next();
                        continue;
                    }
                    if (guess != number) {
                        if (guess>number) printMessage("Too high!");
                        else printMessage("Too low!");
                        attempts -= 1;
                        printMessage("Oops lost 10 points! Wrong guess\nAttempts left = "+attempts);
                        result = result - 10;
                        if(attempts>0) printMessage("Try again....");
                        else break;
                    }

                    else if(guess == number) {
                        if (result < 0 ) result = 0;
                        printMessage("Hurayyyy!! You got it right !\nYour score is "+result);
                        printMessage("Attempts left are "+attempts);
                        Thread.sleep(1000);
                        break;
                    }
                }
                return attempts;
            }
    
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        
        String message = "Welcome to Number Guessing Game!";
        printMessage(message);
        
        while (true) {
            printMessage("Pick a level to play\n1.Easy (1-10)\n2.Medium (1-50)\n3.Hard (1-100)");
            printMessage("Enter the level you want to play: ");
            int level;
            try {level = s.nextInt();}
            catch (InputMismatchException e) {
                printMessage("Wrong type of input...\nTry again!!");
                s.next();
                continue;
            }
            int attempts=0;
            int range = 10;
        
            int score = 100;
            switch(level) {
                case 1 :
                    attempts = 5;
                    range = 10;
                    break;
                case 2 :
                    attempts = 20;
                    range = 50;
                    break;
                case 3 :
                    attempts = 40;
                    range = 100;
                    break;
                default :
                    printMessage("Wrong choice! Choose again!!");
                    continue;
            }
            printMessage("Level = "+level+", attempts = "+attempts+" and range is from 1 to "+range+".");

            int number = r.nextInt(range) + 1;
            printMessage("A random number is generated between 1 to "+range+".\nNow guess that number! And you are given score of 100 at the start.\nWrong guess penalty is 10 points!");
            int result = score;

            attempts = playRound(number,attempts,result); 

            if ( attempts == 0 ) {
                printMessage("Sorry , you are out of attempts...\nThe number was "+number+"\nAnd the score is 0.");
                Thread.sleep(1000);
            }

            printMessage("Want to play again?\nIf yes press 1 else direct exiting...\n");
            int tryagain = 1;

            try {tryagain = s.nextInt();}
            catch (InputMismatchException e) {
                printMessage("Wrong type of input...\nExiting Game............");
                System.exit(0);
            }
            if (tryagain == 1) continue;
            else{
                printMessage("Program exiting...");
                System.exit(0);
            }

        }
    }
}