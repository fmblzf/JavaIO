package javaIO.stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("demo\\RandomAccessFile.dat");
		FileWriter fw = new FileWriter("demo\\FileWriter.dat");
		//表示追加内容
//		FileWriter fw = new FileWriter("demo\\demo\\FileWriter.dat"，true);
		char[] buffer = new char[2016];
		int c;
		while((c = fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer, 0, c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
