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
	public static String getAuthors() {
		StringBuilder au_sb = new StringBuilder();
		au_sb.append('[');
		for(String name : Authors) {
			au_sb.append(name);
			au_sb.append(',');
		}
		au_sb.deleteCharAt(au_sb.length() - 1);
		au_sb.append(']');
		return au_sb.toString();
	}
	/**
	 * @return the version of this application
	 */
	public static String getVersion() {
		return Version;
	}
	private final static String[] Authors = {"李坚蔚"}; 
	private final static String Version = "1.0";
}
