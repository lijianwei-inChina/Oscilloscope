package operation;

import debug.Debug;
import window.LaunchWindow;

/**
 * @author ���ε
 * @version ����ʱ��: 2022��2��19�� ����3:28:58
 */
public class Start {
	public static Operation operation = new Operation();
	public static void main(String[] args) {
		new LaunchWindow().setVisible(true);
		Debug.PRINT_DEBUG("Oscilloscope Started.");
	}
}
