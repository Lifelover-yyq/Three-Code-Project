/**
 * 	��������óɼ������а����гɼ��Ƚ�����ȷ�����Ƿ������¼�¼
 * */
package Calculation24;

public class Sort {
	public String Ranking[];//��������������
	public int t;//��ҳɼ������а��ϵ�λ��
	
	public Sort(String a[],String x) {	//����TXT�ļ���������ҳɼ�a[] ����ҳɼ�x
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
			else break;//����ʱt��Ϊ��ҳɼ��������е�λ��
		}
		/*��¼ԭ���а�0 ~��t-1�����ɼ�*/
		for(int i=0; i<t; i++){
			Ranking[i] = a[i];
		}
		
		/*ԭλ�ã�t+1��~ len-1 �����ƶ�һλ*/
		for(int i=t+1; i<=len; i++) {
			Ranking[i] = a[i-1];
		}
		/*����ϰ�λ��t*/
		Ranking[t] = x;
	}
//	public Sort(String a,String b,String c,String d,String e,String f){
//		String w[] = {a,b,c,d,e};//�������а������ɼ�
//		/*�Ӻ���ǰ�Ƚ���ҳɼ������гɼ�*/
//		for(int i=4; i>=0; i--){
//			if(Integer.parseInt(f) > Integer.parseInt(w[i])){
//				t--;
//			}
//			else break;//����ʱt��Ϊ��ҳɼ��������е�λ��
//		}
//		/*��¼ԭ���а�1~t���ɼ�*/
//		for(int i=0; i<t; i++){
//			Ranking[i] = w[i];
//		}
//		/*������ϰ���¼ԭ��(t+2)~4���ɼ���ԭ���������������а�*/
//		if(t < 5){
//		for(int i=t+1; i<5; i++){
//			Ranking[i] = w[i-1];
//		}
//		/*����ϰ��t+1��*/
//		Ranking[t] = f;
//		}
//	}
	
}
