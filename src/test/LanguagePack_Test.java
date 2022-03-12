package test;

import java.io.File;
import java.io.IOException;

import packs.LanguagePack;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年3月11日 下午7:27:02
 */
public class LanguagePack_Test {
	public static void main(String[] args) {
		try {
			LanguagePack.OutputDefaultLanguageFile(new File(".//原生语言包//原生语言包(UTF-8.lgp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
