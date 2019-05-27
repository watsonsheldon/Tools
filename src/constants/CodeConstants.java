package constants;

import java.util.TreeMap;

public class CodeConstants {

	public static TreeMap<Integer, String> PROC_ID = new TreeMap<Integer, String>();

	static {
		PROC_ID.put(1, "Data01");
		PROC_ID.put(2, "Data02");
		PROC_ID.put(3, "Data03");
		PROC_ID.put(99, "exit");
	}

	public static TreeMap<String, String> FILE_NAME = new TreeMap<String, String>();

	static {
		FILE_NAME.put(PROC_ID.get(1), "Data001");
		FILE_NAME.put(PROC_ID.get(2), "Data002");
		FILE_NAME.put(PROC_ID.get(3), "Data003");
	}

	public static TreeMap<String, Integer> WRITE_NUM = new TreeMap<String, Integer>();

		static {
			WRITE_NUM.put(PROC_ID.get(1), 5);
			WRITE_NUM.put(PROC_ID.get(2), 5);
			WRITE_NUM.put(PROC_ID.get(3), 5);
		}

}
