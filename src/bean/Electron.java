package bean;

/**
 * <p> ����һ�����ӵ���Ϣ������λ�ã��ٶȣ��������Ĭ��Ԫ��ɣ��ȡ� </p>
 * <p> �ṩ���µ���������Ϣ��method�����Ǹ�һ����t�������Сʱ��֮�����Ϣ�� </p>
 * @author ���ε
 * @version ����ʱ��: 2022��1��22�� ����7:51:54
 */
public class Electron {

	private EPosition position; // ����ά����ϵ�õ��ӵ�λ��
	private ESpeed SpeedPerSecond = new ESpeed(0.0, 0.0 ,0.0); // ���ӵ��ٶ�(m/s)
	public final static Double QuantityOfElectricity = -1.602176634E-19; // ���ӵ����(C)��������
	public final static Double MassOfElectricity = 9.10938215E-31; // ��������(kg)
	
	public Electron() {
		
	}
	/**
	 * @param position ��������λ��
	 * @param speedPerSecond �����ٶ�
	 */
	public Electron(EPosition position, ESpeed speedPerSecond) {
		super();
		this.position = position;
		SpeedPerSecond = speedPerSecond;
	}
	/**
	 * @return the position
	 */
	public EPosition getPosition() {
		return position;
	}
	/**
	 * @param x ����x
	 * @param y ����y
	 * @param z ����z
	 */
	public void setPosition(Double x, Double y, Double z) {
		this.position.set(x,y,z);
	}
	/**
	 * @return the speedPerSecond
	 */
	public ESpeed getSpeedPerSecond() {
		return SpeedPerSecond;
	}
	/**
	 * @param speedPerSecond the speedPerSecond to set
	 */
	public void setSpeedPerSecond(ESpeed speedPerSecond) {
		SpeedPerSecond = speedPerSecond;
	}
	
	/**
	 * ��������λ�ø����Լ���״̬
	 * @param deltaT ˢ�µļ�Сʱ��{@code deltaT}
	 * @param f ��ǰ����λ�õ���������
	 */
	public void UpdateMyself(Double deltaT, Force f) {
		Acceleration a = new Acceleration(f.NumMultiply(1d / MassOfElectricity)); // ������ٶ�a=F/m=f*(1/m)
		ESpeed v0 = this.SpeedPerSecond; // ��ȡ���ٶ�v0
		this.SpeedPerSecond.NoReturnAdd(a.NumMultiply(deltaT)); // ���µ��ӵ�ĩ�ٶȦ�v=a*��t
		this.position.NoReturnAdd(v0.Add(this.SpeedPerSecond).NumMultiply(deltaT / 2d)); // ���µ��ӵ�λ�æ�x=(v0+v)/2*��t
	}
}
