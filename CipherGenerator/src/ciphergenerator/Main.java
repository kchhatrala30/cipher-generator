/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ciphergenerator;

import java.util.Scanner;

/**
 *
 * @author minis_a
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt your text?");
        System.out.print("Enter \"E\" for encryption and \"D\" for decryption: ");
        String choice = scnr.nextLine();
        
        int userSelection = 0;
        while (userSelection != -1)
        {
            System.out.println();
            if (choice.equals("E"))
            {
                System.out.println("Would you like to encrypt using a Caesar, Trithemius or Jason cipher?");
                System.out.print("Enter \"C\" for Caesar, \"T\" for Trithemius, \"J\" for Jason: ");
                String cipherType = scnr.nextLine();
                System.out.println();

                System.out.print("Enter the string to encrypt: ");
                String toEncrypt = scnr.nextLine();

                switch (cipherType)
                {
                    case "C":
                        System.out.print("How much would you like to Caesar cipher by? ");
                        int cShift = scnr.nextInt();
                        scnr.nextLine();

                        CaesarCipher c = new CaesarCipher(cShift);
                        System.out.println(c.encrypt(toEncrypt));
                        break;

                    case "T":
                        TrithemiusCipher t = new TrithemiusCipher();
                        System.out.println(t.encrypt(toEncrypt));
                        break;

                    case "J":
                        JasonCipher j = new JasonCipher();
                        System.out.println(j.encrypt(toEncrypt));
                        break;
                }
            }
            else
            {
                System.out.println("Would you like to decrypt using a Caesar, Trithemius or Jason decipher?");
                System.out.print("Enter \"C\" for Caesar, \"T\" for Trithemius, \"J\" for Jason: ");
                String decipherType = scnr.nextLine();
                System.out.println();

                System.out.print("Enter the string to decrypt: ");
                String toDecrypt = scnr.nextLine();

                switch (decipherType)
                {
                    case "C":
                        System.out.print("How much would you like to Caesar decipher by? ");
                        int cShift = scnr.nextInt();
                        scnr.nextLine();

                        CaesarCipher c = new CaesarCipher(cShift);
                        System.out.println(c.decrypt(toDecrypt));
                        break;

                    case "T":
                        TrithemiusCipher t = new TrithemiusCipher();
                        System.out.println(t.decrypt(toDecrypt));
                        break;

                    case "J":
                        JasonCipher j = new JasonCipher();
                        System.out.println(j.decrypt(toDecrypt));
                        break;
                }
            }
            
            System.out.print("Enter -1 to exit, or 1 to continue: ");
            userSelection = scnr.nextInt();
            scnr.nextLine();
        }
    }
}
