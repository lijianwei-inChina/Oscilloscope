package test;

import java.io.File;
import java.io.IOException;

import packs.LanguagePack;

/**
 * @author ���ε
 * @version ����ʱ��: 2022��3��11�� ����7:27:02
 */
public class LanguagePack_Test {
	public static void main(String[] args) {
		try {
			LanguagePack.OutputDefaultLanguageFile(new File(".//ԭ�����԰�//ԭ�����԰�(UTF-8.lgp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
