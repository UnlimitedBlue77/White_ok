package study4_LibraryManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class LMS {

	public static void main(String[] args) {

		int MenuNo;
		int DispNo;
		int IndexCnt;
		String SearchName;
		String SearchAuthor;
		int SearchType;
		int SearchMoney1;
		int SearchMoney2;
		String bookName = null;
		String authorName = null;
		String Money = null;
		String TypeNo = null;
		boolean pricelessflg = false;
		boolean nextflg;
		LinkedList<String> BookName = new LinkedList<String>();
		LinkedList<String> Author = new LinkedList<String>();
		LinkedList<Integer> Price = new LinkedList<Integer>();
		LinkedList<Integer> Type = new LinkedList<Integer>();
		Scanner stdIn = new Scanner(System.in);
		
		//システムのタイトルは初回のみ
		System.out.println("=図書館管理システムへようこそ=");
		
		//システム終了以外の場合は、ループ
		do {
			IndexCnt = BookName.size();
			System.out.println("\n■トップ画面です。※登録されている図書は　"+IndexCnt+"　件です。");
			System.out.println("下の操作ができます。番号を指定してくて、Enterキーを押してください。");
			System.out.println(" 1:図書の登録");
			System.out.println(" 2:図書の表示");
			System.out.println(" 3:図書データ削除");
			System.out.println(" 4:システムの終了");
			
			MenuNo = stdIn.nextInt();
			
			switch (MenuNo) {
			case 1://図書登録
				System.out.println("\n■図書を登録します。");
				do {
					nextflg = false;
					bookName = stdIn.nextLine();
					if (bookName == null || bookName.trim().length() == 0 || bookName.endsWith("\r\n")){
						System.out.println("図書名を入力してください　：\n ※図書名は空白では登録できません。");
						nextflg = false;
					}
					else if (bookName.length() > 30){
						System.out.println("\n30文字を超えています。30文字以内で図書名を入力してください。");
						nextflg = false;						
					}
					else {
						char[] chars = bookName.toCharArray();
						for (int i = 0; i < chars.length; i++) {
							char c = chars[i];
							if ((c <= '\u007e') ||	// 英数字
									(c == '\u00a5') ||	// 記号
									(c == '\u203e') ||	// 記号
									(c >= '\uff61' && c <= '\uff9f')	// 半角カナ
							) {
								System.out.println("\n図書名に半角文字が含まれています。全角のみで図書名を入力してください。");
								nextflg = false;
								break;
							} else {
								nextflg = true;
								BookName.add(bookName.toString());
								break;
							}
						}
					}					
				}while(nextflg == false);
				System.out.println("\n図書名　「" + bookName.toString() +"」　を登録しました。");							
				
				System.out.println("\n著者名を入力してください　：\n ※著者名は空白では登録できません。");
				do {
					nextflg = false;
					authorName = stdIn.nextLine();
					if (authorName == null || authorName.trim().length() == 0 || authorName.endsWith("\r\n")){
						System.out.println("著者名を入力してください。※著者名は空白では登録できません。");
						nextflg = false;
					}
					else if (authorName.length() > 30){
						System.out.println("\n30文字を超えています。30文字以内で図書名を入力してください。");
						nextflg = false;						
					}
					else {
						char[] chars = authorName.toCharArray();
						for (int i = 0; i < chars.length; i++) {
							char c = chars[i];
							if ((c <= '\u007e') ||	// 英数字
									(c == '\u00a5') ||	// 記号
									(c == '\u203e') ||	// 記号
									(c >= '\uff61' && c <= '\uff9f')	// 半角カナ
							) {
								System.out.println("\n著者名に半角文字が含まれています。全角のみで著者名を入力してください。");
								nextflg = false;
								break;
							} else {
								nextflg = true;
								Author.add(authorName.toString());
								break;
							}
						}
					}					
				}while(nextflg == false);
				System.out.println("\n著者名　「" + authorName.toString() + "」　を登録しました。");
				
				System.out.println("\n価格を入力してください　：\n ※ 無料で入手した場合は0を入力してください。\n ※ 未入力は0円になります。 ");
				do {
					nextflg = false;
					Money = stdIn.nextLine();
					if (Money == null || Money.trim().length() == 0 || Money.endsWith("\r\n")){
						System.out.println("未入力でエンターキーが押されましたので、0円で登録します。");
						Price.add(0);
						nextflg = true;
					}
					else{
						if (!Money.matches("^[0-9]*$")) {
						System.out.println("\n入力できるのは半角数字だけです。");
						nextflg = false;
						}
						else {
							if (Integer.parseInt(Money.toString()) < 0 || Integer.parseInt(Money.toString()) > 10000) {
								System.out.println("\n価格は0 ～ 10000の範囲内で入力してください。");
								nextflg = false;
							}
							else {
								nextflg = true;
								Price.add(Integer.parseInt(Money.toString()));
							}
						}
					}
				}while(nextflg == false);
				System.out.println("\n価格　「" + Money.toString() + "」　を登録しました。");
				
				System.out.println("\n本のタイプを入力してください　：\n ※本のタイプは空白では登録できません。 ");
				System.out.println("\nタイプは次の4つから番号を入力してください : ");
				System.out.println("　1:コミック\n　2:薄い本\n　3:専門書\n　4:その他");
//				System.out.println("　2:薄い本");
//				System.out.println("　3:専門書");
//				System.out.println("　4:その他");
				do {
					nextflg = false;
					TypeNo = stdIn.nextLine();
					if (TypeNo == null || TypeNo.trim().length() == 0 || TypeNo.endsWith("\r\n")){
						System.out.println("本のタイプを入力してください。※本のタイプは空白では登録できません。");
						nextflg = false;
					}
					else {
						if (Integer.parseInt(TypeNo.toString()) >= 1 && Integer.parseInt(TypeNo.toString()) <= 4) {
							nextflg = true;
							Type.add(Integer.parseInt(TypeNo.toString()));
						}
						else {
							System.out.println("\n本のタイプは1 ～ 4の範囲内で入力してください。\n　1:コミック\n　2:薄い本\n　3:専門書\n　4:その他");
							nextflg = false;
						}
					}
				}while(nextflg == false);
				System.out.println("\n本のタイプ　「" + TypeNo.toString() + "」　を登録しました。");
				
				System.out.println("\n登録が完了しました。Top画面に戻ります。\n");
				break;
			case 2://図書表示
				IndexCnt = BookName.size();
				if (IndexCnt == 0) {
					System.out.println("\n■登録されている図書はありません。Top画面に戻ります。\n");
				}
				else {					
					System.out.println("\n■登録図書を表示します。表示方法を選択してください。\n");
					System.out.println(" 1:全ての図書を表示します。");
					System.out.println(" 2:図書名で検索表示します。");
					System.out.println(" 3:著書名で検索表示します。");
					System.out.println(" 4:価格の範囲を指定して検索表示します。");
					System.out.println(" 5:タイプを指定して検索表示します。");
					DispNo = stdIn.nextInt();
					switch (DispNo) {
					case 1://全ての図書を表示
						for (int cnt = 0; cnt < IndexCnt; cnt++) {
							System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
						}
						System.out.println("\n■一覧表示がが完了しました。Top画面に戻ります。");
						break;
					case 2://図書名で検索表示
						System.out.println("\n■図書名で検索表示します。\n検索文字列は完全一致のみです。");
						SearchName = stdIn.next();
						for (int cnt = 0; cnt < IndexCnt; cnt++) {
							if (SearchName.equals(BookName.get(cnt))) {
								System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
							}
						}
						break;
					case 3://著書名で検索表示
						System.out.println("\n■著者名で検索表示します。\n検索文字列は完全一致のみです。");
						SearchAuthor = stdIn.next();
						for (int cnt = 0; cnt < IndexCnt; cnt++) {
							if (SearchAuthor.equals(Author.get(cnt))) {
								System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
							}
						}						
						break;
					case 4://価格の範囲を指定して検索表示
						System.out.println("\n■価格の範囲を指定して検索表示します。\n範囲を指定してください。");
						System.out.println("最低価格　：　");
						SearchMoney1 = stdIn.nextInt();
						System.out.println("\n最高価格　：　");
						SearchMoney2 = stdIn.nextInt();
						if (SearchMoney1 > SearchMoney2) {
							System.out.println("\n最低価格より、最高価格が小さい値になっています。\n検索処理を終了します。");
						}
						else {
							for (int cnt = 0; cnt < IndexCnt; cnt++) {
								if (SearchMoney1 <= Price.get(cnt) && SearchMoney2 >= Price.get(cnt)) {
									System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
								}
							}
						}
						break;
					case 5://タイプを指定して検索表示
						System.out.println("\n■タイプを指定して検索表示します。\n検索文字列は完全一致のみです。");
						SearchType = stdIn.nextInt();
						for (int cnt = 0; cnt < IndexCnt; cnt++) {
							if (SearchType == Type.get(cnt)) {
								System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
							}
						}						
						break;
					}
				}
				break;
			case 3://図書削除
				IndexCnt = BookName.size();
				if (IndexCnt == 0) {
					System.out.println("\n■登録されている図書はありません。Top画面に戻ります。\n");
				}
				else {					
					System.out.println("\n■表示されている一覧から、削除する図書の番号を入力します。");
					for (int cnt = 0; cnt < IndexCnt; cnt++) {
						System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
					}
					System.out.println("削除する図書の左にある番号を入力してください。");
					MenuNo = stdIn.nextInt();
					BookName.remove(MenuNo);
					Author.remove(MenuNo);
					Price.remove(MenuNo);
					Type.remove(MenuNo);
					for (int cnt = 0; cnt < IndexCnt; cnt++) {
						System.out.println(cnt + " | " + BookName.get(cnt) + " | " + Author.get(cnt) + " | " + Price.get(cnt) + " | " + Type.get(cnt));
					}
					System.out.println("\n図書の削除がが完了しました。Top画面に戻ります。\n");					
				}
				break;
			case 4://システム終了
				System.out.println("\nシステムを終了しました。");
				System.exit(0);
				break;
			}
			
		} while(MenuNo<4);

	}

}
