/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciphergenerator;

/**
 *
 * @author minis_a
 */
public interface Cipher {
    public String encrypt(String plainText);
    public String decrypt(String encryptedText);
}
