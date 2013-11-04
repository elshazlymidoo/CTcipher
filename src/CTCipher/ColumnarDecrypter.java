package CTCipher;


public class ColumnarDecrypter {

    private static int noOfColumns = 10;
    private static int noOfRows = 5;

//    public static void main(String[] args) {
//        String cipherText = "h#wm#ea#eil#co#lcawaoat$m#t#h#i#cea#mal#aetlcmo#oat#h#w#cea#mal#cetlcao#oatwm#t##ei#cco#maawaett$mo#m#t#hei#ceo#malwaetl3mo#oh#wm#ea#eil#co#lcawaoat4m#wm//a#e//#co//caw//at///t#///#c///ma///et///o#///";
//        System.out.println(toPlainText(cipherText));
//    }

    public static String toPlainText(String cipherText) {
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
            plainTextMessage.append(decryptText(charArray));

            //append new line to every block
            //plainTextMessage.append("\n");

            numOfBlocks--;
        } while (numOfBlocks > 0);

        return plainTextMessage.toString();
    }

    public static char[][] toCharArrayBlock(StringBuilder cipherText) {
        char[][] charArray = new char[noOfRows][noOfColumns];
        //to convert cipherText into a charArray Block
        int position = 0;
        for (int i = 0; i < noOfColumns; i++) {
            for (int j = 0; j < noOfRows; j++) {
                charArray[j][i] = cipherText.charAt(position);
                position++;
            }
        }
        return charArray;
    }

    public static String decryptText(char[][] charArray) {
        StringBuilder plainTextBlock = new StringBuilder();
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                char character = charArray[row][col];
                if (character == '#') {
                    character = ' ';
                } else if (character == '$') {
                    character = '\n';
                } else if (character == '/') {
                    continue;
                }
                plainTextBlock.append(character);
            }
        }
        return plainTextBlock.toString();
    }
}
