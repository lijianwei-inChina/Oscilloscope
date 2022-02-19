package bean;

/**
 * <p> {@code Plate} �ĵ��ʵ�ԭ���ǡ�ʩ�ӵ糡�ļ��塱 </p>
 * <p> ������ȡ�糡��Positionλ�ô�������Method </p>
 * @author ���ε
 * @version ����ʱ��: 2022��1��22�� ����7:54:11
 */
public class Plate {
	
	private Double posZ; // ���漫�����ڵ�λ�ã��ӵ��ӷ��䴦��ʼΪ����ԭ�㣬�ص���·��Ϊ������
	private Integer mode; // ��־�����Ǻ���Ļ��������
	private Double voltage; // ��鼫��ĵ�ѹ���涨�ұߣ������棩Ϊ������
	private Double length; // ����ĳ���
	/**
	 * ����
	 */
	public final static Integer MODE_WIDTHWAYS = 0x0; // ����
	/**
	 * ����
	 */
	public final static Integer MODE_LENGTHWAYS = 0x1; // ����
	
	/**
	 * Ĭ��constructor������ģ�
	 */
	public Plate() {
		// Ĭ���������
		this(MODE_LENGTHWAYS);
	}
	
	/**
	 * �趨mode��constructor
	 * @param _mode {@code MODE_WIDTHWAYS} Ϊ����{@code MODE_LENGTHWAYS} Ϊ����
	 */
	public Plate(Integer _mode) {
		this(_mode, 0d, 0d, 0d);
	}

	/**
	 * �趨mode��voltage��length��constructor
	 * @param _mode {@code MODE_WIDTHWAYS} Ϊ����{@code MODE_LENGTHWAYS} Ϊ����
	 * @param _voltage ��ѹ���涨�ұߣ������棩Ϊ������
	 * @param _length ���峤�ȣ�ֻ��Ϊ�����������������˵Ķ˵�
	 * @param _pos �����ͷ����ʼλ�ã��ӵ��ӷ��䴦��ʼΪ����ԭ�㣬�ص���·��Ϊ������
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
	 * ��ȡ����������
	 * @param _e ����
	 * @param _distance ����֮��ľ���
	 * @return һ��������ʾ�õ��ӵ�����
	 * @throws Exception ��PlateMode���ô���ʱ�׳�
	 */
	public Force getForce(Electron _e, Double _distance) throws Exception {
		if(_e.getPosition().getZ() > (this.posZ + this.length) || _e.getPosition().getZ() < this.posZ) {
			return new Force(0d, 0d, 0d);
		} else {
			if(this.mode == MODE_WIDTHWAYS) {
				return new Force(this.voltage / _distance * Electron.QuantityOfElectricity, 0d, 0d); // F=Eq=(U/d)*q����x�᷽�򣨺��򣩣������������Ѿ���������
			} else if(this.mode == MODE_LENGTHWAYS) {
				return new Force(0d, this.voltage / _distance * Electron.QuantityOfElectricity, 0d); //// F=Eq=(U/d)/q����y�᷽�����򣩣������������Ѿ���������
			} else {
				throw new Exception("Unexpected PlateMode: " + this.mode);
			}
		}
	}
}
