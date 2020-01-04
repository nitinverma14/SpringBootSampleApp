package com.jarvis.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class Crypto {

	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'y' };

	public String encrypt(String valueToEnc) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(valueToEnc.getBytes());
		String encryptedValue = Base64.encodeBase64URLSafeString(encValue);
		return encryptedValue;
	}

	public String decrypt(String encryptedValue) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.decodeBase64(encryptedValue);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}
	
}

