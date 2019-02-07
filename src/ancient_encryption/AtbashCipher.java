package ancient_encryption;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aalsc
 */
public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
        char[] originalArray = original.toCharArray();
        StringBuilder sb = new StringBuilder(original.length());
        for (int i = 0; i < originalArray.length; i++) {
            int charIndex = findCharIndex(originalArray[i]);
            if (charIndex != -1) {
                sb.append (ALPHABETH[ALPHABETH.length - charIndex -1]);
            } else {
                sb.append(originalArray[i]);
            }
        }
        return sb.toString();

    }

    @Override
    public String decrypt(String encrypted) {
        char[] encryptedArray = encrypted.toCharArray();
        StringBuilder sb = new StringBuilder(encrypted.length());
        for (int i = 0; i < encryptedArray.length; i++) {
            int charIndex = findCharIndex(encryptedArray[i]);
            if (charIndex != -1) {
                sb.append(ALPHABETH[ALPHABETH.length - charIndex-1]);
            } else {
                sb.append(encryptedArray[i]);
            }
        }
return sb.toString();
    }

}
