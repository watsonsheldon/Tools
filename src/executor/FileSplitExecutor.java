package executor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import constants.CodeConstants;
import constants.Constants;
import util.ChooseSplitFile;
import util.ChooseSplitFileNum;

//ファイルを行数で分割するクラス
public class FileSplitExecutor {

   //分割対象ファイル
   private static File srcfile;

   //分割数
   private static List<Integer> splist;

   private static String select;

   private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   File splines = new File("C:" + Constants.FILE_SEPERATOR + "DB_Data_Csv" +  Constants.FILE_SEPERATOR +CodeConstants.PROC_ID.get(1));

   public static void main(String args[]) throws IOException {

	   ChooseSplitFile csf = new ChooseSplitFile();
	   ChooseSplitFile csfValue = csf.chooseSplitFile(br);
	   srcfile = csfValue.srcfile;

	   ChooseSplitFileNum csfn = new ChooseSplitFileNum();
	   ChooseSplitFileNum csfnValue = csfn.chooseSplitFileNum(br, csfValue);
	   splist = csfnValue.splist;



	  int selDecideCountMiss = 0;

	  while(true) {
	  System.out.println("それでは選択ファイルを分割しますか？（ y / n ）");
	  System.out.println(csfValue.files[csfValue.selFileNum - 1]);
	  select = br.readLine();

	  if(selDecideCountMiss == 3) {
		  System.out.println("プログラムを終了します");
		  System.exit(0);
	  }
	  else if(select.equals("y")) {
		  break;
	  }
	  else if(select.equals("n")) {
          System.out.println("プログラムを終了します");
          System.exit(0);
	  }
	  else {
		  System.out.println("正しく入力してください（ y / n ）");
		  selDecideCountMiss++;
		  continue;
	  }
	  }


      //FileSplitExecutor sp = new FileSplitExecutor(srcfile, splines);
      FileSplitExecutor.split();
   }

   public static void split() throws IOException {
      int sequence = 0;
      try {
         FileInputStream fis = new FileInputStream(srcfile);
         InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
         BufferedReader br = new BufferedReader(isr);

         for (int i : splist) {
            PrintWriter pw = new PrintWriter(Integer.toString(sequence) + ".txt", "UTF-8");
            BufferedWriter bw = new BufferedWriter(pw);

            int count = 0;
            String line;
            while (count < i && null != (line = br.readLine())) {
               bw.write(line);
               bw.newLine();
               count++;
            }
            bw.close();
            sequence++;
         }
         br.close();
      } catch (FileNotFoundException e) {
         throw e;
      } catch (IOException e) {
         throw e;
      }
   }
}