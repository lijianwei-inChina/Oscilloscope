package bean;
/**
 * <p>位置矢量，表示在示波器内的坐标原点到该点的位置</p>
 * @author 李坚蔚
 * @version 创建时间: 2022年2月6日 下午1:49:15
 */
public class EPosition extends Phasor {
	/**
	 * 默认构造函数，初始化为(0,0,0)
	 */
	public EPosition() {
		super(0d, 0d ,0d);
	}
	/**
	 * 根据(x,y,z)构造位置矢量
	 * @param x 坐标x
	 * @param y 坐标y
	 * @param z 坐标z
	 */
	public EPosition(Double x, Double y, Double z) {
		super(x, y, z);
	}
	/**
	 * 用已知位置矢量进行初始化
	 * @param p 已知的位置矢量
	 */
	public EPosition(Phasor p) {
		super(p);
	}
}