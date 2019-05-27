package executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;

import constants.CodeConstants;
import constants.Constants;
import util.ChooseDataLogic;

public class LogicExecutor {

	public static void main(String args[]) {

		int result = LogicExecutor.execute();

		if(result == Constants.NORMAL_RESULT_CODE) {
			System.out.println("正常終了");
		}
			else {
				System.out.println("異常終了");
			}
		}

	public static int execute() {

		int result = Constants.NORMAL_RESULT_CODE;

		System.out.println("DBデータ一覧");

		for(Entry<Integer, String> entry : CodeConstants.PROC_ID.entrySet()) {

			System.out.println("No:" + entry.getKey() + " " + entry.getValue());

		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String selNum;

		while(true) {

		System.out.println("出力対象データのNo入力(終了の場合'99')");

			try {

				 selNum = br.readLine();

			if(Integer.valueOf(selNum) > CodeConstants.PROC_ID.size() - 1 || Integer.valueOf(selNum) < 0) {

				System.out.println("範囲内の数値を入力してください");

				continue;
			}

			else if(Integer.valueOf(selNum) == Constants.EXIT_SEL_NUM) {

				System.out.println("終了します");

				br.close();

				return Constants.NORMAL_RESULT_CODE;
			}

			else {

				br.close();
			}

			} catch (IOException e) {

					System.out.println("予期せぬエラーが発生しました");

					return Constants.ERROR_RESULT_CODE;
			}

			ChooseDataLogic chooseDataLogic = new ChooseDataLogic();

			try {

				result = chooseDataLogic.execute(Integer.valueOf(selNum));

			} catch (NumberFormatException | IOException e) {

				System.out.println("ファイル書き込み中にエラーが発生しました");

				return Constants.ERROR_RESULT_CODE;
			}

			return result;

		}

	}

}
