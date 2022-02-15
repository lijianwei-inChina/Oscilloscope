package debug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
//import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

public abstract class DebugFrame extends JFrame {
	private static final long serialVersionUID = 5156783575605868944L;

	private JTextPane textPane = new JTextPane();//定义文字域
	private JScrollPane jscrollPane;//定义滚动条
//	private JTextField CommandLine = new JTextField();//命令行
//	private JButton CommandComfirm = new JButton();//命令提交按钮
	
	private int BadTime = 0;//程序崩溃（在类内部）次数，大于MaxBadTime退出本窗口，报错
	private static int MaxBadTime = 3;
	
	public static final String STYLE_RED = "red";
	public static final String STYLE_BLUE = "blue";
	public static final String STYLE_BLACK = "black";
	public static final String STYLE_YELLOW = "yellow";
	public static final String STYLE_ORANGE = "orange";
	public static final String STYLE_GREEN = "green";
	public static final String STYLE_WHITE = "white";
	
	public void Debug_setDefaltStyle() {
		Style def = textPane.getStyledDocument().addStyle(null, null);//设置文字域的样式
		StyleConstants.setFontFamily(def, "verdana");//设置def字体
		StyleConstants.setFontSize(def, 12);//def字体大小
		
		//addStyle返回的对象覆盖父对象的样式，此处def类似于父类
		//normal为例子，实际开发可以不需要
		Style normal = textPane.addStyle("normal", def);//类似于继承，设定名字为“normal”
		StyleConstants.setForeground(normal, Color.black);//设置"normal"样式的字体颜色
		
		Style red_style = textPane.addStyle(STYLE_RED, def);//同上，名字为“red”
		StyleConstants.setForeground(red_style, Color.RED);//设置"red"样式的字体颜色
		
		Style blue_style = textPane.addStyle(STYLE_BLUE, def);//同上
		StyleConstants.setForeground(blue_style, Color.BLUE);
		
		Style yellow_style = textPane.addStyle(STYLE_YELLOW, def);//同上
		StyleConstants.setForeground(yellow_style, Color.YELLOW);
		
		Style black_style = textPane.addStyle(STYLE_BLACK, def);//同上
		StyleConstants.setForeground(black_style, Color.BLACK);
		
		Style orange_style = textPane.addStyle(STYLE_ORANGE, def);//同上
		StyleConstants.setForeground(orange_style, Color.ORANGE);
		
		Style green_style = textPane.addStyle(STYLE_GREEN, def);//同上
		StyleConstants.setForeground(green_style, Color.GREEN);
		
		Style white_style = textPane.addStyle(STYLE_WHITE, def);//同上
		StyleConstants.setForeground(white_style, Color.WHITE);
		
		/*
		 * 设置段落属性。
		 * 参数：
		 * offset - 开始更改处，该值 >= 0 (本例没有)
		 * length - 更改的长度，该值 >= 0 (本例没有)
		 * s - 要更改为的非 null 属性。任何定义的属性都将适用于此给定范围的文本。
		 * replace - 表示在设置新属性时是否清除以前的属性。如果为 true，此操作将完全替换以前的属性。
		 * 			  如果为 false，新属性将与以前的属性合并。
		 */
		textPane.setParagraphAttributes(normal, true);
	}

	public DebugFrame() {
		this.setTitle("调试窗口");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭的方式，是窗体消失，而不是直接退出
		this.setSize(600, 400);//设置窗体的大小
		this.setLocationRelativeTo(null);//窗体居中
		this.setMinimumSize(new Dimension(450, 300));//最小大小
		
		jscrollPane = new JScrollPane(textPane);
		jscrollPane.doLayout();//显示在最右边
		jscrollPane.setBounds(0, 0, 600, 360);
		this.add(jscrollPane, BorderLayout.CENTER);//添加滚动条
		
//		/**/
//		CommandLine.setFont(new Font("宋体", 25, Font.PLAIN));
//		CommandLine.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//			}
//			@Override
//			public void keyReleased(KeyEvent e) {
//			}
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//					MessageFunction(CommandLine.getText());
//					Debug_AddWords("[User]:" + CommandLine.getText(), STYLE_WHITE);
//					CommandLine.setText("");
//				}
//			}
//		});
//		CommandComfirm.setText("Enter");
//		CommandComfirm.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MessageFunction(CommandLine.getText());
//				Debug_AddWords("[User]:" + CommandLine.getText(), STYLE_WHITE);
//				CommandLine.setText("");
//			}
//		});
//		/**/
		
		Debug_setDefaltStyle();
		
		textPane.setEditable(false);//设置不可编辑
		textPane.setBackground(Color.DARK_GRAY);//设置背景，美观
		
	}
	
	/**
	 * @param str 增加的字符串
	 * @param StyleName 样式名字，可选常量：{@code STYLE_RED,STYLE_BLUE,STYLE_BLACK,STYLE_YELLOW,STYLE_ORANGE,STYLE_GREEN}
	 */
	public void Debug_AddWords(String str, String StyleName) {
		try {
			//getDocument:textPane中的文本的对象
			//insertString:插入字符串，offset:文字插入点, str插入的String, AttributeSet a样式，根据名字找
			textPane.getDocument().insertString(textPane.getDocument().getLength(), str,
					textPane.getStyle(StyleName));
			
			Thread.sleep(10);
			jscrollPane.getVerticalScrollBar().setValue(jscrollPane.getVerticalScrollBar().getMaximum());
//			jscrollPane.getVerticalScrollBar().setValue(???)//设置滚动条的位置，使它滚动至最下面;
			
			BadTime = 0;//成功执行，bad time 清零
			
		} catch (Exception e) {
			BadTime ++ ;//bad time 自增
			
			if(BadTime > MaxBadTime) {
				JOptionPane.showMessageDialog(this, "调试面板崩溃！", "Error", JOptionPane.ERROR_MESSAGE);
				System.err.println("调试面板崩溃！Badtime = " + BadTime);
				System.exit(-1);
			}
			else {
				Debug.PRINT_DEBUG("DebugFrame.AddWords has something wrong!", Debug.DEBUG_ERROR);
			}
		}
	}

//	public abstract void MessageFunction(String msg);
}