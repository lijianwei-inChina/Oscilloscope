package bean;
/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月14日 下午9:03:15
 */
public class Force extends Phasor {

	/**
	 * 用已知力进行初始化
	 * @param f 已知的力
	 */
	public Force(Phasor f) {
		super(f);
	}
	/**
	 * 创建一个力=0N
	 */
	public Force() {
		super();
	}

	/**
	 * 用三维矢量表示一个力
	 * @param x 力矢量的x坐标
	 * @param y 力矢量的y坐标
	 * @param z 力矢量的z坐标
	 */
	public Force(Double x, Double y, Double z) {
		super(x, y, z);
	}
	
}
