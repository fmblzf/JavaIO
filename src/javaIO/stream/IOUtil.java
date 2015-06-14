package javaIO.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * ���ֽ������
	 * ��ȡָ���ļ����ݣ�����16�������������̨
	 * ����û���10���ֽڣ�byte���ͻ���
	 * @param fileName
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = fis.read())!=-1){
			if(b <= 0xf){
				//��λ����ǰ�油0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " " );
			if(i++%10 == 0)
				System.out.println();
		}
		fis.close();
	}
	
	/**
	 * ������ȡ����
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buf = new byte[20*1024];
		int bytes ;
		int i = 1;
		while((bytes = fis.read(buf,0,buf.length))!=-1){
			for (int j = 0;j<bytes;j++) {
				byte b = buf[j];
				if(b <= 0xf){
					//��λ����ǰ�油0
//					System.out.print("0");
				}
				System.out.print(Integer.toHexString(b & 0xff) + " " );
				if(i++%10 == 0)
					System.out.println();
			}
		}
		fis.close();
	}
	/**
	 * FileOutStream���ֽڻ����ֽ�����д��
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeBytes(String fileName) throws IOException{
		FileOutputStream out = new FileOutputStream(fileName);
		out.write('A');//ֻ��д����A���ĵͰ�λ
		out.write('B');//ֻ��д����B���ĵͰ�λ
		int a = 10;//writeֻ��д��λ����ôЩһ��int��Ҫ4�Σ�ÿ��8λ
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a >>> 0);
		//�����Ͱ�һ������д����
		//��ȻҲ����д����,ͨ���ֽ�����ķ�ʽֱ��д��
		byte[] gbk = "�й�".getBytes();
		out.write(gbk);
		out.close();
	}
	/**
	 * �����ֽڸ����ļ�
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void cofyFile(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists())
			throw new IllegalArgumentException("�ļ���"+srcFile +"������");
		if(!srcFile.isFile())
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		//��ʾ������֮ǰ���ļ���׷������
//		FileOutputStream fos = new FileOutputStream(destFile,true);
		byte[] inByte = new byte[8*1024];
		int b;
		while((b = fis.read(inByte, 0, inByte.length))!=-1){
			fos.write(inByte);
			fos.flush();
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * ���帴���ļ�
	 * ���ֽڸ���
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffered(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists())
			throw new IllegalArgumentException("�ļ���"+srcFile +"������");
		if(!srcFile.isFile())
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c ;
		//bis.read()�������ֽڣ�����������ֽ�
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//���Ļ�����������д�����ļ�
		}
		bis.close();
		bos.close();
		
	}
	
}
