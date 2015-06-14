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
		//���ļ����ж�д����
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo\\FileWriter.dat")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("demo\\BufferedWriter.dat")));
		String line;
		while((line = br.readLine())!=null){
			System.out.println(line);//һ�ζ�һ�У�������ʶ���з�
			bw.write(line);
			bw.flush();
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
