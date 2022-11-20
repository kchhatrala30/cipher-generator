/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphergenerator;

/**
 *
 * @author minis_a
 */
public class TrithemiusCipher implements Cipher {
    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
    'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
    'W', 'X', 'Y', 'Z'};
    
    public TrithemiusCipher()
    {
        
    }

    @Override
    public String encrypt(String plainText) {
        String returner = "";
        int alphaIndex = 0;
        
        for (int i = 0; i < plainText.length(); i++)
        {
            if (plainText.charAt(i) == ' ')
            {
                returner += " ";
                alphaIndex = 0;
            }
            else if (alphaIndex + plainText.charAt(i) > (alpha.length - 1))
            {
                int temp = (alphaIndex + charToIndex(plainText.charAt(i))) % (alpha.length);
                returner += alpha[temp];
                alphaIndex++;
            }
            else
            {
                returner += alpha[charToIndex(plainText.charAt(i))] + i;
                alphaIndex++;
            }
        }
        return returner;
    }

    @Override
    public String decrypt(String encryptedText) {
        String returner = "";
        int index = 0;
        
        for (int i = 0; i < encryptedText.length(); i++)
        {
            if (encryptedText.charAt(i) == ' ')
            {
                returner += " ";
                index = 0;
            }
            else if (charToIndex(encryptedText.charAt(i)) - index < 0)
            {
                char temp = alpha[(alpha.length - 1) - (index - charToIndex(encryptedText.charAt(i)) - 1)];
                returner += temp;
                index++;
            }
            else
            {
                char temp = alpha[charToIndex(encryptedText.charAt(i)) - index];
                returner += temp;
                index++;
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
