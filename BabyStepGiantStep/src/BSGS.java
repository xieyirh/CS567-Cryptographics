import java.math.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSGS {

	/**
	 * @param args This application accept a text file as an input
	 * The text file contain the value of h in the first line
	 * The value of generator is in the second line, and the value of p in the third line.
	 */
	public static void main(String[] args) {
		// This application accept a text file as an input
		if(args.length != 1){
			System.out.println("Usage: java <text file>");
			System.exit(1);
		}
		BigInteger h = null;
		BigInteger p = null;
		BigInteger generator = null;
		
		try {
			Scanner scan = new Scanner(new File(args[0]));
			h = new BigInteger(scan.nextLine());	//
			generator = new BigInteger(scan.nextLine());
			p = new BigInteger(scan.nextLine());
		
		}
		catch (FileNotFoundException e) {
			System.err.println(e);
		}
		
		if (p == null || generator == null|| h == null){
			System.exit(1);
		}
		
		long tStart = System.currentTimeMillis();

		BabyStep bs = new BabyStep(p, generator);
		bs.generateBabyStep();
		BigInteger alphaNegaM = bs.getMInverse();
		
		BigInteger xb = null;
		BigInteger xg = null;
		BigInteger i = BigInteger.ZERO;
		
		while (i.compareTo(bs.m) < 0){
			for (Entry<BigInteger, BigInteger> entry: bs.xbPair.entrySet()){
				if(alphaNegaM.modPow(i,p).multiply(h).mod(p).equals(entry.getValue())){
					xb =  entry.getKey();
					xg = i;
					break;
				}
			}
			
			if (xb != null){
				break;
			}
			else
				 i = i.add(BigInteger.ONE);
		}
		
		BigInteger x = xg.multiply(bs.m).add(xb);
		System.out.println("private key = " + x);
		long tEnd = System.currentTimeMillis();
		System.out.println("Shank's Baby_Step Giant_Step calculation time = " + (tEnd-tStart) + " milliSeconds");
		
		
		/*calculate e for the 128bits test*/
		BigInteger prime= new BigInteger("37607");
		BigInteger base = new BigInteger("31819");
		BigInteger e = new BigInteger("53");
		System.out.println("test = " + base.modPow(e, prime));
		
		
	}

}


