package javaIO.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BrAndBwOrPwDemo {

	public static void main(String[] args)throws IOException {
		//对文件进行读写操作
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo\\FileWriter.dat")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("demo\\BufferedWriter.dat")));
		String line;
		while((line = br.readLine())!=null){
			System.out.println(line);//一次读一行，并不能识别换行符
			bw.write(line);
			bw.flush();
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
