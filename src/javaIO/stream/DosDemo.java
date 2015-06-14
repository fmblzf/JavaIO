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
		//����UTF-8����д��
		dos.writeUTF("�й�");
		//����utf-16be�ı���д��
		dos.writeChars("�й�");
		dos.close();
		IOUtil.printHex(fileName);
	}

}
