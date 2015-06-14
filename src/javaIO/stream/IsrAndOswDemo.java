package javaIO.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\javaIO\\randomaccessfile\\RandomAccessFile.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("demo\\RandomAccessFile.dat"));
		//单字节读取
//		int c;
//		while((c = isr.read())!=-1){
//			System.out.print((char)c);
//		}
		//批量读取
		char[] buffer = new char[8*1024];
		int c ;
		while((c = isr.read(buffer, 0, buffer.length))!=-1){
			String s = new String(buffer,0,c);
			System.out.print(s);
			osw.write(buffer,0,c);
			osw.flush();
		}
		isr.close();
		osw.close();
		
	}

}
