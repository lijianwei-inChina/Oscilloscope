package bean;

/**
 * <p>
 * 三维向量的基类
 * </p>
 * 
 * @author 李坚蔚
 * @version 创建时间: 2022年2月6日 下午1:58:15
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
	 * 用三维的数对表示矢量
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
	 * 矢量（向量）的数乘
	 * 
	 * <pre>
	 * public Phasor NumMultiply(Double num) {
	 * 	return new Phasor(x * num, y * num, z * num);
	 * }
	 * </pre>
	 * 
	 * @param num 乘上去的数字
	 * @return 运算结果
	 */
	public Phasor NumMultiply(Double num) {
		return new Phasor(x * num, y * num, z * num);
	}

	/**
	 * 矢量（向量）的向量点乘
	 * 
	 * <pre>
	 * public Double DotMultiply(Phasor p) {
	 * 	return (this.x * p.getX() + this.y * p.getY() + this.z * p.getZ());
	 * }
	 * </pre>
	 * 
	 * @param p 乘上去的向量
	 * @return 点乘的结果
	 */
	public Double DotMultiply(Phasor p) {
		return (this.x * p.getX() + this.y * p.getY() + this.z * p.getZ());
	}
	
	/**
	 * 矢量的加法
	 * <pre>
	 * public Phasor Add(Phasor p) {
	 * 	return new Phasor(this.x + p.getX(), this.y + p.getY(), this.z + p.getZ());
	 * }
	 * </pre>
	 * @param p 要加的向量
	 * @return 所求的和
	 */
	public Phasor Add(Phasor p) {
		return new Phasor(this.x + p.getX(), this.y + p.getY(), this.z + p.getZ());
	}
	
	/**
	 * 矢量的加法，返回值为自己，并且自己作为求和结果
	 * <pre>
	 * public Phasor NoReturnAdd(Phasor p) {
	 * 	this.x += p.getX();
	 * 	this.y += p.getY();
	 * 	this.z += p.getZ();
	 * 	return this;
	 * }
	 * </pre>
	 * @param p 要加的矢量
	 * @return 自己
	 */
	public Phasor NoReturnAdd(Phasor p) {
		this.x += p.getX();
		this.y += p.getY();
		this.z += p.getZ();
		return this;
	}
	
	//TODO 补充更多的运算法则
}
