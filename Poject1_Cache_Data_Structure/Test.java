/* ****************************************
 *  Author : Ekata Poudel   
 *  Created On : Wed Sep 24 2024
 *  File : Test.java
 *  Description: This is the main class that main this method is responsible 
 * for prompting the user for the query File and the the
 * size of the cache (must be a positive number, be sure to ask again if not a given a valid
 * size), then it creates the ArrayCache and calls the simulate method followed by the
 * printStats method.
 * 
 * ******************************************/

import java.util.Scanner;

//THE MAIN CLASS THAT GIVES THE  USER PROMPT AND OUTPUT
public class Test{
        public static void main(String[] args) {
                 Scanner scanner = new Scanner(System.in);
        String fileName;
        int cacheSize;

        // ASKING USER TO ENTER THE FILE NAME
        System.out.println("Enter the name of the Query file: ");
        fileName = scanner.nextLine();

        // ASKING USER FOR THE CACHE SIZE
        while (true) {
            System.out.println("Enter the positive integer for the cache size:");
            try {
                cacheSize = Integer.parseInt(scanner.nextLine());
                if (cacheSize > 0) {
                    break;
                } else {
                    System.out.println(" The cache size must be positive integer.Try again");

                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number");
            }

        }
        ArrayCache cache = new ArrayCache(cacheSize);
        // SIMULATION TO GET EVERY DATA FROM THE FILE 
        SimulatesaAndPrintStats simulates = new SimulatesaAndPrintStats();
        simulates.simulates(cache, fileName);

        // THE PRINT STATS OF THE DATA
        simulates.printStats(cache);

        scanner.close();
    }
        }
 