package com.reyes.controller;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Daniel
 */
public class PruebaCifrado {
    public static void main(String[] args) {
        
        String cifrado = DigestUtils.sha1Hex("abc");//123 987
        String cifrado2 = DigestUtils.md5Hex("123");
        System.out.println("Resultado cifrado: " + cifrado);
        System.out.println("Resultado cifrado2: " + cifrado2);
    }
}
