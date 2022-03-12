package operation;

/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��14�� ����8:35:57
 */

import java.util.Iterator;

import bean.Boundary;
import bean.ESpeed;
import bean.Electron;
import bean.Plate;
import data.Data;

public class Operation {
	private long deltaT = 100 * 1000; // 100��
	private Data data;
	private Plate Platex, Platey; // x/y�����ϵ����鼫��

	private class refreshThread extends Thread {
		// ˢ�µ��ӵ��߳�
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
		//TODO ���ü����λ�úͳ���
		data.addNewPlate(Platex);
		data.addNewPlate(Platey);
		data.set_electronInitSpeed(new ESpeed());
	}
	
	/**
	 * ����ˢ�µ��ӵ��߳�
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
	 * ֹͣˢ�µ��ӵ��߳�
	 */
	public void StopThread() {
		if(refreshTh != null) {
			while(refreshTh.isAlive()) {
				refreshTh.StartFlag = false;
			}
		}
	}

	/**
	 * ����ˢ�µ��ӵ�ʱ��
	 * 
	 * @param deltaT ����Ϊ��λ
	 * @throws Exception deltaT̫Сʱ�׳�
	 */
	public void setDeltaT(Double deltaT) throws Exception {
		if (deltaT < 0.001) {
			throw new Exception("deltaT̫С��");
		}
		this.deltaT = (int) (deltaT * 1000);
	}

	/**
	 * ˢ�����е���
	 * 
	 * @throws Exception �������mode����ȷʱ�׳�
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
	 * ����һ������
	 */
	public void addElection() {
		data.addNewElection(new Electron(data.get_boundary().getElectronStartPosition(), data.get_electronInitSpeed()));
	}

	/**
	 * ���ú��򼫰�ĵ�ѹ
	 * 
	 * @param volt ��ѹ
	 */
	public void setPlateX(Double volt) {
		Platex.setVoltage(volt);
	}

	/**
	 * �������򼫰�ĵ�ѹ
	 * 
	 * @param volt ��ѹ
	 */
	public void setPlateY(Double volt) {
		Platey.setVoltage(volt);
	}

}
