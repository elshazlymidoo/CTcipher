package CTCipher;

public class ColumnarEncrypter {
    private static int noOfColumns = 10;
    private static int noOfRows = 5;
    
//    public static void main(String[] args) {
//        String plainText = "hello i am a cat meow cat cat meow$helloasdfsdfgsd";
//        int[] key = randomIntArray(noOfColumns);
//        System.out.println("The cipherText is :" +toCipherText(plainText, key));
//    }
//-----------------------------------------------------------------------------    
    
    private static char[][] toCharBlock(String plainText) {
        char[][] charArray = new char[noOfRows][noOfColumns];
        int lengthOfString = plainText.length();
        //System.out.println("length of string is "+lengthOfString);
        
        // Converting plainText into Block(s) of plainText
        int counter = 0;
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++,counter++) {
                //if counter is less than equal to the length of string.
                if((counter <= (lengthOfString-1))) 
                    charArray[row][col] = plainText.charAt(counter);
                else
                    charArray[row][col] = ' ';
            }
        }
        
        printBlock(charArray);
        return charArray;
    }
//-----------------------------------------------------------------------------
    
        private static void printLine() {
        for(int i=0; i<40; i++)
            System.out.print("-");
        System.out.println("");
    }
//-----------------------------------------------------------------------------
//For Debugging
        
    private static void printBlock(char[][] charArray) {
        printLine();
        for (int row = 0; row < noOfRows; row++) {
            
            System.out.print("| ");
            for (int col = 0; col < noOfColumns; col++) {
                System.out.print(charArray[row][col] + " | ");
            }
            System.out.println();
        }
        printLine();
    }
//----------------------------------------------------------------------------- 
//ColumnPositions the indices of the key.
    
    private static String toCipherTextString(char[][] charArray, int[] columnPositions) {
        StringBuilder cipherText = new StringBuilder();
        
//        for(int i=0; i<10; i++)
//            System.out.print(columnPositions[i]+" ");
//        System.out.println("");
        
        for (int col = 0; col < noOfColumns; col++) {
            for (int row = 0; row < noOfRows; row++) {
                cipherText.append(charArray[row][ columnPositions [col] ]);
            }
        }
        return cipherText.toString();
    }
//-----------------------------------------------------------------------------
//String to cipherText Engine. (driver)
//divides the string in blocks ; takes each block and ciphers it ; then appends each cipher block to a StringBuilder obj. 
    
    public static String toCipherText(String plainText, int[] key) {
        StringBuilder plainTextMessage = new StringBuilder();
        plainTextMessage.append(plainText);

        StringBuilder cipherText = new StringBuilder();

        int numOfBlocks = (int) Math.ceil(plainText.length()/50f)  ;
        //System.out.println("Number of blocks is "+numOfBlocks);

        do {
            //conversion of plainText to char array Block
            char[][] charArray = toCharBlock(plainTextMessage.toString());

            //delete every block after each block decryption
            plainTextMessage = plainTextMessage.delete(0, 50);

            //encryption of plainText to cipherText
            cipherText.append(toCipherTextString(charArray,key));

            numOfBlocks--;
        } while (numOfBlocks > 0);

        return cipherText.toString();
    }
}

