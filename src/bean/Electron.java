package bean;

/**
 * <p> 描述一个电子的信息，包括位置，速度，电荷量（默认元电荷）等。 </p>
 * <p> 提供更新电子自身信息的method（就是给一个δt算出它极小时间之后的信息） </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:51:54
 */
public class Electron {

	private EPosition position; // 用三维坐标系该电子的位置
	private ESpeed SpeedPerSecond = new ESpeed(0.0, 0.0 ,0.0); // 电子的速度(m/s)
	public final static Double QuantityOfElectricity = -1.602176634E-19; // 电子电荷量(C)（常量）
	public final static Double MassOfElectricity = 9.10938215E-31; // 电子质量(kg)
	
	public Electron() {
		
	}
	/**
	 * @param position 电子所处位置
	 * @param speedPerSecond 电子速度
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
	 * @param x 坐标x
	 * @param y 坐标y
	 * @param z 坐标z
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
	 * 根据所处位置更新自己的状态
	 * @param deltaT 刷新的极小时间{@code deltaT}
	 * @param f 当前所处位置电子所受力
	 */
	public void UpdateMyself(Double deltaT, Force f) {
		Acceleration a = new Acceleration(f.NumMultiply(1d / MassOfElectricity)); // 计算加速度a=F/m=f*(1/m)
		ESpeed v0 = this.SpeedPerSecond; // 获取初速度v0
		this.SpeedPerSecond.NoReturnAdd(a.NumMultiply(deltaT)); // 更新电子的末速度δv=a*δt
		this.position.NoReturnAdd(v0.Add(this.SpeedPerSecond).NumMultiply(deltaT / 2d)); // 更新电子的位置δx=(v0+v)/2*δt
	}
}
