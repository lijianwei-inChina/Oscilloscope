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
}
