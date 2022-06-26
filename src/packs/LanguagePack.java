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

import util.CopyFile;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月6日 下午2:16:03
 */
public class LanguagePack {

	private LanguagePack() {

	}

	private static Map<String, Map<String, String>> languageMaps = new HashMap<String, Map<String, String>>();
	private static String CurrentLanguage = new String();
	private final static String LanguageConfigFile = new String("." + File.separator + "languageSettings" + File.separator + "chosen_language.ini");
	private final static String LanguagePackFolder = new String("." + File.separator + "languageSettings" + File.separator + "languagePacks" + File.separator);
	private final static String originLanguageName = "原生语言(简体中文)";

	/**
	 * 设置程序自带的语言包（内置语言包），并指定默认的语言
	 */
	static {

		/*
		 * 设置内置语言包部分
		 */
		Map<String, String> mp = new HashMap<String, String>();

		// ControlWindow.java Start
		mp.put("ControlWindow.Help", "帮助");
		mp.put("ControlWindow.Start", "开始");
		mp.put("ControlWindow.Stop", "停止");
		mp.put("ControlWindow.Exit", "退出");
		mp.put("ControlWindow.Help.text", "帮助你了解软件的使用方法。");
		mp.put("ControlWindow.Start.text", "开始进行数据的采集和呈递。");
		mp.put("ControlWindow.Stop.text", "停止数据采集和呈递。");
		mp.put("ControlWindow.Exit.text", "退出本软件。");
		// ControlWindow.java End

		languageMaps.put(originLanguageName, mp);

		/*
		 * End
		 */

		ChooseDefaultLanguage(LanguageConfigFile, LanguagePackFolder);

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
	 * 
	 * @param languageName 要设置的语言名称
	 * @throws Exception 如果要设置的语言名称没有找到时抛出
	 */
	public static void SetLanguage(String languageName) throws Exception {
		if (!languageMaps.containsKey(languageName)) {
			throw new Exception("未加载[" + languageName + "]这个语言！");
		}
		CurrentLanguage = languageName;
		RecordCurrentLanguageToFile(languageName, languageMaps.get(languageName), LanguageConfigFile,
				LanguagePackFolder);
	}

	/**
	 * 将选中的语言记录到硬盘，这样下次打开时可以默认使用这个语言 暂时没有编写这个功能
	 * 
	 * @param LanguageName       语言名称
	 * @param LanguageConfigFile 语言设置文件
	 * @param lgp                该语言的map
	 * @param SavePackFolder     语言包保存的目录
	 * @throws IOException                Wini会抛出的异常
	 * @throws InvalidFileFormatException Wini会抛出的异常
	 */
	private static void RecordCurrentLanguageToFile(String LanguageName, Map<String, String> lgp,
			String LanguageConfigFile, String SavePackFolder) throws InvalidFileFormatException, IOException {

		// 配置文件写入部分
		if (new File(LanguageConfigFile).exists()) {
			// 如果已经创建过配置文件，那么直接写入
			Wini w = new Wini(new File(LanguageConfigFile));
			if (w.containsKey("choosedLanguage")) {
				// 判断有没有写入过键值"choosedLanguage"，如果已经有过了
				if (w.get("语言配置", "choosedLanguage").equals(LanguageConfigFile)) {
					// 如果本来就和选择的语言一样了，不作处理
				} else {
					// 否则，把新的语言写入配置
					w.remove("语言配置", "choosedLanguage"); // 先抹除原有的语言配置
					w.put("语言配置", "choosedLanguage", LanguageConfigFile);
					w.store(new File(LanguageConfigFile));
				}
			} else {
				// 没有写入过键值，那么直接写入
				w.put("语言配置", "choosedLanguage", LanguageConfigFile);
				w.store(new File(LanguageConfigFile)); // 保存到文件
			}

		} else {
			// 如果没有创建过文件，先创建再直接写入
			new File(LanguageConfigFile).getParentFile().mkdirs();
			new File(LanguageConfigFile).createNewFile();
			Wini w = new Wini();
			w.add("语言配置", "choosedLanguage", LanguageConfigFile);
			w.store(new File(LanguageConfigFile));
		}

		// 语言包保存部分
		if (!new File(LanguagePackFolder).exists()) {
			new File(LanguagePackFolder).mkdirs();
		}

		// 把map中的内容保存到w中，再写入文件
		Wini w = new Wini();
		w.add("name", "name", LanguageName);
		Map<String, String> m = lgp;
		Iterator<Entry<String, String>> it = m.entrySet().iterator();
		while (it.hasNext()) {
			String key_str = it.next().getKey();
			w.add("translation", key_str, m.get(key_str));
		}
		if (!new File(SavePackFolder + File.separator + LanguageName + ".lgp").exists()) {
			// 如果本语言文件没有创建过，那么创建
			new File(SavePackFolder + File.separator + LanguageName + ".lgp").createNewFile();
		}
		w.store(new File(SavePackFolder + File.separator + LanguageName + ".lgp"));
	}

	/**
	 * 将硬盘中记录的语言载入
	 * 
	 * @param LanguageConfigFile  语言设置文件
	 * @param LanguageSavedFolder 语言包保存的位置
	 */
	private static void ChooseDefaultLanguage(String LanguageConfigFile, String LanguageSavedFolder) {
		String languagename = originLanguageName; // 默认选择的语言
		
		if (new File(LanguageConfigFile).exists()) {
			Wini w = null;
			try {
				w = new Wini(new File(LanguageConfigFile));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "配置文件无法读取。自动载入原生语言。");
			}
			if(w == null) {
				// 配置文件无法读取，不作处理
			}
			else if (w.containsKey("choosedLanguage")) {
				languagename = w.get("语言配置", "choosedLanguage");
			} else {
				// 没有键值，不作处理
			}

		} else {
			// 如果没有创建过文件，不作处理
		}
		
		try {
			if(languagename.equals(originLanguageName)) {
				SetLanguage(originLanguageName);
			} else {
				SetTranslationFromFile(LanguageSavedFolder + File.separator + languagename + ".lgp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "软件损坏。请重新下载。");
		}
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
	public static void SetTranslationFromFile(String file) throws InvalidFileFormatException, IOException {
		Wini w = new Wini(new File(file));
		if (w.get("name").get("name").equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "设置语言包名称时与程序自带语言包名称[" + originLanguageName + "]重复！");
		} else {
			languageMaps.put(w.get("name").get("name"), w.get("translation"));
			SaveChoosedLanguage(w.get("name").get("name"), file, LanguagePackFolder);
		}
	}

	/**
	 * 保存语言文件，以便日后使用
	 * 
	 * @param FileName         保存的文件名
	 * @param LanguageFile     原语言文件
	 * @param LanguageSavePath 语言文件要保存到的目录
	 * @throws IOException 读取失败时抛出
	 */
	private static void SaveChoosedLanguage(String FileName, String LanguageFile, String LanguageSavePath)
			throws IOException {
		CopyFile.copyNio(LanguageFile, LanguageSavePath + File.separator + FileName + ".lgp");
	}

	/**
	 * 用已经存在的{@code Map}新增/替换翻译的Map
	 * 
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
	 * 生成默认翻译数据文件，便于翻译
	 * 
	 * @param f 文件位置
	 * @throws IOException 保存文件时抛出错误
	 */
	public static void OutputDefaultLanguageFile(File f) throws IOException {
		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
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
