package CTCipher;


public class ColumnarTransposition {

    public static void main(String[] args) {
        String pt = "This is just plaintext asdfadsfasd i like cats ";
        System.out.println("Original message\t:"+pt);
        int[] key = randomIntArray.randomIntArray(10);
        
        System.out.println("The key is "+ randomIntArray.keyString(key));
        String cipherText = ColumnarEncrypter.toCipherText(pt, key);
        System.out.println("CipherText is\t\t:"+cipherText);
        String originalText = ColumnarDecrypter.toPlainText(cipherText, key);
        System.out.println("Original Text is\t:" +originalText);
    }
}
