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
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����2:16:03
 */
public class LanguagePack {

	private LanguagePack() {

	}

	private static Map<String, Map<String, String>> languageMaps = new HashMap<String, Map<String, String>>();
	private static String CurrentLanguage = new String();
	private final static String LanguageConfigFile = new String("." + File.separator + "languageSettings" + File.separator + "chosen_language.ini");
	private final static String LanguagePackFolder = new String("." + File.separator + "languageSettings" + File.separator + "languagePacks" + File.separator);
	private final static String originLanguageName = "ԭ������(��������)";

	/**
	 * ���ó����Դ������԰����������԰�������ָ��Ĭ�ϵ�����
	 */
	static {

		/*
		 * �����������԰�����
		 */
		Map<String, String> mp = new HashMap<String, String>();

		// ControlWindow.java Start
		mp.put("ControlWindow.Help", "����");
		mp.put("ControlWindow.Start", "��ʼ");
		mp.put("ControlWindow.Stop", "ֹͣ");
		mp.put("ControlWindow.Exit", "�˳�");
		mp.put("ControlWindow.Help.text", "�������˽������ʹ�÷�����");
		mp.put("ControlWindow.Start.text", "��ʼ�������ݵĲɼ��ͳʵݡ�");
		mp.put("ControlWindow.Stop.text", "ֹͣ���ݲɼ��ͳʵݡ�");
		mp.put("ControlWindow.Exit.text", "�˳��������");
		// ControlWindow.java End

		languageMaps.put(originLanguageName, mp);

		/*
		 * End
		 */

		ChooseDefaultLanguage(LanguageConfigFile, LanguagePackFolder);

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
	 * 
	 * @param languageName Ҫ���õ���������
	 * @throws Exception ���Ҫ���õ���������û���ҵ�ʱ�׳�
	 */
	public static void SetLanguage(String languageName) throws Exception {
		if (!languageMaps.containsKey(languageName)) {
			throw new Exception("δ����[" + languageName + "]������ԣ�");
		}
		CurrentLanguage = languageName;
		RecordCurrentLanguageToFile(languageName, languageMaps.get(languageName), LanguageConfigFile,
				LanguagePackFolder);
	}

	/**
	 * ��ѡ�е����Լ�¼��Ӳ�̣������´δ�ʱ����Ĭ��ʹ��������� ��ʱû�б�д�������
	 * 
	 * @param LanguageName       ��������
	 * @param LanguageConfigFile ���������ļ�
	 * @param lgp                �����Ե�map
	 * @param SavePackFolder     ���԰������Ŀ¼
	 * @throws IOException                Wini���׳����쳣
	 * @throws InvalidFileFormatException Wini���׳����쳣
	 */
	private static void RecordCurrentLanguageToFile(String LanguageName, Map<String, String> lgp,
			String LanguageConfigFile, String SavePackFolder) throws InvalidFileFormatException, IOException {

		// �����ļ�д�벿��
		if (new File(LanguageConfigFile).exists()) {
			// ����Ѿ������������ļ�����ôֱ��д��
			Wini w = new Wini(new File(LanguageConfigFile));
			if (w.containsKey("choosedLanguage")) {
				// �ж���û��д�����ֵ"choosedLanguage"������Ѿ��й���
				if (w.get("��������", "choosedLanguage").equals(LanguageConfigFile)) {
					// ��������ͺ�ѡ�������һ���ˣ���������
				} else {
					// ���򣬰��µ�����д������
					w.remove("��������", "choosedLanguage"); // ��Ĩ��ԭ�е���������
					w.put("��������", "choosedLanguage", LanguageConfigFile);
					w.store(new File(LanguageConfigFile));
				}
			} else {
				// û��д�����ֵ����ôֱ��д��
				w.put("��������", "choosedLanguage", LanguageConfigFile);
				w.store(new File(LanguageConfigFile)); // ���浽�ļ�
			}

		} else {
			// ���û�д������ļ����ȴ�����ֱ��д��
			new File(LanguageConfigFile).getParentFile().mkdirs();
			new File(LanguageConfigFile).createNewFile();
			Wini w = new Wini();
			w.add("��������", "choosedLanguage", LanguageConfigFile);
			w.store(new File(LanguageConfigFile));
		}

		// ���԰����沿��
		if (!new File(LanguagePackFolder).exists()) {
			new File(LanguagePackFolder).mkdirs();
		}

		// ��map�е����ݱ��浽w�У���д���ļ�
		Wini w = new Wini();
		w.add("name", "name", LanguageName);
		Map<String, String> m = lgp;
		Iterator<Entry<String, String>> it = m.entrySet().iterator();
		while (it.hasNext()) {
			String key_str = it.next().getKey();
			w.add("translation", key_str, m.get(key_str));
		}
		if (!new File(SavePackFolder + File.separator + LanguageName + ".lgp").exists()) {
			// ����������ļ�û�д���������ô����
			new File(SavePackFolder + File.separator + LanguageName + ".lgp").createNewFile();
		}
		w.store(new File(SavePackFolder + File.separator + LanguageName + ".lgp"));
	}

	/**
	 * ��Ӳ���м�¼����������
	 * 
	 * @param LanguageConfigFile  ���������ļ�
	 * @param LanguageSavedFolder ���԰������λ��
	 */
	private static void ChooseDefaultLanguage(String LanguageConfigFile, String LanguageSavedFolder) {
		String languagename = originLanguageName; // Ĭ��ѡ�������
		
		if (new File(LanguageConfigFile).exists()) {
			Wini w = null;
			try {
				w = new Wini(new File(LanguageConfigFile));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "�����ļ��޷���ȡ���Զ�����ԭ�����ԡ�");
			}
			if(w == null) {
				// �����ļ��޷���ȡ����������
			}
			else if (w.containsKey("choosedLanguage")) {
				languagename = w.get("��������", "choosedLanguage");
			} else {
				// û�м�ֵ����������
			}

		} else {
			// ���û�д������ļ�����������
		}
		
		try {
			if(languagename.equals(originLanguageName)) {
				SetLanguage(originLanguageName);
			} else {
				SetTranslationFromFile(LanguageSavedFolder + File.separator + languagename + ".lgp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "����𻵡����������ء�");
		}
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
	public static void SetTranslationFromFile(String file) throws InvalidFileFormatException, IOException {
		Wini w = new Wini(new File(file));
		if (w.get("name").get("name").equals(originLanguageName)) {
			JOptionPane.showMessageDialog(null, "�������԰�����ʱ������Դ����԰�����[" + originLanguageName + "]�ظ���");
		} else {
			languageMaps.put(w.get("name").get("name"), w.get("translation"));
			SaveChoosedLanguage(w.get("name").get("name"), file, LanguagePackFolder);
		}
	}

	/**
	 * ���������ļ����Ա��պ�ʹ��
	 * 
	 * @param FileName         ������ļ���
	 * @param LanguageFile     ԭ�����ļ�
	 * @param LanguageSavePath �����ļ�Ҫ���浽��Ŀ¼
	 * @throws IOException ��ȡʧ��ʱ�׳�
	 */
	private static void SaveChoosedLanguage(String FileName, String LanguageFile, String LanguageSavePath)
			throws IOException {
		CopyFile.copyNio(LanguageFile, LanguageSavePath + File.separator + FileName + ".lgp");
	}

	/**
	 * ���Ѿ����ڵ�{@code Map}����/�滻�����Map
	 * 
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
	 * ����Ĭ�Ϸ��������ļ������ڷ���
	 * 
	 * @param f �ļ�λ��
	 * @throws IOException �����ļ�ʱ�׳�����
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
