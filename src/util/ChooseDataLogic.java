package util;

import java.io.IOException;

import constants.CodeConstants;
import constants.Constants;
import logic.Data01;
import logic.Data02;
import logic.Data03;

public class ChooseDataLogic {

	public int execute(int selNum) throws IOException {

		int result = Constants.NORMAL_RESULT_CODE;

		WriteCsvDataLogic writeCsvDataLogic = null;

		switch(selNum){

		case 1:
			writeCsvDataLogic = new Data01();
			result = writeCsvDataLogic.execute(CodeConstants.PROC_ID.get(selNum),
					CodeConstants.FILE_NAME.get(CodeConstants.PROC_ID.get(selNum)),
					CodeConstants.WRITE_NUM.get(CodeConstants.PROC_ID.get(selNum)));

			break;

		case 2:
			writeCsvDataLogic = new Data02();
			result =writeCsvDataLogic.execute(CodeConstants.PROC_ID.get(selNum),
					CodeConstants.FILE_NAME.get(CodeConstants.PROC_ID.get(selNum)),
					CodeConstants.WRITE_NUM.get(CodeConstants.PROC_ID.get(selNum)));

			break;

		case 3:
			writeCsvDataLogic = new Data03();
			result = writeCsvDataLogic.execute(CodeConstants.PROC_ID.get(selNum),
					CodeConstants.FILE_NAME.get(CodeConstants.PROC_ID.get(selNum)),
					CodeConstants.WRITE_NUM.get(CodeConstants.PROC_ID.get(selNum)));

			break;

		default:
			System.out.println("予期せぬエラーが発生しました");
			result = Constants.ERROR_RESULT_CODE;
		}

		return result;

	}

}
