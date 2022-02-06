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

	private JTextPane textPane = new JTextPane();//����������
	private JScrollPane jscrollPane;//���������
//	private JTextField CommandLine = new JTextField();//������
//	private JButton CommandComfirm = new JButton();//�����ύ��ť
	
	private int BadTime = 0;//��������������ڲ�������������MaxBadTime�˳������ڣ�����
	private static int MaxBadTime = 3;
	
	public static final String STYLE_RED = "red";
	public static final String STYLE_BLUE = "blue";
	public static final String STYLE_BLACK = "black";
	public static final String STYLE_YELLOW = "yellow";
	public static final String STYLE_ORANGE = "orange";
	public static final String STYLE_GREEN = "green";
	public static final String STYLE_WHITE = "white";
	
	public void Debug_setDefaltStyle() {
		Style def = textPane.getStyledDocument().addStyle(null, null);//�������������ʽ
		StyleConstants.setFontFamily(def, "verdana");//����def����
		StyleConstants.setFontSize(def, 12);//def�����С
		
		//addStyle���صĶ��󸲸Ǹ��������ʽ���˴�def�����ڸ���
		//normalΪ���ӣ�ʵ�ʿ������Բ���Ҫ
		Style normal = textPane.addStyle("normal", def);//�����ڼ̳У��趨����Ϊ��normal��
		StyleConstants.setForeground(normal, Color.black);//����"normal"��ʽ��������ɫ
		
		Style red_style = textPane.addStyle(STYLE_RED, def);//ͬ�ϣ�����Ϊ��red��
		StyleConstants.setForeground(red_style, Color.RED);//����"red"��ʽ��������ɫ
		
		Style blue_style = textPane.addStyle(STYLE_BLUE, def);//ͬ��
		StyleConstants.setForeground(blue_style, Color.BLUE);
		
		Style yellow_style = textPane.addStyle(STYLE_YELLOW, def);//ͬ��
		StyleConstants.setForeground(yellow_style, Color.YELLOW);
		
		Style black_style = textPane.addStyle(STYLE_BLACK, def);//ͬ��
		StyleConstants.setForeground(black_style, Color.BLACK);
		
		Style orange_style = textPane.addStyle(STYLE_ORANGE, def);//ͬ��
		StyleConstants.setForeground(orange_style, Color.ORANGE);
		
		Style green_style = textPane.addStyle(STYLE_GREEN, def);//ͬ��
		StyleConstants.setForeground(green_style, Color.GREEN);
		
		Style white_style = textPane.addStyle(STYLE_WHITE, def);//ͬ��
		StyleConstants.setForeground(white_style, Color.WHITE);
		
		/*
		 * ���ö������ԡ�
		 * ������
		 * offset - ��ʼ���Ĵ�����ֵ >= 0 (����û��)
		 * length - ���ĵĳ��ȣ���ֵ >= 0 (����û��)
		 * s - Ҫ����Ϊ�ķ� null ���ԡ��κζ�������Զ��������ڴ˸�����Χ���ı���
		 * replace - ��ʾ������������ʱ�Ƿ������ǰ�����ԡ����Ϊ true���˲�������ȫ�滻��ǰ�����ԡ�
		 * 			  ���Ϊ false�������Խ�����ǰ�����Ժϲ���
		 */
		textPane.setParagraphAttributes(normal, true);
	}

	public DebugFrame() {
		this.setTitle("���Դ���");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�رյķ�ʽ���Ǵ�����ʧ��������ֱ���˳�
		this.setSize(600, 400);//���ô���Ĵ�С
		this.setLocationRelativeTo(null);//�������
		this.setMinimumSize(new Dimension(450, 300));//��С��С
		
		jscrollPane = new JScrollPane(textPane);
		jscrollPane.doLayout();//��ʾ�����ұ�
		jscrollPane.setBounds(0, 0, 600, 360);
		this.add(jscrollPane, BorderLayout.CENTER);//��ӹ�����
		
//		/**/
//		CommandLine.setFont(new Font("����", 25, Font.PLAIN));
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
		
		textPane.setEditable(false);//���ò��ɱ༭
		textPane.setBackground(Color.DARK_GRAY);//���ñ���������
		
	}
	
	/**
	 * @param str ���ӵ��ַ���
	 * @param StyleName ��ʽ���֣���ѡ������{@code STYLE_RED,STYLE_BLUE,STYLE_BLACK,STYLE_YELLOW,STYLE_ORANGE,STYLE_GREEN}
	 */
	public void Debug_AddWords(String str, String StyleName) {
		try {
			//getDocument:textPane�е��ı��Ķ���
			//insertString:�����ַ�����offset:���ֲ����, str�����String, AttributeSet a��ʽ������������
			textPane.getDocument().insertString(textPane.getDocument().getLength(), str,
					textPane.getStyle(StyleName));
			
			Thread.sleep(10);
			jscrollPane.getVerticalScrollBar().setValue(jscrollPane.getVerticalScrollBar().getMaximum());
//			jscrollPane.getVerticalScrollBar().setValue(???)//���ù�������λ�ã�ʹ��������������;
			
			BadTime = 0;//�ɹ�ִ�У�bad time ����
			
		} catch (Exception e) {
			BadTime ++ ;//bad time ����
			
			if(BadTime > MaxBadTime) {
				JOptionPane.showMessageDialog(this, "������������", "Error", JOptionPane.ERROR_MESSAGE);
				System.err.println("������������Badtime = " + BadTime);
				System.exit(-1);
			}
			else {
				Debug.PRINT_DEBUG("DebugFrame.AddWords has something wrong!", Debug.DEBUG_ERROR);
			}
		}
	}

//	public abstract void MessageFunction(String msg);
}