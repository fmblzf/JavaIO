package javaIO.stream;

import java.io.File;
import java.io.IOException;

public class IOUtilTestCopyBuffered {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		IOUtil.copyFileByBuffered(new File("demo\\raf.dat"), new File("demo\\bufferedcpfy.dat"));

	}

}
