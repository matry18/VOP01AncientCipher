package ancient_encryption;

import static ancient_encryption.CipherInterface.ALPHABETH;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aalsc
 */
public abstract class AbstractCipher implements CipherInterface {

    int findCharIndex(char ch) {
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ALPHABETH[i] == ch) {
                return i;
            }

        }
        return -1;
    }

    public char alphabethCheck(int charIndex) {
        if (charIndex > ALPHABETH.length) {
            charIndex -= ALPHABETH.length;
        }
        while (charIndex < 0) {
            charIndex += ALPHABETH.length;
        }
        return ALPHABETH[charIndex];
    }

}
    
