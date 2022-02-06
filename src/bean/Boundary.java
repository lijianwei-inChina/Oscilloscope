package bean;
/**
 * <p> 描述示波器的边界。包括正视图的长宽和纵深。 </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:53:35
 */
public class Boundary {
	private Double width; // 正视图的宽
	private Double height; // 正视图的高
	private Double deepth; // 纵深
	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * @return the deepth
	 */
	public Double getDeepth() {
		return deepth;
	}
	/**
	 * @param deepth the deepth to set
	 */
	public void setDeepth(Double deepth) {
		this.deepth = deepth;
	}
}
