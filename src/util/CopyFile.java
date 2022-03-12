package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ���ε
 * @version ����ʱ��: 2022��3��11�� ����8:27:44
 */
public class CopyFile {
	/**
	 * copy�ļ���ʹ��FileChannel
	 * @param from ���������ļ�
	 * @param to ����ȥ���ļ�
	 * @throws IOException �����׳����쳣
	 */
	public static void copyNio(String from, String to) throws IOException {
		FileInputStream input = new FileInputStream(new File(from));
		FileOutputStream output = new FileOutputStream(new File(to));
		output.getChannel().transferFrom(input.getChannel(), 0, input.getChannel().size());
		input.close();
		output.close();
	}
}
