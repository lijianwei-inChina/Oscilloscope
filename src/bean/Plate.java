package bean;

/**
 * <p> {@code Plate} 的单词的原义是“施加电场的极板” </p>
 * <p> 包含获取电场中Position位置处的力的Method </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:54:11
 */
public class Plate {
	
	private Double posZ; // 储存极板所在的位置（从电子发射处开始为坐标原点，沿电子路径为正方向）
	private Integer mode; // 标志极板是横向的还是纵向的
	private Double voltage; // 这块极板的电压，规定右边（或上面）为正方向
	private Double length; // 极板的长度
	/**
	 * 横向
	 */
	public final static Integer MODE_WIDTHWAYS = 0x0; // 横向
	/**
	 * 纵向
	 */
	public final static Integer MODE_LENGTHWAYS = 0x1; // 纵向
	
	/**
	 * 默认constructor（纵向的）
	 */
	public Plate() {
		// 默认是纵向的
		this(MODE_LENGTHWAYS);
	}
	
	/**
	 * 设定mode的constructor
	 * @param _mode {@code MODE_WIDTHWAYS} 为横向，{@code MODE_LENGTHWAYS} 为纵向
	 */
	public Plate(Integer _mode) {
		this(_mode, 0d, 0d, 0d);
	}

	/**
	 * 设定mode和voltage和length的constructor
	 * @param _mode {@code MODE_WIDTHWAYS} 为横向，{@code MODE_LENGTHWAYS} 为纵向
	 * @param _voltage 电压，规定右边（或上面）为正方向
	 * @param _length 极板长度（只能为正），包括极板两端的端点
	 * @param _pos 极板的头部起始位置（从电子发射处开始为坐标原点，沿电子路径为正方向）
	 */
	public Plate(Integer _mode, Double _voltage, Double _length, Double _pos) {
		this.mode = _mode;
		this.voltage = _voltage;
		this.length = _length;
	}

	/**
	 * @return the pos
	 */
	public Double getPos() {
		return posZ;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(Double pos) {
		this.posZ = pos;
	}

	/**
	 * @return the mode
	 */
	public Integer getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(Integer mode) {
		this.mode = mode;
	}

	/**
	 * @return the voltage
	 */
	public Double getVoltage() {
		return voltage;
	}

	/**
	 * @param voltage the voltage to set
	 */
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}

	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}
	
	/**
	 * 获取电子所受力
	 * @param _e 电子
	 * @param _distance 极板之间的距离
	 * @return 一个力，表示该电子的受力
	 * @throws Exception 当PlateMode设置错误时抛出
	 */
	public Force getForce(Electron _e, Double _distance) throws Exception {
		if(_e.getPosition().getZ() > (this.posZ + this.length) || _e.getPosition().getZ() < this.posZ) {
			return new Force(0d, 0d, 0d);
		} else {
			if(this.mode == MODE_WIDTHWAYS) {
				return new Force(this.voltage / _distance * Electron.QuantityOfElectricity, 0d, 0d); // F=Eq=(U/d)*q，在x轴方向（横向），并且正负号已经定下来了
			} else if(this.mode == MODE_LENGTHWAYS) {
				return new Force(0d, this.voltage / _distance * Electron.QuantityOfElectricity, 0d); //// F=Eq=(U/d)/q，在y轴方向（纵向），并且正负号已经定下来了
			} else {
				throw new Exception("Unexpected PlateMode: " + this.mode);
			}
		}
	}
}
