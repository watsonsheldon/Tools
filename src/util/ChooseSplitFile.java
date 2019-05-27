package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ChooseSplitFile {

	//分割対象ファイル
	public File srcfile;

	//分割対象ファイルリスト
	public File[] files = null;

	//希望分割対象ファイルNo
	public int selFileNum = 0;

	//ミスカウント
	public int selFileCountMiss = 0;

	public ChooseSplitFile chooseSplitFile(BufferedReader br) throws NumberFormatException, IOException {

		  //戻り値
		  ChooseSplitFile chooseSplitFile = new ChooseSplitFile();

		  //分割対象ファイル選択
		  while(true) {

		  System.out.println("分割対象ファイルのNo入力");

		  //分割対象ファイルのフォルダ
		  File file = new File("C:\\DB_Data_Csv");

		  //File[]に分割対象ファイルのフォルダにあるファイルを入れる
		  files = file.listFiles();

		  //分割対象ファイル画面出力
		  for(int i = 0; i < files.length; i++) {
			  System.out.println("No" + (i + 1) + ": " + files[i]);
		  }

		  System.out.println("No99: プログラム終了");

		  //No入力
		  chooseSplitFile.selFileNum = Integer.parseInt(br.readLine());

		  //入力チェック
		  if(selFileCountMiss == 3) {
			  System.out.println("プログラムを終了します");
			  System.exit(0);
		  }
		  else if(0 < chooseSplitFile.selFileNum && chooseSplitFile.selFileNum < files.length + 1) {
			  srcfile = files[selFileNum];
			  break;
		  }
		  else if(chooseSplitFile.selFileNum < 0 || chooseSplitFile.selFileNum > files.length + 1) {
			  System.out.println("範囲内のNoを入力してください（No1～No" + (files.length + 1) + "）");
			  continue;
		  }
		  else if(chooseSplitFile.selFileNum == 99) {
			  System.out.println("プログラムを終了します");
			  System.exit(0);
		  }
		  else {
			  System.out.println("正しく入力してください（No1～No" + (files.length + 1) + "）");
			  selFileCountMiss++;
		  }

		  }

		return chooseSplitFile;
	}

}
