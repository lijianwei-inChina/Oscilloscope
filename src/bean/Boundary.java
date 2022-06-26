package bean;
/**
 * <p> ����ʾ�����ı߽硣��������ͼ�ĳ������� </p>
 * @author ���ε
 * @version ����ʱ��: 2022��1��22�� ����7:53:35
 */
public class Boundary {
	private Double width; // ����ͼ�Ŀ�����˵��x�᷽��
	private Double height; // ����ͼ�ĸߣ�����˵��y�᷽��
	private Double deepth; // �������˵��z�᷽��
	
	public Boundary() {
		this(0d, 0d, 0d);
	}
	/**
	 * @param width ����ͼ�Ŀ�����˵��x�᷽��
	 * @param height ����ͼ�ĸߣ�����˵��y�᷽��
	 * @param deepth �������˵��z�᷽��
	 */
	public Boundary(Double width, Double height, Double deepth) {
		super();
		this.deepth = deepth;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * ����ͼ�Ŀ�����˵��x�᷽��
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * ����ͼ�Ŀ�����˵��x�᷽��
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * ����ͼ�ĸߣ�����˵��y�᷽��
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * ����ͼ�ĸߣ�����˵��y�᷽��
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * �������˵��z�᷽��
	 * @return the deepth
	 */
	public Double getDeepth() {
		return deepth;
	}
	/**
	 * �������˵��z�᷽��
	 * @param deepth the deepth to set
	 */
	public void setDeepth(Double deepth) {
		this.deepth = deepth;
	}
	/**
	 * �жϵ����Ƿ���ʾ�����ռ�֮��
	 * @param p ���ӵ�λ��(EPosition)
	 * @return Boolean, true��Ϊ��ʾ����֮��, false��ʾ����֮��
	 */
	public Boolean isOutOfBoundary(EPosition p) {
		if(p.getX() < 0 || p.getY() < 0 || p.getZ() < 0 || p.getX() >= this.width || p.getY() >= this.height || p.getZ() >= this.deepth) {
			return true;
		}
		return false;
	}
	
	public EPosition getElectronStartPosition() {
		return new EPosition(this.width / 2, this.height / 2, this.deepth);
	}
}
