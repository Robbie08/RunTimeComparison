/**
 * Author: Roberto Ortiz
 * Project: BinarySearch
 * Date: 10/4/18
 */

import java.security.SecureRandom;
import java.util.Arrays;

class BinarySearch {

    private static int iCount; // will keep the count of iterations for each array
    void runBinarySearch() {

        String[] saData = {"boba","desk","light","door","glasses","attention","brain","phone","sony","tuna","bull","red"};
        int iTotalWords = 12;
        SecureRandom oRand = new SecureRandom();
        String sTarget = saData[oRand.nextInt(iTotalWords)]; //get our target val
        int iIndex; // holds the returned value of our search functions

        Arrays.sort(saData); // sort our array to prepare it for binary s.

        // ----------------- BINARY SEARCH ----------------/
        System.out.println("\n-------BINARY SEARCH-------");
        long lBegTime = System.nanoTime();
        iIndex = stringBinarySearch(saData,sTarget,0, saData.length - 1);
        long lEndTime = System.nanoTime();
        System.out.println("Elapsed time: " + (lEndTime - lBegTime)); // print our the time it took to run algorithm
        System.out.println("Target[ " +sTarget +" ] found at index: " +iIndex);
        System.out.println("Looped: " +iCount +" times");

        iCount = 0; // reset our count

        // ----------------- LINEAR SEARCH ----------------/
        System.out.println("\n-------LINEAR SEARCH-------");
        lBegTime = System.nanoTime();
        iIndex = stringLinearSearch(saData,sTarget);
        lEndTime = System.nanoTime();
        System.out.println("Elapsed time: " + (lEndTime - lBegTime)); // print out the time it took to run algorithm
        System.out.println("Target[ " +sTarget +" ] found at index: " +iIndex);
        System.out.println("Looped: " +iCount +" times");

        // ------------- PRINT STATEMENTS -----------------/
        System.out.println("\n---------ARRAY----------");
        // TEST PRINT ARRAY
        for(int i = 0; i < saData.length; i++){
            System.out.println("Index " +i +": " +saData[i]);
        }
    }
    /**
     * Recursive Binary Search --- run time : O(log(n))
     *
     * @param sArray : array to be searched
     * @param sTarget: String that the binary Search will target
     * @param iMin : The smallest index value of search array
     * @param iMax : The largest index value of search array
     * @return Index at which the term was found
     */
    private int stringBinarySearch(String[] sArray, String sTarget, int iMin, int iMax){
        iCount++;
        int iMiddle = (iMax + iMin) / 2; // set our array partition
        // Check if the String in the middle of the array is equal to our target
        if(sTarget.equals(sArray[iMiddle])) {
            return iMiddle;
        }
        if(sTarget.compareTo(sArray[iMiddle]) > 0) {
            // if the value is to the right of the array
            return stringBinarySearch(sArray,sTarget,iMiddle + 1,iMax);
        }
        else {
            // if the value is to the left of the array
            return stringBinarySearch(sArray,sTarget,iMin,iMiddle - 1);
        }
    }

    /**
     * Linear Search --- run time: O(n)
     *
     * @param sArray: The array that will be searched
     * @param sTarget: The value to find in the array
     * @return index value at where the sTarget is located
     */
    private int stringLinearSearch(String[] sArray, String sTarget){

        for(int i = 0; i < sArray.length; i++){
            iCount++;
            if(sTarget.equals(sArray[i]))
                return i; // return the index if found

        }
        return  -1; // return -1 so we know the value was not found
    }

}
