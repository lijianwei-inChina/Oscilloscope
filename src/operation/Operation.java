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
	private Data data;

	public Operation() {
		this.data = new Data();
	}

	public void setInitialVelocity(ESpeed sp) {
		data.set_electronInitSpeed(sp);
	}
	
	/**
	 * ����ˢ�µ��ӵ�ʱ��
	 * @param deltaT
	 */
	public void setDeltaT(Double deltaT) {
		data.set_deltaT(deltaT);
	}

	/**
	 * ����ʾ�����ı߽�
	 * @param width ��x�᷽��
	 * @param height �ߣ�y�᷽��
	 * @param deepth ���z�᷽��
	 */
	public void setBoundary(Double width, Double height, Double deepth) {
		data.set_boundary(new Boundary(width, height, deepth));
	}

	/**
	 * ���һ�鼫��
	 * @param p
	 */
	public void addNewPlate(Plate p) {
		this.data.addNewPlate(p);
	}

	/**
	 * ɾ��һ�鼫��
	 * @param p
	 */
	public void deletePlate(Plate p) {
		data.deletePlate(p);
	}

	/**
	 * ˢ�����е���
	 * @throws Exception �������mode����ȷʱ�׳�
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
	 * ����һ������
	 */
	public void addElection() {
		data.addNewElection(new Electron(data.get_boundary().getElectronStartPosition(), data.get_electronInitSpeed()));
	}

	//TODO ��Ӹ�����߼�
}
