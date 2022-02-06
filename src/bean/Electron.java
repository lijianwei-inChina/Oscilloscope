package bean;
/**
 * <p> 描述一个电子的信息，包括位置，速度，电荷量（默认元电荷）等。 </p>
 * <p> 提供更新电子自身信息的method（就是给一个δt算出它极小时间之后的信息） </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:51:54
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
	private EPosition position; // 用三维坐标系该电子的位置
	private ESpeed SpeedPerSecond = new ESpeed(0.0, 0.0 ,0.0); // 电子的速度(m/s)
	private final Double QuantityOfElectricity = -1.602176634E-19; // 电子电荷量（常量）
	
	/**
	 * 根据所处位置更新自己的状态
	 * @param deltaT 刷新的极小时间deltaT
	 */
	public void UpdateMyself(Double deltaT) {
		//TODO
	}
}
