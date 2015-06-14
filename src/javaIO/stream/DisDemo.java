package javaIO.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String fileName = "demo\\dataoutstram.dat";
		//´òÓ¡³öÀ´
		IOUtil.printHex(fileName);
		DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
		int i = dis.readInt();
		System.out.println(i);
		i = dis.readInt();
		System.out.println(i);
		long l = dis.readLong();
		System.out.println(l);
		double d = dis.readDouble();
		System.out.println(d);
		String s = dis.readUTF();
		System.out.println(s);
//		s = dis.readChar();
		dis.close();
	}

}
