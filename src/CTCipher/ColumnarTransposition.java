package CTCipher;


public class ColumnarTransposition {

    public static void main(String[] args) {
        String pt = "This is just plaintext asdfadsfasd i like cats cats are awesome meowmeow asdfhasdkfljasdhflkasdjf asdflakdsjfasdl";
        System.out.println("Original message\t:"+pt);
        String cipherText = ColumnarEncrypter.toCipherText(pt);
        System.out.println("CipherText is\t\t:"+cipherText);
        String originalText = ColumnarDecrypter.toPlainText(cipherText);
        System.out.println("Original Text is\t:" +originalText);
    }
}
