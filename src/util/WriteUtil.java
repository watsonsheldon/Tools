package util;

import java.io.PrintWriter;

import constants.Constants;

public class WriteUtil {

	public static final void writeColumn(PrintWriter pw, String value) {
		pw.print(Constants.DOUBLE_QUATETION);
		pw.print(value);
		pw.print(Constants.DOUBLE_QUATETION);
		pw.print(Constants.COMMA);
	}

	public static final void writeLastColumn(PrintWriter pw, String value) {
		pw.print(Constants.DOUBLE_QUATETION);
		pw.print(value);
		pw.print(Constants.DOUBLE_QUATETION);
		pw.println();
	}

}
