package bean;
/**
 * <p>�ٶ�ʸ��</p>
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����1:59:12
 */
public class ESpeed extends Phasor {
	/**
	 * ����֪�ٶȽ��г�ʼ��
	 * @param v ��֪���ٶ�
	 */
	public ESpeed(Phasor v) {
		super(v);
	}
	/**
	 * ����һ���ٶ�=0m/s
	 */
	public ESpeed() {
		super();
	}
	/**
	 * ����άʸ����ʾһ���ٶ�
	 * @param x
	 * @param y
	 * @param z
	 */
	public ESpeed(double x, double y, double z) {
		super(x, y, z);
	}
}
