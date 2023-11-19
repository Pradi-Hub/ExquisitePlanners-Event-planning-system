package s_supplier;

import java.util.Random;

public class QuoteNumberGenerator {
	 private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   //Initializing the character variable 
	    private static final int length = 4;    //Initializing the length of the the string 

	    public static String generateRandomQuoteNumber() {       //creating the method of generating random numbers
	        StringBuilder sb = new StringBuilder();         //creation of string builder object
	        Random random = new Random();                   //creation of random object

	        for (int i = 0; i < length; i++) {              //Iterate within the length of the initialized string
	            int index = random.nextInt(characters.length());
	            char randomChar = characters.charAt(index);
	            sb.append(randomChar);
	        }

	        return sb.toString();       //return the generated quote number
	    }

}
