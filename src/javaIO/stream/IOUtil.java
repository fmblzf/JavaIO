package javaIO.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 单字节输出。
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且没输出10个字节（byte）就换行
	 * @param fileName
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = fis.read())!=-1){
			if(b <= 0xf){
				//单位数的前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " " );
			if(i++%10 == 0)
				System.out.println();
		}
		fis.close();
	}
	
	/**
	 * 批量读取数据
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
					//单位数的前面补0
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
	 * FileOutStream单字节或者字节数组写入
	 * @param fileName
	 * @throws IOException
	 */
	public static void writeBytes(String fileName) throws IOException{
		FileOutputStream out = new FileOutputStream(fileName);
		out.write('A');//只能写出‘A’的低八位
		out.write('B');//只能写出‘B’的低八位
		int a = 10;//write只能写八位，那么些一个int需要4次，每次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a >>> 0);
		//这样就把一个整数写完了
		//当然也可以写汉字,通过字节数组的方式直接写入
		byte[] gbk = "中国".getBytes();
		out.write(gbk);
		out.close();
	}
	/**
	 * 批量字节复制文件
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void cofyFile(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists())
			throw new IllegalArgumentException("文件："+srcFile +"不存在");
		if(!srcFile.isFile())
			throw new IllegalArgumentException(srcFile+"不是文件");
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		//表示可以在之前的文件上追加内容
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
	 * 缓冲复制文件
	 * 单字节复制
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffered(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists())
			throw new IllegalArgumentException("文件："+srcFile +"不存在");
		if(!srcFile.isFile())
			throw new IllegalArgumentException(srcFile+"不是文件");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c ;
		//bis.read()读出单字节，输出读到的字节
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//舒心缓冲区，否则写不到文件
		}
		bis.close();
		bos.close();
		
	}
	
}
