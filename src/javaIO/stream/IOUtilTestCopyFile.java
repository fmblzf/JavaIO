package javaIO.stream;

import java.io.File;
import java.io.IOException;

public class IOUtilTestCopyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IOUtil.cofyFile(new File("demo\\raf.dat"), new File("demo\\raf1.dat"));
	}

}
