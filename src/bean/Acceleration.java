package bean;
/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��15�� ����11:29:46
 */
public class Acceleration extends Phasor {

	/**
	 * ����֪���ٶȽ��г�ʼ��
	 * @param a ��֪�ļ��ٶ�
	 */
	public Acceleration(Phasor a) {
		super(a);
	}
	/**
	 * ����һ�����ٶ�=0m/(s^2)
	 */
	public Acceleration() {
		super();
	}

	/**
	 * ����άʸ����ʾһ�����ٶ�
	 * @param x
	 * @param y
	 * @param z
	 */
	public Acceleration(Double x, Double y, Double z) {
		super(x, y, z);
	}
}
