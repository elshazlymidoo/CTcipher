package CTCipher;


public class ColumnarDecrypter {

    private static int noOfColumns = 10;
    private static int noOfRows = 5;

    public static void main(String[] args) {
//        String cipherText = "ea eslcawfaetlsh wmaoat$s malg t hdi cefmo odl cod";
//        System.out.println(toPlainText(cipherText));
    }
    //----------------------------------------------------------------------------- 
    public static String toPlainText(String cipherText, int[] key) {
        StringBuilder cipherTextString = new StringBuilder();
        cipherTextString.append(cipherText);

        int numOfBlocks = (cipherTextString.length() / 50);
        //System.out.println(numOfBlocks);

        //To print the ciphertext
        //System.out.println("Cipher text is : " + cipherTextString.toString());

        StringBuilder plainTextMessage = new StringBuilder();
        do {
            //conversion of cipherText to char array Block
            char[][] charArray = toCharArrayBlock(cipherTextString);

            //delete every block after each block decryption
            cipherTextString = cipherTextString.delete(0, 50);

            //decryption of cipherTextBlock to plaintext
            plainTextMessage.append(decryptText(charArray, key));

            //append new line to every block
            //plainTextMessage.append("\n");

            numOfBlocks--;
        } while (numOfBlocks > 0);

        return plainTextMessage.toString();
    }
    //----------------------------------------------------------------------------- 
    
    public static char[][] toCharArrayBlock(StringBuilder cipherText) {
        char[][] charArray = new char[noOfRows][noOfColumns];
        //to convert cipherText into a charArray Block
        int position = 0;
        for (int col = 0; col < noOfColumns; col++) {
            for (int row = 0; row < noOfRows; row++) {
                charArray[row][col] = cipherText.charAt(position);
                position++;
            }
        }
        
        //printBlock(charArray);
        return charArray;
    }
    //----------------------------------------------------------------------------- 
    
    public static String decryptText(char[][] charArray, int[] key) {
        StringBuilder plainTextBlock = new StringBuilder();
    
        int[] intArraySorted = new int[noOfColumns];
        
        //map the index position of the intArray to a sorted Array.
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(key[j] == i)
                    intArraySorted[i] = j;
            }
        }
        
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                char character = charArray[row][intArraySorted[col]];
                plainTextBlock.append(character);
            }
        }
        return plainTextBlock.toString();
    } 
    //----------------------------------------------------------------------------- 
    //For Debugging
    
    private static void printBlock(char[][] charArray) {
        
        for (int row = 0; row < noOfRows; row++) {
            
            System.out.print("| ");
            for (int col = 0; col < noOfColumns; col++) {
                System.out.print(charArray[row][col] + " | ");
            }
            System.out.println();
        }
    }
    //----------------------------------------------------------------------------- 
}
