
import java.math.*;
import java.util.*;

public class BabyStep {
	HashMap<BigInteger, BigInteger> xbPair;
	BigInteger p;
	BigInteger generator;
	BigInteger m;
	public BabyStep(BigInteger p, BigInteger generator){
		this.p = p;
		this.xbPair = new HashMap();
		this.generator = generator;
	}
	
	//Newton's method
	public BigInteger sqrtCeil(BigInteger num){
		if(num == BigInteger.ZERO || num == BigInteger.ONE){
			return num;
		}
		
		BigInteger two = BigInteger.valueOf(2);
		BigInteger y;
		for(y = num.divide(two); y.compareTo(num.divide(y)) >0; y = ((num.divide(y)).add(y)).divide(two));
		if(num.compareTo(y.multiply(y))== 0){
			return y;
		}
		else {
			return y.add(BigInteger.ONE);
		}
	}
	
	public void generateBabyStep(){
		this.m = sqrtCeil(p);
		BigInteger newBigInt = new BigInteger("0");
		
		while (newBigInt.compareTo(m) < 0){
			BigInteger x = generator.modPow(newBigInt, p);
			xbPair.put(newBigInt, x);
			newBigInt = newBigInt.add(BigInteger.ONE);
		}
		
	}
	
	public BigInteger getMInverse(){
		BigInteger inverse = generator.modInverse(p);
		return inverse.modPow(m, p);
	}
	

}
