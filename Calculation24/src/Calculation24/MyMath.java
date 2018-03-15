//小数的处理
package Calculation24;

import java.math.BigDecimal;
		/*准确位数的四舍五入*/
	public class MyMath {
		public static double round(double num ,int scale ){
			BigDecimal big = new BigDecimal(num);
			BigDecimal result = big.divide(new BigDecimal(1),scale,
			BigDecimal.ROUND_HALF_UP);
			return result.doubleValue(); //Number类的方法
		}
}
