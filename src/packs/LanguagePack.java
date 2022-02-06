package packs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月6日 下午2:16:03
 */
public class LanguagePack {

	private LanguagePack() {

	}

	private static Map<String, Map<String, String>> languageMaps = new HashMap<String, Map<String, String>>();
	private static String CurrentLanguage = new String();
	private final static String LanguageConfigFile = new String(".//languageSettings//chosen_language.ini");
	private final static String originLanguageName = "原生语言(简体中文)";

	/**
	 * 设置程序自带的语言包（内置语言包），并指定默认的语言
	 */
	static {

		/*
		 * 设置内置语言包部分
		 */
		Map<String, String> mp = new HashMap<String, String>();
		
		languageMaps.put(originLanguageName, mp);
		/*
		 * End
		 */

		LoadSavedLanguages(LanguageConfigFile);
		ChooseDefaultLanguage(LanguageConfigFile);

	}

	/**
	 * 获取已经加载语言包的语言名称
	 * 
	 * @return 语言包支持的语言类型的List数组，比如{"中文","English"}
	 */
	public static List<String> GetSupportedLanguage() {
		List<String> languageList = new ArrayList<String>();
		Iterator<Entry<String, Map<String, String>>> it = languageMaps.entrySet().iterator();
		while (it.hasNext()) {
			languageList.add(it.next().getKey());
		}
		return languageList;
	}

	/**
	 * 设置语言（语言名称需要已加载）
	 * @param languageName 要设置的语言名称
	 * @throws Exception 如果要设置的语言名称没有找到时抛出
	 */
	public static void SetLanguage(String languageName) throws Exception {
		if (!languageMaps.containsKey(languageName)) {
			throw new Exception("未加载[" + languageName + "]这个语言！");
		}
		CurrentLanguage = languageName;
		RecordCurrentLanguageToFile(LanguageConfigFile);
	}

	/**
	 * 将选中的语言记录到硬盘，这样下次打开时可以默认使用这个语言 暂时没有编写这个功能
	 * @param LanguageConfigFile 语言设置文件
	 */
	private static void RecordCurrentLanguageToFile(String LanguageConfigFile) {
		// TODO 要支持 语言默认选择，语言包自动导入等功能
		// 如果时间不允许，可以不编写
	}
	/**
	 * 将硬盘中记录的语言载入
	 * @param LanguageConfigFile 语言设置文件
	 */
	private static void ChooseDefaultLanguage(String LanguageConfigFile) {
		// TODO 要支持 语言默认选择，语言包自动导入等功能
		// 如果时间不允许，可以不编写
		try {
			SetLanguage(originLanguageName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "软件损坏。请重新下载。");
		}
	}
	/**
	 * 载入所有用户的语言
	 * @param LanguageConfigFile 语言设置文件
	 */
	private static void LoadSavedLanguages(String LanguageConfigFile) {
		//TODO
	}
	/**
	 * 保存用户载入的语言文件
	 * @param LanguageConfigFile 语言设置文件
	 */
	private static void SaveChoosedLanguage(String LanguageConfigFile, File languageFile) {
		//TODO
	}
	
	/**
	 * 根据原文返回对应的翻译
	 * 
	 * @param x 要翻译的原文
	 * @return 根据CurrentLanguage找到的对应的译文。如果没有找到，默认使用原语言包的翻译。
	 */
	public static String GetTranslation(String x) {
		if (!languageMaps.containsKey(CurrentLanguage)) {
			CurrentLanguage = originLanguageName;
		}
		if (!languageMaps.get(CurrentLanguage).containsKey(x)) {
			return languageMaps.get(originLanguageName).get(x);
		}
		return languageMaps.get(CurrentLanguage).get(x);
	}

	/**
	 * 从文件中读取翻译
	 * 
	 * @param file 要读取的文件对象
	 * @throws InvalidFileFormatException 如果这个文件的格式不符合要求时抛出
	 * @throws IOException                文件读写失败时抛出
	 */
	public static void SetTranslationFromFile(File file) throws InvalidFileFormatException, IOException {
		Wini w = new Wini(file);
		if (w.get("name").get("name").equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "设置语言包名称时与程序自带语言包名称[" + originLanguageName + "]重复！");
		} else {
			languageMaps.put(w.get("name").get("name"), w.get("translation"));
			SaveChoosedLanguage(w.get("name").get("name"), file);
		}
	}

	/**
	 * 用已经存在的{@code Map}新增/替换翻译的Map
	 * @param languageName 要新增/替换翻译的语言名称
	 * @param m            要新增/替换翻译的Map
	 */
	public static void SetTranslation(String languageName, Map<String, String> m) {
		if (languageName.equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "设置语言包名称时与程序自带语言包名称[" + originLanguageName + "]重复！");
		} else {
			languageMaps.put(languageName, m);
		}
	}
	
	/**
	 * 生成默认翻译文件，便于翻译
	 * @param f 文件位置
	 * @throws IOException 保存文件时抛出错误
	 */
	public static void OutputDefaultLanguageFile(File f) throws IOException {
		Wini w = new Wini();
		w.add("name", "name", originLanguageName);
		Map<String, String> m = languageMaps.get(originLanguageName);
		Iterator<Entry<String, String>> it = m.entrySet().iterator();
		while (it.hasNext()) {
			String key_str = it.next().getKey();
			w.add("translation", key_str, m.get(key_str));
		}
		w.store(f);
	}

}
