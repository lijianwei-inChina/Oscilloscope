package bean;
/**
 * <p> ����һ�����ӵ���Ϣ������λ�ã��ٶȣ��������Ĭ��Ԫ��ɣ��ȡ� </p>
 * <p> �ṩ���µ���������Ϣ��method�����Ǹ�һ����t�������Сʱ��֮�����Ϣ�� </p>
 * @author ���ε
 * @version ����ʱ��: 2022��1��22�� ����7:51:54
 */
public class Electron {
	/**
	 * @return the position
	 */
	public EPosition getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
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
	 * @return the quantityOfElectricity
	 */
	public Double getQuantityOfElectricity() {
		return QuantityOfElectricity;
	}
	private EPosition position; // ����ά����ϵ�õ��ӵ�λ��
	private ESpeed SpeedPerSecond = new ESpeed(0.0, 0.0 ,0.0); // ���ӵ��ٶ�(m/s)
	private final Double QuantityOfElectricity = -1.602176634E-19; // ���ӵ������������
	
	/**
	 * ��������λ�ø����Լ���״̬
	 * @param deltaT ˢ�µļ�Сʱ��deltaT
	 */
	public void UpdateMyself(Double deltaT) {
		//TODO
	}
}
