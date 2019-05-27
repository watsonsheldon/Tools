package logic;

import java.io.PrintWriter;

import util.WriteCsvDataLogic;
import util.WriteUtil;

public class Data03 extends WriteCsvDataLogic {

	@Override
	public void writeFile(PrintWriter pw, int writeNum) {

		for(int i = 0; i < writeNum; i++) {

			WriteUtil.writeColumn(pw, "test03");

			WriteUtil.writeColumn(pw, "test03");

			WriteUtil.writeLastColumn(pw, "test03");

			pw.flush();

		}

	}

}
