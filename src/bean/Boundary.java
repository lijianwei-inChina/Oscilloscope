package bean;
/**
 * <p> 描述示波器的边界。包括正视图的长宽和纵深。 </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午7:53:35
 */
public class Boundary {
	private Double width; // 正视图的宽（或者说，x轴方向）
	private Double height; // 正视图的高（或者说，y轴方向）
	private Double deepth; // 纵深（或者说，z轴方向）
	/**
	 * 正视图的宽（或者说，x轴方向）
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * 正视图的宽（或者说，x轴方向）
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * 正视图的高（或者说，y轴方向）
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * 正视图的高（或者说，y轴方向）
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * 纵深（或者说，z轴方向）
	 * @return the deepth
	 */
	public Double getDeepth() {
		return deepth;
	}
	/**
	 * 纵深（或者说，z轴方向）
	 * @param deepth the deepth to set
	 */
	public void setDeepth(Double deepth) {
		this.deepth = deepth;
	}
}
