package com.cnam.democnam.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Cryptage {
	public static String crypte(String myDataBasePassword) {
        String myEncryptionPassword = "key";
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        textEncryptor.setPassword(myEncryptionPassword);
        String myEncryptedPassword = textEncryptor.encrypt(myDataBasePassword);
        return myEncryptedPassword;

}

	public static String bCrypte(String myDataBasePassword) {
		BCryptPasswordEncoder passwordEncoder  = new BCryptPasswordEncoder ();
        String myEncryptedPassword = passwordEncoder.encode(myDataBasePassword);
        return myEncryptedPassword;

}

public static String decrypte(String myEncryptedPassword) {
        String myEncryptionPassword = "key";
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(myEncryptionPassword);

        String plainText = textEncryptor.decrypt(myEncryptedPassword);

        return plainText;
}
}
