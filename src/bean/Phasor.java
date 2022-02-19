package bean;

/**
 * <p>
 * ��ά�����Ļ���
 * </p>
 * 
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����1:58:15
 */
public class Phasor {
	public Phasor() {
		super();
		this.set(0.0, 0.0, 0.0);
	}
	

	public Phasor(Phasor p) {
		super();
		this.set(p.getX(), p.getY(), p.getZ());
	}

	public Phasor(Double x, Double y, Double z) {
		super();
		this.set(x, y, z);
	}

	private Double x = 0.0;
	private Double y = 0.0;
	private Double z = 0.0;

	/**
	 * @return the x
	 */
	public Double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public Double getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(Double z) {
		this.z = z;
	}

	/**
	 * ����ά�����Ա�ʾʸ��
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void set(Double x, Double y, Double z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}

	/**
	 * ʸ����������������
	 * 
	 * <pre>
	 * public Phasor NumMultiply(Double num) {
	 * 	return new Phasor(x * num, y * num, z * num);
	 * }
	 * </pre>
	 * 
	 * @param num ����ȥ������
	 * @return ������
	 */
	public Phasor NumMultiply(Double num) {
		return new Phasor(x * num, y * num, z * num);
	}

	/**
	 * ʸ�������������������
	 * 
	 * <pre>
	 * public Double DotMultiply(Phasor p) {
	 * 	return (this.x * p.getX() + this.y * p.getY() + this.z * p.getZ());
	 * }
	 * </pre>
	 * 
	 * @param p ����ȥ������
	 * @return ��˵Ľ��
	 */
	public Double DotMultiply(Phasor p) {
		return (this.x * p.getX() + this.y * p.getY() + this.z * p.getZ());
	}
	
	/**
	 * ʸ���ļӷ�
	 * <pre>
	 * public Phasor Add(Phasor p) {
	 * 	return new Phasor(this.x + p.getX(), this.y + p.getY(), this.z + p.getZ());
	 * }
	 * </pre>
	 * @param p Ҫ�ӵ�����
	 * @return ����ĺ�
	 */
	public Phasor Add(Phasor p) {
		return new Phasor(this.x + p.getX(), this.y + p.getY(), this.z + p.getZ());
	}
	
	/**
	 * ʸ���ļӷ�������ֵΪ�Լ��������Լ���Ϊ��ͽ��
	 * <pre>
	 * public Phasor NoReturnAdd(Phasor p) {
	 * 	this.x += p.getX();
	 * 	this.y += p.getY();
	 * 	this.z += p.getZ();
	 * 	return this;
	 * }
	 * </pre>
	 * @param p Ҫ�ӵ�ʸ��
	 * @return �Լ�
	 */
	public Phasor NoReturnAdd(Phasor p) {
		this.x += p.getX();
		this.y += p.getY();
		this.z += p.getZ();
		return this;
	}
	
	//TODO �����������㷨��
}
