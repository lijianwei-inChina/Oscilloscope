package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Boundary;
import bean.ESpeed;
import bean.Electron;
import bean.Force;
import bean.Plate;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月14日 下午8:34:32
 */
public class Data {
	
	private Boundary _boundary;
	private List<Electron> _elections;
	private List<Plate> _plates;
	private Double _deltaT;
	private ESpeed _electronInitSpeed;

	public Data() {
		this._boundary = new Boundary();
		this._elections = new ArrayList<Electron>();
		this._plates = new ArrayList<Plate>();
		this._deltaT = 0d;
		this._electronInitSpeed = new ESpeed(0d, 0d, 0d);
	}
	
	/**
	 * @param _boundary 示波器边界
	 * @param _elections 电子的List
	 * @param _plates 极板的List
	 */
	public Data(Boundary _boundary, List<Electron> _elections, List<Plate> _plates) {
		super();
		this._boundary = _boundary;
		this._elections = _elections;
		this._plates = _plates;
	}

	/**
	 * 获取电子e所受合力
	 * @param e 电子
	 * @return 合力Force
	 * @throws Exception 当plate的mode设置错误时抛出
	 */
	public Force getElectronForce(Electron e) throws Exception {
		Iterator<Plate> p = this._plates.iterator();
		Force f = new Force(0d, 0d, 0d);
		Double disX = _boundary.getWidth(), disY = _boundary.getHeight();
		while(p.hasNext()) {
			Plate pl = p.next();
			if(pl.getMode() == Plate.MODE_WIDTHWAYS) {
				f.NoReturnAdd(pl.getForce(e, disX));
			} else if(pl.getMode() == Plate.MODE_LENGTHWAYS) {
				f.NoReturnAdd(pl.getForce(e, disY));
			}
		}
		return null;
	}

	public void deletePlate(Plate p) {
		this._plates.remove(p);
	}
	
	public void addNewPlate(Plate p) {
		this._plates.add(p);
	}

	public void deleteElection(Electron e) {
		this._elections.remove(e);
	}

	public void addNewElection(Electron e) {
		this._elections.add(e);
	}

	/**
	 * @return the _boundary
	 */
	public Boundary get_boundary() {
		return _boundary;
	}

	/**
	 * @param _boundary the _boundary to set
	 */
	public void set_boundary(Boundary _boundary) {
		this._boundary = _boundary;
	}

	/**
	 * @return the _elections
	 */
	public List<Electron> get_elections() {
		return _elections;
	}

	/**
	 * @param _elections the _elections to set
	 */
	public void set_elections(List<Electron> _elections) {
		this._elections = _elections;
	}

	/**
	 * @return the _plates
	 */
	public List<Plate> get_plates() {
		return _plates;
	}

	/**
	 * @param _plates the _plates to set
	 */
	public void set_plates(List<Plate> _plates) {
		this._plates = _plates;
	}

	/**
	 * @return the _deltaT
	 */
	public Double get_deltaT() {
		return _deltaT;
	}

	/**
	 * @param _deltaT the _deltaT to set
	 */
	public void set_deltaT(Double _deltaT) {
		this._deltaT = _deltaT;
	}

	/**
	 * @return the _electronInitSpeed
	 */
	public ESpeed get_electronInitSpeed() {
		return _electronInitSpeed;
	}

	/**
	 * @param _electronInitSpeed the _electronInitSpeed to set
	 */
	public void set_electronInitSpeed(ESpeed _electronInitSpeed) {
		this._electronInitSpeed = _electronInitSpeed;
	}

}
