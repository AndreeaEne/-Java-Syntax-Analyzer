/**
 * Created by ade on 27/02/15.
 */

import java.util.*;

public class Analyzer {
    //static char letter = "[a-zA-Z]");
    static  int par = 0;

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        String expresie;

        System.out.print("E = ");
        expresie = scanner.nextLine();

        for(int i = 0; i < expresie.length(); i++)
            switch (expresie.charAt(i)) {
                case '(':
                    par++;
                    break;

                case ')':
                    par--;
                    break;

                case '+':
                    if (!Character.isLetter(expresie.charAt(i-1))) {
                        System.out.println("(+)Incorrect expression." + i);
                        System.exit(0);
                    }
                    break;

                case '*':
                    if (i > 0)
                        if (!Character.isLetter(expresie.charAt(i-1))) {
                            System.out.println("(*)Incorrect expression." + i);
                            System.exit(0);
                        }
                    break;

                default:
                    if (i > 0 && Character.isLetter(expresie.charAt(i)))
                        if (!Character.isLetter(expresie.charAt(i-1))) {
                            System.out.println("(a)Incorrect expression." + i);
                            System.exit(0);
                        }
                    break;
            }

        if (par == 0)
            System.out.println("Correct expression.");
        else
            System.out.println("(p)Incorrect expression.");
    }
}
