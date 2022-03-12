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
	private long deltaT = 100 * 1000; // 100秒
	private Data data;
	private Plate Platex, Platey; // x/y方向上的两块极板

	private class refreshThread extends Thread {
		// 刷新电子的线程
		public Boolean StartFlag = true;
		private long lasttime = System.currentTimeMillis();

		@Override
		public void run() {
			while (StartFlag) {
				if (System.currentTimeMillis() - lasttime > deltaT) {
					lasttime = System.currentTimeMillis();
					try {
						refreshElections();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		@Override
		public synchronized void start() {
			this.StartFlag = true;
			super.start();
		}
	}
	private refreshThread refreshTh;

	public Operation() {
		this.data = new Data();
		data.set_boundary(new Boundary(600d, 500d, 1200d));
		Platex.setMode(Plate.MODE_WIDTHWAYS);
		Platey.setMode(Plate.MODE_LENGTHWAYS);
		//TODO 设置极板的位置和长度
		data.addNewPlate(Platex);
		data.addNewPlate(Platey);
		data.set_electronInitSpeed(new ESpeed());
	}
	
	/**
	 * 启动刷新电子的线程
	 */
	public void StartThread() {
		if(refreshTh != null) {
			while(refreshTh.isAlive()) {
				refreshTh.StartFlag = false;
			}
			refreshTh.start();
		}
	}

	/**
	 * 停止刷新电子的线程
	 */
	public void StopThread() {
		if(refreshTh != null) {
			while(refreshTh.isAlive()) {
				refreshTh.StartFlag = false;
			}
		}
	}

	/**
	 * 设置刷新电子的时间
	 * 
	 * @param deltaT 以秒为单位
	 * @throws Exception deltaT太小时抛出
	 */
	public void setDeltaT(Double deltaT) throws Exception {
		if (deltaT < 0.001) {
			throw new Exception("deltaT太小！");
		}
		this.deltaT = (int) (deltaT * 1000);
	}

	/**
	 * 刷新所有电子
	 * 
	 * @throws Exception 当极板的mode不正确时抛出
	 */
	public void refreshElections() throws Exception {
		Iterator<Electron> it = data.get_elections().iterator();
		while (it.hasNext()) {
			Electron e = it.next();
			e.UpdateMyself(this.deltaT / 1000.0, data.getElectronForce(e));
			if (data.get_boundary().isOutOfBoundary(e.getPosition())) {
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

	/**
	 * 设置横向极板的电压
	 * 
	 * @param volt 电压
	 */
	public void setPlateX(Double volt) {
		Platex.setVoltage(volt);
	}

	/**
	 * 设置纵向极板的电压
	 * 
	 * @param volt 电压
	 */
	public void setPlateY(Double volt) {
		Platey.setVoltage(volt);
	}

}
