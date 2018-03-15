/**
 * 使用深度优先算法模型得到四个数字的全排列来用于枚举
 * */
package Calculation24;

public class Permutation {  
	public String permutation[][] = new String[24][4];//用来保存24种排列的数组
	private int t = 0;//用于数组下标的移动
    private int max = 4;  
    private String[] array = new String[max+1];//保存每一次排列的数组  
    private String[] hold = new String[max+1];//手里持有的数字数组
    private int[] flag = new int[max+1];//是否持有的标识数组
    public Permutation(String a,String b,String c,String d) {
    	/*初始四个数字全部持有，标识为1*/
    	flag[1] = 1;
    	flag[2] = 1;
    	flag[3] = 1;
    	flag[4] = 1;
        hold[1] = a;
        hold[2] = b;
        hold[3] = c;
        hold[4] = d;
    }  
      
    public void permute(int step) {
        if(step == max + 1) {
        	permutation[t][0] = array[1];
        	permutation[t][1] = array[2];
        	permutation[t][2] = array[3];
        	permutation[t][3] = array[4];
        	t++;
    //        for(int i = 0; i < max; i++) {  
   //             System.out.print(permutation[t-1][i] + " ");  
    //        }  
//            System.out.println(t);  取消注释即可输出全排列
            return;  //返回上一步, 即最近一次调用permute方法的后一行  
        }  
        //按照  a->b->c->d 的顺序尝试  
        for(int num = 1; num <= max; num++) {  
            //判断是否还持有该数字  
            if(flag[num] == 1) {  
                array[step] = hold[num];  
                flag[num] = 0;  
                //递归: 右移一格重复遍历数字的尝试  
                permute(step + 1);  
                //回到当前位置时取回当前位置数字  
                flag[num] = 1;  
            }  
        }  
    }  
      
    public static void main(String[] args) {  
        Permutation fa = new Permutation("2","7","5","1");  
        fa.permute(1);  
    }  
}  
