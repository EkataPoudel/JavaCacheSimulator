/* ****************************************
 *  Author : Ekata Poudel   
 *  Created On : Fri Sep 20 2024
 *  File : ArrayCache.java
 *  Description: This is the ArrayCache class that lives in the package cache
 * This class has the private attributes 
 * -entries:CacheEntry[] // The array of the objects in the class CacheEntry
 * -numEntries: int // The integer value of the numEntries
 * -numHits: int // The integer value for number of hits
 * -numMisses: int // The integer value for the number of misses
 * 
 * This class have 
 * ArrayCache()//It is the default constructor set the entries to zero.
 *ArrayCache(sz:int)// it is the overload constructor thst set entries to an array of szCacheEntrys and set other attributes to zero
 *put(name:String,value:String):void // This takes the name and value (URL and IP address)
 *get(name:String):String: //This takes name and searches entries for a cache with the given name
 *getHits():int: //Getters
 *getMisses():int: //Getters
 *clear():void : //Setting numEntries and numMisses to zero
 *isEmpty():boolean //returns false if the cache is empty
 *toString():String  //returns string in the format
 *shiftEntries(endIdx:int):void  :\ //shift all the entries from index zero to endidx-1
 * 
 * ******************************************/

import java.util.Arrays;

public class ArrayCache {
    // Dclearing the attributes
    private CacheEntry[] entries;
    private int numEntries;
    private int numHits;
    private int numMisses;

    public ArrayCache() {
        // SETTING DEFAULT
        // FOR ARRAY OF 10 CACHEENTRY
        entries = new CacheEntry[10];

        // Setting numEntries, numHits, and numMiss to 0
        numEntries = 0;
        numHits = 0;
        numMisses = 0;
    }

    // THE OVERLOAD CONSTRUCTOR SETS ENTRIES TO AN ARRAY OF SZ CACHE AND NUMENTRIES
    // NUMHITS AND NUM MISSES TO ZERO
    public ArrayCache(int sz) {
        if (sz <= 0) {
            throw new IllegalArgumentException(" Size must be positive.");
        }
        entries = new CacheEntry[sz];
        numEntries = 0;
        numHits = 0;
        numMisses = 0;
    }

    public void put(String name, String value) {

        // TAKES THE NAME AND SIZE AND ADD IT TO THE CACHE
        CacheEntry addNewEntry = new CacheEntry(name, value);
        shiftEntries(numEntries);
        // ADDING THE NEW ENTRY TO THE INDEX[0] AFTER REMOVING THE LEAST RECENTLY USED
        // DATA
        entries[0] = addNewEntry;

        // INCREMENTING THE NUMENTRIES IF THE NUMBER OF ENTRIES IS LESS THEN THE LENGTH
        // OF THE ARRAY OF THE ENTRIES
        if (numEntries < entries.length) {
            numEntries++;

        }
    }

    public String get(String name) {
        // DECLARING THE IDX
        int idx = -1;
        for (int i = 0; i < numEntries; i++) {
            if (entries[i].getName().equals(name)) {
                idx = i; // WHEN THE NAME OF ENTRIES FOR A CACHE ENTRY MATCH WITH THE NAME
                break; // TO EXIT THE LOOP AFTER FINDING THE MATCH
            }
        }

        // IF THE IDX IS NOT EQUAL TO -1 CAUSE -1 IS INVALID INDEX
        if (idx != -1) {
            CacheEntry foundEntry = entries[idx]; // IF THE CACHE ENTRY IS VALID THE NEW FOUND ENTRY IS SAVED AT IDX

            shiftEntries(idx);

            // SAVING THE fFOUND ENTRY PLACED AT ZERO
            entries[0] = foundEntry;

            // SSATIESFIES SO INCREASING THE NUMHIT++
            numHits++;

            // RETURNING THE FOUND VALUE
            return foundEntry.getValue();
        } else {

            // INCREMENTED THE NUMMISS COUNTER
            numMisses++;

            // RETURNING THE NULL;
            return null;

        }
    }

    public int getNumHits() {
        return numHits;
    }

    public int getNumMisses() {
        return numMisses;
    }

    // CLEARING THE SETS
    public void clear() {
        numEntries = 0;
        numHits = 0;
        numMisses = 0;
    }

    // RETURNING TRUE IF THE CACHE IS EMPTY OTHERWISE FALSE
    public boolean isEmpty() {
        return numEntries == 0;
    }

    // THE TO STRING
    @Override
    public String toString() {
        String result = "Entries: " + numEntries + "\n" +
                "   Hits: " + numHits + "\n" +
                "Misses: " + numMisses + "\n";
        for (int i = 0; i < numEntries; i++) {
            if (entries[i] != null) {
                result += entries[i].toString() + "\n";
            }
        }
        return result;
    }

    // THIS METHODS TAKES AN INDEX ENDIDX FROM INDEX ZERO TO ENDIDX -1
    private void shiftEntries(int endIdx) {
        if (endIdx == entries.length)
            endIdx--;
        for (int i = endIdx - 1; i >= 0; i--) {
            entries[i + 1] = entries[i];
        }
    }

}