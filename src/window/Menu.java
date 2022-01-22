package window;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * <p> 打开软件时显示的菜单界面。 </p>
 * @author 李坚蔚
 * @version 创建时间: 2022年1月22日 下午8:03:48
 */
public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
