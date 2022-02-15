package debug;

public class Debug {
	private Debug() {}
	
	public static void DebugShow(boolean flag) {
		debug_frame.setVisible(flag);
	}
	public static void setDebugTitle(String tt) {
		debug_frame.setTitle(tt);
	}
	
	public static final int DEBUG_NOTE = 1;
	public static final int DEBUG_WARNING = 2;
	public static final int DEBUG_ERROR = 3;
	
	private static int DEBUG_LEVEL = DEBUG_WARNING;
	
//	/**
//	 * @return DEBUG_LEVEL
//	 */
//	public static int getDEBUG_LEVEL() {
//		return DEBUG_LEVEL;
//	}
	/**
	 * @param dEBUG_LEVEL 要设置的 DEBUG_LEVEL
	 */
	public static void setDEBUG_LEVEL(int dEBUG_LEVEL) {
		DEBUG_LEVEL = dEBUG_LEVEL;
		debug_frame.Debug_AddWords("-----set new Debug Level!-----\n", DebugFrame.STYLE_GREEN);
	}

//	private static List<String> DebugList;
	
	private static DebugFrame debug_frame;
	
	static { 
		debug_frame = new DebugFrame() {
			private static final long serialVersionUID = -5146671089313779849L;

//			@Override
//			public void MessageFunction(String msg) {
//				Debug.MessageFunction(msg);
//			}
		};
		PRINT_DEBUG("DebugMode PowerOn", DEBUG_NOTE);
	}

	/**
	 * @param DebugWords debug信息
	 * 等级默认为DEBUG_NOTE
	 */
	public static void PRINT_DEBUG(String DebugWords) {
		PRINT_DEBUG(DebugWords, DEBUG_NOTE);
	}
	/**
	 * @param DebugWords debug信息
	 * @param DebugLevel debug等级
	 */
	public static void PRINT_DEBUG(String DebugWords, int DebugLevel) {
		String PrefixString = new String("");
		String StyleName = new String("");
		switch(DebugLevel) {
		case DEBUG_NOTE:
			PrefixString = "[note]:";
			StyleName = DebugFrame.STYLE_GREEN;
			break;
		case DEBUG_WARNING:
			PrefixString = "[Warning]:";
			StyleName = DebugFrame.STYLE_ORANGE;
			break;
		case DEBUG_ERROR:
			PrefixString = "[ERROR]:";
			StyleName = DebugFrame.STYLE_RED;
			break;
		default:
			PrefixString = "[UnKnown:]";
			StyleName = DebugFrame.STYLE_BLACK;
			break;
		}
		if(DebugLevel >= DEBUG_LEVEL) {
//			DebugList.add(PrefixString + DebugWords);
			debug_frame.Debug_AddWords(PrefixString + DebugWords + "\n", StyleName);
		}
	}
	
//	public static void MessageFunction(String msg) {
//		
//	}
}
