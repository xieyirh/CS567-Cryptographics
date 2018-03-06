import java.io.File;
import java.security.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Alice {
	public static void main(String[] args){
		Scanner env = null;
		try{
			env = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
