package javaIO.stream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String fileName = "demo\\dataoutstram.dat";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(fileName)));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		//采用UTF-8编码写出
		dos.writeUTF("中国");
		//采用utf-16be的编码写出
		dos.writeChars("中国");
		dos.close();
		IOUtil.printHex(fileName);
	}

}
