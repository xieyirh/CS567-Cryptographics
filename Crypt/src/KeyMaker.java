import java.io.File;
import java.security.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.BigInteger;

public class KeyMaker {
	
	BigInteger prime;
	BigInteger generator;
	
	public KeyMaker(String primeNumber, String generator){
		this.prime = new BigInteger(primeNumber);
		this.generator = new BigInteger(generator);
	}
	
	public BigInteger getPublicKey(){
		BigInteger publicKey;
		publicKey = generator.modPow(getPrivateKey(), prime);
		return publicKey;
		
	}
	
	public BigInteger getPrivateKey(){
		BigInteger privateKey;
		SecureRandom rand = new SecureRandom();
		do {
			privateKey = new BigInteger(prime.bitLength(),rand);
		}
		while(privateKey.compareTo(prime.subtract(BigInteger.ONE))>=0);
		
		return privateKey;
	}
	
	
	
	/*
	
	*/
}

//publicKey.modInverse(prime);
//publicKey.multipy(x). mod(p);
//g.modPow(privateKey,prime);
//private.negate();
