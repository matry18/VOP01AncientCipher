/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

/**
 *
 * @author aalsc
 */
public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
        if (rotFactor < 0) {
            this.rotFactor = rotFactor * -1;
            System.out.println("rotFactor is less than 0 and is now converted to: " + rotFactor);
        } else {
            this.rotFactor = rotFactor;
        }
        while (rotFactor > ALPHABETH.length) {
            this.rotFactor = rotFactor % ALPHABETH.length;
        }
    }

    @Override
    public String encrypt(String original) {
        char[] originalArray = original.toCharArray();
        StringBuilder sb = new StringBuilder(original.length());
        for (int i = 0; i < originalArray.length; i++) {
            int charIndex = findCharIndex(originalArray[i]);
            if (charIndex != -1) {
                charIndex += rotFactor;
                sb.append(alphabethCheck(charIndex));
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
                charIndex -= rotFactor;
                sb.append(alphabethCheck(charIndex));
            } else {
                sb.append(encryptedArray[i]);
            }
        }
        return sb.toString();
    }

}
