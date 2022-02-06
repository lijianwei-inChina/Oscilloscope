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
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����2:16:03
 */
public class LanguagePack {

	private LanguagePack() {

	}

	private static Map<String, Map<String, String>> languageMaps = new HashMap<String, Map<String, String>>();
	private static String CurrentLanguage = new String();
	private final static String LanguageConfigFile = new String(".//languageSettings//chosen_language.ini");
	private final static String originLanguageName = "ԭ������(��������)";

	/**
	 * ���ó����Դ������԰����������԰�������ָ��Ĭ�ϵ�����
	 */
	static {

		/*
		 * �����������԰�����
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
	 * ��ȡ�Ѿ��������԰�����������
	 * 
	 * @return ���԰�֧�ֵ��������͵�List���飬����{"����","English"}
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
	 * �������ԣ�����������Ҫ�Ѽ��أ�
	 * @param languageName Ҫ���õ���������
	 * @throws Exception ���Ҫ���õ���������û���ҵ�ʱ�׳�
	 */
	public static void SetLanguage(String languageName) throws Exception {
		if (!languageMaps.containsKey(languageName)) {
			throw new Exception("δ����[" + languageName + "]������ԣ�");
		}
		CurrentLanguage = languageName;
		RecordCurrentLanguageToFile(LanguageConfigFile);
	}

	/**
	 * ��ѡ�е����Լ�¼��Ӳ�̣������´δ�ʱ����Ĭ��ʹ��������� ��ʱû�б�д�������
	 * @param LanguageConfigFile ���������ļ�
	 */
	private static void RecordCurrentLanguageToFile(String LanguageConfigFile) {
		// TODO Ҫ֧�� ����Ĭ��ѡ�����԰��Զ�����ȹ���
		// ���ʱ�䲻�������Բ���д
	}
	/**
	 * ��Ӳ���м�¼����������
	 * @param LanguageConfigFile ���������ļ�
	 */
	private static void ChooseDefaultLanguage(String LanguageConfigFile) {
		// TODO Ҫ֧�� ����Ĭ��ѡ�����԰��Զ�����ȹ���
		// ���ʱ�䲻�������Բ���д
		try {
			SetLanguage(originLanguageName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "����𻵡����������ء�");
		}
	}
	/**
	 * ���������û�������
	 * @param LanguageConfigFile ���������ļ�
	 */
	private static void LoadSavedLanguages(String LanguageConfigFile) {
		//TODO
	}
	/**
	 * �����û�����������ļ�
	 * @param LanguageConfigFile ���������ļ�
	 */
	private static void SaveChoosedLanguage(String LanguageConfigFile, File languageFile) {
		//TODO
	}
	
	/**
	 * ����ԭ�ķ��ض�Ӧ�ķ���
	 * 
	 * @param x Ҫ�����ԭ��
	 * @return ����CurrentLanguage�ҵ��Ķ�Ӧ�����ġ����û���ҵ���Ĭ��ʹ��ԭ���԰��ķ��롣
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
	 * ���ļ��ж�ȡ����
	 * 
	 * @param file Ҫ��ȡ���ļ�����
	 * @throws InvalidFileFormatException �������ļ��ĸ�ʽ������Ҫ��ʱ�׳�
	 * @throws IOException                �ļ���дʧ��ʱ�׳�
	 */
	public static void SetTranslationFromFile(File file) throws InvalidFileFormatException, IOException {
		Wini w = new Wini(file);
		if (w.get("name").get("name").equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "�������԰�����ʱ������Դ����԰�����[" + originLanguageName + "]�ظ���");
		} else {
			languageMaps.put(w.get("name").get("name"), w.get("translation"));
			SaveChoosedLanguage(w.get("name").get("name"), file);
		}
	}

	/**
	 * ���Ѿ����ڵ�{@code Map}����/�滻�����Map
	 * @param languageName Ҫ����/�滻�������������
	 * @param m            Ҫ����/�滻�����Map
	 */
	public static void SetTranslation(String languageName, Map<String, String> m) {
		if (languageName.equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "�������԰�����ʱ������Դ����԰�����[" + originLanguageName + "]�ظ���");
		} else {
			languageMaps.put(languageName, m);
		}
	}
	
	/**
	 * ����Ĭ�Ϸ����ļ������ڷ���
	 * @param f �ļ�λ��
	 * @throws IOException �����ļ�ʱ�׳�����
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
