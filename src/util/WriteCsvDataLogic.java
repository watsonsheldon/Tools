package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import constants.Constants;

public abstract class WriteCsvDataLogic {

	public int execute(String procId, String fileName, int writeNum) throws IOException {

		int result = Constants.NORMAL_RESULT_CODE;

		File file = new File("C:" + Constants.FILE_SEPERATOR + "DB_Data_Csv" +  Constants.FILE_SEPERATOR + procId);

		if(!file.exists()) {
			file.mkdirs();
		}

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath() + Constants.FILE_SEPERATOR + fileName + ".csv")));

		System.out.println("出力開始 " + file.getAbsolutePath() + Constants.FILE_SEPERATOR + fileName + ".csv");

		writeFile(pw, writeNum);

		System.out.println("出力終了");

		return result;

	}

	public abstract void writeFile(PrintWriter pw, int writeNum);

}
