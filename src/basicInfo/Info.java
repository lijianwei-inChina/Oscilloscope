package basicInfo;
/**
 * <p> ���������Ϣ </p>
 * @author ���ε
 * @version ����ʱ��: 2022��1��22�� ����7:58:09
 */
public class Info {
	/**
	 * @return the authors of this application
	 */
	public static String[] getAuthors() {
		return Authors;
	}
	/**
	 * @return the version of this application
	 */
	public static String getVersion() {
		return Version;
	}
	private final static String[] Authors = {"���ε", "������"}; 
	private final static String Version = "1.0";
}
