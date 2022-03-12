package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packs.LanguagePack;

import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;

/**
 * @author 李坚蔚
 * @version 创建时间: 2022年3月11日 下午6:27:00
 */
public class ControlWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620167820597223817L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlWindow frame = new ControlWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControlWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 148, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel ControlPanel = new JPanel();
		contentPane.add(ControlPanel, BorderLayout.CENTER);
		ControlPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		ControlPanel.add(verticalGlue_3);
		
		JButton btnHelp = new JButton(LanguagePack.GetTranslation("ControlWindow.Help"));
		btnHelp.setToolTipText("Help you to know the basic usages of this program.");
		btnHelp.setFont(new Font("宋体", Font.PLAIN, 20));
		ControlPanel.add(btnHelp);
		
		Component verticalGlue = Box.createVerticalGlue();
		ControlPanel.add(verticalGlue);
		
		JButton btnStart = new JButton(LanguagePack.GetTranslation("ControlWindow.Start"));
		btnStart.setToolTipText("Start Graph Collecting.");
		btnStart.setFont(new Font("宋体", Font.PLAIN, 20));
		ControlPanel.add(btnStart);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		ControlPanel.add(verticalGlue_1);
		
		JButton btnEnd = new JButton(LanguagePack.GetTranslation("ControlWindow.Stop"));
		btnEnd.setToolTipText("Stop Graph Collecting.");
		btnEnd.setFont(new Font("宋体", Font.PLAIN, 20));
		ControlPanel.add(btnEnd);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		ControlPanel.add(verticalGlue_2);
		
		JButton btnAbout = new JButton(LanguagePack.GetTranslation("ControlWindow.Exit"));
		btnAbout.setToolTipText("Quit this program.");
		btnAbout.setFont(new Font("宋体", Font.PLAIN, 20));
		ControlPanel.add(btnAbout);
		
		Component verticalGlue_4 = Box.createVerticalGlue();
		ControlPanel.add(verticalGlue_4);
	}

}
