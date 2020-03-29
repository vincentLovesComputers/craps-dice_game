/** Program that plays the casino games of Craps. At the beginning of
 * the game, the player rolls a pair of dice and computes the total.
 *
 * If the first roll is a 2, 3 or 12 it's a crap and  you lose
 * If the first roll is a 7 or 11 it's a natural and you win
 * If the roll is any other number, that number becomes the "point"
 * From here, the player keeps rolling the dice until (a) the point
 * comes up again, in which case the player wins or (b) a 7 appears and
 * the player loses. Note that the numbers
 *  2,3,11, 12 have no special significance after the first roll
 */

import acm.program.*;
import acm.util.*;

public class Craps extends ConsoleProgram {
    /* Run the program */
    public void run(){
        int total = rollDice();
        if(total==2 || total == 3 || total == 12){
            println("You rolled a craps. You lose");
        }
        else if(total == 7 || total == 11){
            println("You rolled a natural. You win");
        }

        else{
            int point = total;
            println("Your point is " + point + ".");
            while(true){
                total = rollDice();
                if(total == point){
                    println("You made your point. You win");
                    break;
                }
                else if(total == 7){
                    println("You rolled a 7. You lose");
                    break;
                }
            }
        }
    }

    /* return total after dice roll*/
    private int rollDice(){
        int d1 = rgen.nextInt(1, 6);
        int d2 = rgen.nextInt(1,6);
        int total = d1 + d2;
        println("Rolling dice "  + d1 + " and " + d2 + " = " + total);
        return total;
    }

    /* Instance variable for the random number generator*/
    private RandomGenerator rgen  = new RandomGenerator();
}


