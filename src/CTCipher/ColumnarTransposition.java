package CTCipher;

import java.util.Scanner;


public class ColumnarTransposition {

    public static void main(String[] args) {
        String pt = "This is just plaintext asdfadsfasd i like cats";
        System.out.println("Original message :"+pt);
        int[] key = new int[10];
        
        //promt the user for key
        System.out.print("Do you want to enter your own key :");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        //if positive response
        if( (input.compareToIgnoreCase("yes") >= 0) || (input.compareToIgnoreCase("y") >= 0) ) {
            System.out.println("Please enter a key string of 10 numbers; non-repeating; from 0-9");
            input = sc.next();
            sc.close();
            
            char[] keyStringChar = input.toCharArray();
            for(int i=0; i<10; i++) 
                key[i] = Character.getNumericValue(keyStringChar[i]); 
            
            //check if key is invalid.
            if( ColumnarUtility.duplicatesCheck(key) )
            {
                System.out.println("There was a duplicate key index in the key you provided");
                System.exit(-1);
            }
            
        }
        
        //if negative response (that is, user doesn't want to provide key)
        else 
           key = ColumnarUtility.randomIntArray(10);
        

        System.out.println("The key is "+ ColumnarUtility.keyString(key));
        String cipherText = ColumnarEncrypter.toCipherText(pt, key);
        System.out.println("CipherText is\t\t:"+cipherText);
        String originalText = ColumnarDecrypter.toPlainText(cipherText, key);
        System.out.println("Original Text is\t:" +originalText);
        
    }
}
