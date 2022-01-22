package basicInfo;
/**
 * <p> 最基本的信息 </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:58:09
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
	private final static String[] Authors = {"李坚蔚", "徐振羽"}; 
	private final static String Version = "1.0";
}
