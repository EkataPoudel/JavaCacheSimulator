/* ****************************************
 *  Author : Ekata Poudel   
 *  Created On : Wed Sep 24 2024
 *  File : Test.java
 *  Description: The simulate class that have 2 method 
 * +simulates(Array cache, String fileName)
 * That uses the array cache and name of teh query file as the arguments 
 *It carries the out the simulation of the DNS cache using teh data found in the query ifle
 * The program reads each line of the query file and make name followed by : and then Id address 
 * +printStats 
 * This class takes an arrayCache as an argument and prints to the screen the hit and miss and
 * and gives the miss and hit ratio in the percentage.
 * I created this class cause it was looking unclear and messy  in the main method that print.
 * ******************************************/


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SimulatesaAndPrintStats{
    // THIS WORK FOR THE QUERIES IN THE FILE 
    public void simulates(ArrayCache cache, String fileName) {
        try (FileReader reader = new FileReader(fileName)) { // READ FROM THE FILE 
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
               
                String line = scanner.nextLine();

                String[] split = line.split(":"); // USING : TO SPLIT THE NAME AND ADDRESS

                String url = split[0].trim(); // INDEX 0 FOR THE NAME
                String ip = split[1].trim(); // INDEX 1 FOR THE VALUE
                String result = cache.get(url);
                if(result == null){
                cache.put(url, ip);
                }
                System.out.println(cache.toString());

            }
        } catch (IOException e) {
            System.out.println("Error reading the query file : " + e.getMessage());
        }
    }

    // CREATING THE MISSRATE AND HIT RATE CALCULATIONS
    public void printStats(ArrayCache cache) {
        int hits = cache.getNumHits(); //CALLING FROM THE ARRAY CACHE 
        int misses = cache.getNumMisses();// CALLING FROM THE ARRAY CACHE
        int total = hits + misses; // TOTAL HITS + MISSES
        if (total > 0) {
            double hitRate = ((double) hits / total) * 100;
            double missRate = ((double) misses / total) * 100;

            System.out.printf("Hit Rate: %.2f%% Miss Rate: %.2f%%%n", hitRate, missRate);
        }
    }
}
    