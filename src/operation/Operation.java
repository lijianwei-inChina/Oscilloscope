package operation;
/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月14日 下午8:35:57
 */

import java.util.Iterator;

import bean.Boundary;
import bean.ESpeed;
import bean.Electron;
import bean.Plate;
import data.Data;

public class Operation {
	private Data data;

	public Operation() {
		this.data = new Data();
	}

	public void setInitialVelocity(ESpeed sp) {
		data.set_electronInitSpeed(sp);
	}
	
	/**
	 * 设置刷新电子的时间
	 * @param deltaT
	 */
	public void setDeltaT(Double deltaT) {
		data.set_deltaT(deltaT);
	}

	/**
	 * 设置示波器的边界
	 * @param width 宽（x轴方向）
	 * @param height 高（y轴方向）
	 * @param deepth 纵深（z轴方向）
	 */
	public void setBoundary(Double width, Double height, Double deepth) {
		data.set_boundary(new Boundary(width, height, deepth));
	}

	/**
	 * 添加一块极板
	 * @param p
	 */
	public void addNewPlate(Plate p) {
		this.data.addNewPlate(p);
	}

	/**
	 * 删除一块极板
	 * @param p
	 */
	public void deletePlate(Plate p) {
		data.deletePlate(p);
	}

	/**
	 * 刷新所有电子
	 * @throws Exception 当极板的mode不正确时抛出
	 */
	public void refreshElections() throws Exception {
		Iterator<Electron> it = data.get_elections().iterator();
		while(it.hasNext()) {
			Electron e = it.next();
			e.UpdateMyself(data.get_deltaT(), data.getElectronForce(e));
			if(data.get_boundary().isOutOfBoundary(e.getPosition())) {
				data.deleteElection(e);
			}
		}
	}

	/**
	 * 发射一个电子
	 */
	public void addElection() {
		data.addNewElection(new Electron(data.get_boundary().getElectronStartPosition(), data.get_electronInitSpeed()));
	}

	//TODO 添加更多的逻辑
}
