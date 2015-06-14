package javaIO.stream;

import java.io.IOException;

public class IOUtilTestPrintHexByByteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis(); 
			IOUtil.printHexByByteArray("D:\\javaio\\a.mp3");
			long end = System.currentTimeMillis();
			System.out.print("批量字节读取耗时："+(end-start));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
