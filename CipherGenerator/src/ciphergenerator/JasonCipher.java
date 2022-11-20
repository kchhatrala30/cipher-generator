/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphergenerator;

/**
 *
 * @author minis_a
 */
public class JasonCipher implements Cipher {
    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
    'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
    'W', 'X', 'Y', 'Z'};
    
    public JasonCipher()
    {
        
    }

    @Override
    public String encrypt(String plainText) {
        String returner = "";
        String reversedReturner = "";
        int numLetters = plainText.length();
        
        if (numLetters % 2 == 0)
        {
            for (int i = 0; i < numLetters / 2; i++)
            {
                returner += plainText.charAt(numLetters / 2 - i - 1);
            }
            
            for (int i = 0; i < numLetters / 2; i++)
            {
                int alphaIndex = charToIndex(plainText.charAt(numLetters / 2 + i));
                returner += alpha[alphaIndex + 5];
            }
            
            // Reverse string
            for (int i = 0; i < returner.length(); i++)
            {
                char temp = returner.charAt(i);
                reversedReturner = temp + reversedReturner;
            }
        }
        else if (numLetters % 2 == 1)
        {
            for (int i = 0; i < numLetters / 2 + 1; i++)
            {
                returner += plainText.charAt(numLetters / 2 - i);
            }
            
            for (int i = 0; i < numLetters / 2; i++)
            {
                int alphaIndex = charToIndex(plainText.charAt(numLetters / 2 + i + 1));
                returner += alpha[alphaIndex + 5];
            }
            
            // Reverse string
            for (int i = 0; i < returner.length(); i++)
            {
                char temp = returner.charAt(i);
                reversedReturner = temp + reversedReturner;
            }
        }
        
        return reversedReturner;
    }

    @Override
    public String decrypt(String encryptedText) {
        String returner = "";
        String reversedReturner = "";
        int numLetters = encryptedText.length();
        
        // Reverse string
        for (int i = 0; i < numLetters; i++)
        {
            char temp = encryptedText.charAt(i);
            reversedReturner = temp + reversedReturner;
        }
        
        if (numLetters % 2 == 0)
        {
            for (int i = 0; i < numLetters / 2; i++)
            {
                int alphaIndex = charToIndex(reversedReturner.charAt(numLetters / 2 + i));
                returner += alpha[alphaIndex - 5];
            }
            
            for (int i = 0; i < numLetters / 2; i++)
            {
                returner = reversedReturner.charAt(i) + returner;
            }
        }
        else if (numLetters % 2 == 1)
        {
            for (int i = 0; i < numLetters / 2; i++)
            {
                int alphaIndex = charToIndex(reversedReturner.charAt(numLetters / 2 + i + 1));
                returner += alpha[alphaIndex - 5];
            }
            
            for (int i = 0; i < numLetters / 2 + 1; i++)
            {
                returner = reversedReturner.charAt(i) + returner;
            }
        }
        
        return returner;
    }
    
    public int charToIndex(char c)
    {
        int result = (int)c;
        int lowerCase = 97;
        int upperCase = 65;
        
        if (result <= 122 && result >= 97)
        {
            result -= lowerCase;
        }
        else if (result >= 65 && result <= 90)
        {
            result -= upperCase;
        }
        
        return result;
    }
}
