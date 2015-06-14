package javaIO.randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		File demo = new File("demo");
		if(!demo.exists())
			demo.mkdir();
		File file = new File(demo,"raf.dat");
		if(!file.exists())
			file.createNewFile();
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//ָ���λ��
		System.out.println(raf.getFilePointer());
		
		raf.write('A');//ÿ��ֻд��һ���ֽ�
		System.out.println(raf.getFilePointer());
		raf.write('B');
		int i = 0x7ffffff;
		raf.write(i >>> 24);
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		
		System.out.println(raf.getFilePointer());
		
		//ֱ��дһ�����ε�
		raf.writeInt(i);
		System.out.println(raf.getFilePointer());
		
		//��ȡ�ļ�ʱ����ָ���ƶ�����ʼλ��
		raf.seek(0);
		
	}

}
