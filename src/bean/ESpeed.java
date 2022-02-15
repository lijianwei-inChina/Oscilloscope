package bean;
/**
 * <p>速度矢量</p>
 * @author 李坚蔚
 * @version 创建时间: 2022年2月6日 下午1:59:12
 */
public class ESpeed extends Phasor {
	/**
	 * 用已知速度进行初始化
	 * @param v 已知的速度
	 */
	public ESpeed(Phasor v) {
		super(v);
	}
	/**
	 * 创建一个速度=0m/s
	 */
	public ESpeed() {
		super();
	}
	/**
	 * 用三维矢量表示一个速度
	 * @param x
	 * @param y
	 * @param z
	 */
	public ESpeed(double x, double y, double z) {
		super(x, y, z);
	}
}
