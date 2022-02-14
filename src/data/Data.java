package data;

import java.util.ArrayList;
import java.util.List;

import bean.Boundary;
import bean.Electron;
import bean.Plate;

/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��14�� ����8:34:32
 */
public class Data {
	
	private Boundary _boundary;
	private List<Electron> _elections = new ArrayList<Electron>();
	private List<Plate> _plates = new ArrayList<Plate>();
	
	public Data() {
		
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
	 * @param _boundary ʾ�����߽�
	 * @param _elections ���ӵ�List
	 * @param _plates �����List
	 */
	public Data(Boundary _boundary, List<Electron> _elections, List<Plate> _plates) {
		super();
		this._boundary = _boundary;
		this._elections = _elections;
		this._plates = _plates;
	}
}
