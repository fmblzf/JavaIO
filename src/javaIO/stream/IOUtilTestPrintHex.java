package javaIO.stream;

import java.io.IOException;

public class IOUtilTestPrintHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis(); 
			IOUtil.printHex("D:\\javaio\\a.mp3");
			long end = System.currentTimeMillis();
			System.out.print("���ֽڶ�ȡ��ʱ��"+(end-start));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
