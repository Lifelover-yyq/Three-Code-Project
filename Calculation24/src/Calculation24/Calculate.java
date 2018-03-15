/**
 * 	由所给的四个数字得到计算24点的表达式，若无解返回false，用于给出正确答案
 * 思路：将四个数字全排列保存，对每一种排列，针对五种计算顺序任意插入三个四种运算符号来计算，结果为24的表达式即为所求
 */
package Calculation24;

public class Calculate {
	public String Answer = "该四数无法得到24!";//存储最终表达式的字符串
	public static String oper(int i, String m, String n) {     //枚举四种运算符   
	    if(i == 1) return "("+m+"+"+n+")";  
	    if(i == 2) return "("+m+"-"+n+")";  
	    if(i == 3) return "("+m+"*"+n+")";  
	    if(n.equals("0")) return "999";  //除法必须除数不为0
	    else return "("+m+"/"+n+")";  
	}  

	public void Calculate1(int i, int j, int k,
			String a,String b,String c,String d) {   //计算顺序1 ((a@b)@c)@d
		String tmp1 = oper(i, a, b);  
		String tmp2 = oper(j, tmp1, c);  
		String tmp3 = oper(k, tmp2, d);  
		Expression q = new Expression();
		if(q.CalculateDirectly(tmp3) == 24 || 
				   q.CalculateDirectly(tmp3) == 23.99999999999999){
					this.Answer = tmp3;
				}
	}  
	  
	public void Calculate2(int i, int j, int k,
			String a,String b,String c,String d) {   //计算顺序2 (a@b)@(c@d)   
		String tmp1 = oper(i, a, b);  
		String tmp2 = oper(k, c, d);  
		String tmp3 = oper(j, tmp1, tmp2);  
		Expression q = new Expression();
		if(q.CalculateDirectly(tmp3) == 24 || 
		   q.CalculateDirectly(tmp3) == 23.99999999999999){
			this.Answer = tmp3;
		}
	}  
	public void Calculate3(int i, int j, int k,
			String a,String b,String c,String d) {   //计算顺序3 ((a@(b@c))@d)
		String tmp1 = oper(i, b, c);  
		String tmp2 = oper(j, a, tmp1);  
		String tmp3 = oper(k, tmp2, d);  
		Expression q = new Expression();
		if(q.CalculateDirectly(tmp3) == 24 || 
				   q.CalculateDirectly(tmp3) == 23.99999999999999){
					this.Answer = tmp3;
				}
	}
	public void Calculate4(int i, int j, int k,
			String a,String b,String c,String d) {   //计算顺序4 (a@(b@(c@d)))
		String tmp1 = oper(i, c, d);  
		String tmp2 = oper(j, b, tmp1);  
		String tmp3 = oper(k, a, tmp2);  
		Expression q = new Expression();
		if(q.CalculateDirectly(tmp3) == 24 || 
				   q.CalculateDirectly(tmp3) == 23.99999999999999){
					this.Answer = tmp3;
				}
	}
	public void Calculate5(int i, int j, int k,
			String a,String b,String c,String d) {   //计算顺序5  (a@((b@c)@d))
		String tmp1 = oper(i, b, c);  
		String tmp2 = oper(j, tmp1, d);  
		String tmp3 = oper(k, a, tmp2);  
		Expression q = new Expression();
		if(q.CalculateDirectly(tmp3) == 24 || 
				   q.CalculateDirectly(tmp3) == 23.99999999999999){
					this.Answer = tmp3;
				}
	}
	  public void GiveAnswer(String a,String b,String c,String d){
		  Permutation q = new Permutation(a,b,c,d);
		  q.permute(1);
//		  long start = System.currentTimeMillis();			
	here:	for(int t = 0; t < 24; t++){	//24种全排列
		  		for(int i = 1; i <= 4; i++){  	//三个运算符
		  			for(int j = 1; j <= 4; j++){  
		  				for(int k = 1; k <= 4; k++){
		  				Calculate1(i,j,k,q.permutation[t][0],q.permutation[t][1],q.permutation[t][2],q.permutation[t][3]);
		  				Calculate2(i,j,k,q.permutation[t][0],q.permutation[t][1],q.permutation[t][2],q.permutation[t][3]);
		  				Calculate3(i,j,k,q.permutation[t][0],q.permutation[t][1],q.permutation[t][2],q.permutation[t][3]);	       
		  				Calculate4(i,j,k,q.permutation[t][0],q.permutation[t][1],q.permutation[t][2],q.permutation[t][3]);
		  				Calculate5(i,j,k,q.permutation[t][0],q.permutation[t][1],q.permutation[t][2],q.permutation[t][3]);
		  					if(!this.Answer.equals("该四数无法得到24!")){
		  					break here;
		  					}
		  				} 		  			
		  			}	        	
		  		}			
		  	} 
//		  long end = System.currentTimeMillis();			
//			System.out.println("所花费的时间："+(end - start)+"ms");//统计一个操作花费的时间
	}	  
	 public static void main(String[] args) {       
	         Calculate s = new Calculate();
	         s.GiveAnswer("3", "3", "8", "8");
	         System.out.print(s.Answer);
	             
	                
	    }    
	  
}
