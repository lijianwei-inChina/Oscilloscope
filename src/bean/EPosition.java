package bean;
/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��6�� ����1:49:15
 */
public class EPosition {
	public EPosition() {
		this.set(0.0, 0.0, 0.0);
	}
	public EPosition(Double x, Double y, Double z) {
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
	public void set(Double x, Double y, Double z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
}