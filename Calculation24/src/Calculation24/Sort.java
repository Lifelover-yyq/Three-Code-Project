/**
 * 	将玩家所得成绩与排行榜现有成绩比较排序，确定其是否创造了新纪录
 * */
package Calculation24;

public class Sort {
	public String Ranking[];//保存排名的数组
	public int t;//玩家成绩在排行榜上的位置
	
	public Sort(String a[],String x) {	//接收TXT文件中所有玩家成绩a[] 新玩家成绩x
		int len = 0;
		for(int i=0;i<a.length;i++) {
			if(null != a[i])len++;
		}
		Ranking = new String[len+1];
		t = len;
		for(int i=len-1; i>=0; i--){
			if(Integer.parseInt(x) > Integer.parseInt(a[i])){
				t--;
			}
			else break;//跳出时t即为玩家成绩在数组中的位置
		}
		/*收录原排行榜0 ~（t-1）名成绩*/
		for(int i=0; i<t; i++){
			Ranking[i] = a[i];
		}
		
		/*原位置（t+1）~ len-1 往后移动一位*/
		for(int i=t+1; i<=len; i++) {
			Ranking[i] = a[i-1];
		}
		/*玩家上榜位置t*/
		Ranking[t] = x;
	}
//	public Sort(String a,String b,String c,String d,String e,String f){
//		String w[] = {a,b,c,d,e};//现有排行榜的五个成绩
//		/*从后往前比较玩家成绩与现有成绩*/
//		for(int i=4; i>=0; i--){
//			if(Integer.parseInt(f) > Integer.parseInt(w[i])){
//				t--;
//			}
//			else break;//跳出时t即为玩家成绩在数组中的位置
//		}
//		/*收录原排行榜1~t名成绩*/
//		for(int i=0; i<t; i++){
//			Ranking[i] = w[i];
//		}
//		/*若玩家上榜，收录原榜单(t+2)~4名成绩，原第五名被挤出排行榜*/
//		if(t < 5){
//		for(int i=t+1; i<5; i++){
//			Ranking[i] = w[i-1];
//		}
//		/*玩家上榜第t+1名*/
//		Ranking[t] = f;
//		}
//	}
	
}
