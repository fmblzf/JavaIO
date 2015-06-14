package javaIO.stream;

import java.io.IOException;

public class IOUtilWriteBytes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtil.writeBytes("demo\\raf.dat");
			IOUtil.printHexByByteArray("demo\\raf.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
