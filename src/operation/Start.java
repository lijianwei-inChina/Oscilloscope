package operation;

import debug.Debug;
import window.LaunchWindow;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年2月19日 下午3:28:58
 */
public class Start {
	public static Operation operation = new Operation();
	public static void main(String[] args) {
		new LaunchWindow().setVisible(true);
		Debug.PRINT_DEBUG("Oscilloscope Started.");
	}
}
