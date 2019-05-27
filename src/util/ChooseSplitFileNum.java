package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseSplitFileNum {

	//分割数
	public List<Integer> splist = null;

	//希望分割行数
	public String selDivideNum = null;

	//分割対象ファイル総行数
    public long originLineAllCount = 0;

    //希望分割行数リスト合計
    public long sumDivideLineNumList = 0;

    //希望分割ファイル数合計
    public int sumDivideFileCount = 0;

    //希望分割行数リスト
    public ArrayList<Long> divideLineCountList = null;

    //分割行数フラグ
    public boolean flag = true;

	public ChooseSplitFileNum chooseSplitFileNum(BufferedReader br, ChooseSplitFile csfValue) throws IOException {

		  //戻り値
		  ChooseSplitFileNum chooseSplitFileNum = new ChooseSplitFileNum();

		  //選択ファイルの行数取得
		  BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(csfValue.files[csfValue.selFileNum - 1])));

		  //選択ファイル総行数
		  String line;

		  //選択ファイルの全行取得
		  line = bufferedReader.readLine();

		  System.out.println("対象ファイルの行数取得中");

		  //選択ファイル行数カウント
		  while(line != null) {
			  originLineAllCount++;
			  line = bufferedReader.readLine();
		  }

		  System.out.println("対象ファイルの行数取得");

		  bufferedReader.close();


		  //ミスカウント
		  int selSplitNumCountMiss0 = 0;
		  int selSplitNumCountMiss1 = 0;

		  //希望分割行数と希望分割ファイル数の計算
		  while(true) {
			  System.out.println("次に、選択した対象ファイルの希望分割行数を、順次入力してください");
			  System.out.println("入力した回数分の分割ファイルが出力されます");
			  System.out.println("最終的に入力した希望分割行数の合計が、選択対象ファイルの総行数と一致するようにしてください");
			  System.out.println("プログラムを終了する場合は'exit'を入力、入力し終えたら'enter'を入力してください");
			  System.out.println("対象ファイル：" + csfValue.files[csfValue.selFileNum - 1] + " 総行数：" + originLineAllCount);

			  while(true) {

				  //現在の状況出力
				  System.out.println("現在の希望行数合計：" + sumDivideLineNumList + "/" + originLineAllCount + " 現在の希望分割ファイル数：" +  sumDivideFileCount);

				  selDivideNum = br.readLine();

				  //希望分割行数が選択対象ファイルの総行数を超えていた場合各変数をリセットして処理戻る
				  if(divideLineCountList.get(divideLineCountList.size()) > originLineAllCount) {
					  System.out.println("希望分割行数の合計が選択対象ファイルの総行数を超えています");
					  chooseSplitFileNum.splist = null;
					  selDivideNum = null;
					  sumDivideFileCount = 0;
					  sumDivideLineNumList = 0;
					  selSplitNumCountMiss0++;
					  continue;
				  }

				  //ミスが続いた場合強制終了
				  if(selSplitNumCountMiss0 == 3 || selSplitNumCountMiss1 ==3) {
					  System.out.println("プログラムを終了します");
					  System.exit(0);
				  }

			  //希望分割行数が"enter"の場合
			  if(selDivideNum.equals("enter")) {
				  //希望分割行数合計が選択対象ファイル総行数と一致する場合次の処理へ
				  if(sumDivideLineNumList == originLineAllCount) {
					  break;
				  }
				  //希望分割行数合計が選択対象ファイル総行数と一致しない場合一つ前の繰り返し処理へ
				  else {
					  System.out.println("選択対象ファイルの総行数と希望分割行数が一致しません");
					  flag = false;
					  break;
				  }
			  }
			  //希望分割行数が"exit"の場合処理終了
			  else if(selDivideNum.equals("exit")) {
				  System.out.println("プログラムを終了します");
				  System.exit(0);
			  }
			  //希望分割行数が0より小さい場合処理戻る
			  else if(Integer.parseInt(selDivideNum) < 0) {
				  System.out.println("正数を入力してください");
				  continue;
			  }
			  //希望分割行数が選択対象ファイル総行数より大きい場合処理戻る
			  else if(Integer.parseInt(selDivideNum) > originLineAllCount) {
				  System.out.println("選択対象ファイルの総行数より多い値を入力しないでください");
				  continue;
			  }
			  //希望分割行数を希望分割行数合計へ加算
			  else if(Integer.parseInt(selDivideNum) > 0 && Integer.parseInt(selDivideNum) < originLineAllCount) {
				  sumDivideLineNumList = sumDivideLineNumList + (Integer.parseInt(selDivideNum));
				  chooseSplitFileNum.splist.add(Integer.parseInt(selDivideNum));
				  continue;
			  }

			  }
			  if(flag = false) {
				  flag = true;
				  selDivideNum = null;
				  sumDivideFileCount = 0;
				  sumDivideLineNumList = 0;
				  chooseSplitFileNum.splist = null;
				  selSplitNumCountMiss1++;
				  continue;
			  }
			  break;

		  }
		return chooseSplitFileNum;
	}

}
