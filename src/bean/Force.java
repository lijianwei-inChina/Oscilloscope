package bean;
/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��14�� ����9:03:15
 */
public class Force extends Phasor {

	/**
	 * ����֪�����г�ʼ��
	 * @param f ��֪����
	 */
	public Force(Phasor f) {
		super(f);
	}
	/**
	 * ����һ����=0N
	 */
	public Force() {
		super();
	}

	/**
	 * ����άʸ����ʾһ����
	 * @param x ��ʸ����x����
	 * @param y ��ʸ����y����
	 * @param z ��ʸ����z����
	 */
	public Force(Double x, Double y, Double z) {
		super(x, y, z);
	}
	
}
