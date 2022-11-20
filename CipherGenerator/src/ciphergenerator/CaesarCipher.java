/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphergenerator;

/**
 *
 * @author minis_a
 */
public class CaesarCipher implements Cipher {
    private int shift;
    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
    'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
    'W', 'X', 'Y', 'Z'};
    
    public CaesarCipher(int shift)
    {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plainText) {
        String returner = "";
        for (int i = 0; i < plainText.length(); i++)
        {
            int index = charToIndex(plainText.charAt(i));
            
            if (plainText.charAt(i) == ' ')
            {
                returner += " ";
            }
            else if (index + shift > (alpha.length - 1))
            {
                int biggerBy = index + shift - (alpha.length - 1);
                char newLetter = alpha[biggerBy - 1];
                returner = returner + newLetter;
            }
            else
            {
                char newLetter = alpha[index + shift];
                returner = returner + newLetter;
            }
        }
        return returner;
    }

    @Override
    public String decrypt(String encryptedText) {
        String returner = "";
        for (int i = 0; i < encryptedText.length(); i++)
        {
            int index = charToIndex(encryptedText.charAt(i));
            
            if (encryptedText.charAt(i) == ' ')
            {
                returner += " ";
            }
            else if (index - shift < 0)
            {
                int smallerBy = index - shift + 27;
                char newLetter = alpha[smallerBy - 1];
                returner = returner + newLetter;
            }
            else
            {
                char newLetter = alpha[index - shift];
                returner = returner + newLetter;
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
