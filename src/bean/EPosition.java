package bean;
/**
 * <p>λ��ʸ������ʾ��ʾ�����ڵ�����ԭ�㵽�õ��λ��</p>
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����1:49:15
 */
public class EPosition extends Phasor {
	/**
	 * Ĭ�Ϲ��캯������ʼ��Ϊ(0,0,0)
	 */
	public EPosition() {
		super(0d, 0d ,0d);
	}
	/**
	 * ����(x,y,z)����λ��ʸ��
	 * @param x ����x
	 * @param y ����y
	 * @param z ����z
	 */
	public EPosition(Double x, Double y, Double z) {
		super(x, y, z);
	}
	/**
	 * ����֪λ��ʸ�����г�ʼ��
	 * @param p ��֪��λ��ʸ��
	 */
	public EPosition(Phasor p) {
		super(p);
	}
}