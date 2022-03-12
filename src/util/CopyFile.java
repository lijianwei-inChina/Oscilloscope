package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年3月11日 下午8:27:44
 */
public class CopyFile {
	/**
	 * copy文件，使用FileChannel
	 * @param from 从哪来的文件
	 * @param to 到哪去的文件
	 * @throws IOException 可能抛出的异常
	 */
	public static void copyNio(String from, String to) throws IOException {
		FileInputStream input = new FileInputStream(new File(from));
		FileOutputStream output = new FileOutputStream(new File(to));
		output.getChannel().transferFrom(input.getChannel(), 0, input.getChannel().size());
		input.close();
		output.close();
	}
}
