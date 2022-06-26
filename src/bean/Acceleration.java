package bean;
/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月15日 上午11:29:46
 */
public class Acceleration extends Phasor {

	/**
	 * 用已知加速度进行初始化
	 * @param a 已知的加速度
	 */
	public Acceleration(Phasor a) {
		super(a);
	}
	/**
	 * 创建一个加速度=0m/(s^2)
	 */
	public Acceleration() {
		super();
	}

	/**
	 * 用三维矢量表示一个加速度
	 * @param x 加速度矢量的x方向
	 * @param y 加速度矢量的y方向
	 * @param z 加速度矢量的z方向
	 */
	public Acceleration(Double x, Double y, Double z) {
		super(x, y, z);
	}
}
