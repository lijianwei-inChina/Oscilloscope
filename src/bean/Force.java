package bean;
/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月14日 下午9:03:15
 */
public class Force extends Phasor {

	/**
	 * 创建一个力=0N
	 */
	public Force() {
		super();
	}

	/**
	 * 用三维矢量表示一个力
	 * @param x
	 * @param y
	 * @param z
	 */
	public Force(Double x, Double y, Double z) {
		super(x, y, z);
	}
	
}
