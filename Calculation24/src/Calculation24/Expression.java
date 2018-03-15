/**
 *	由字符串表达式得到结果，验证玩家输入的表达式是否为24 
 */
package Calculation24;


public class Expression { 
//	/*表达式错误报错窗口*/
//	public JFrame WrongExp = new JFrame("错误警告！");
//	ImageIcon Wrongimg = new ImageIcon("Image/Wrong.png");
//	private JLabel WrongExpimg = new JLabel(Wrongimg);
//	private JLabel WrongExpLabel = new JLabel("<html>您的表达式输入不规范，<br/>下次请您规范输入，谢谢！"
//			+ "</html>");
//	private JButton WrongExpSure = new JButton("确定");
//	
//	private File BUTTONfile = new File("music_txt/Button.wav");
//	private AudioClip BUTTONClip;
	
    public static void main(String[] args)  
    {  
    	Expression dxs = new Expression();  
//    	dxs.CaveatUI();
        System.out.println(dxs.CalculateDirectly("22*89-78^1"));  
    }  
    /*得到运算符优先级*/
    public static int getOpLevel(char op)  
    {  
        switch(op)  
        {  
        case '(':return 0;  
        case '+':  
        case '-':return 1;  
        case '*':  
        case '/':return 2;
        case '^':return 3; 
        case ')':return 4; 
        
        default:return 0;  
        }  
    }
    /*四则运算计算处理*/
    public static double CaculateResult(char op,double od1,double od2)  
    {  
        switch(op)  
        {  
        case '*':return od1*od2;  
        case '/':return od1/od2;  
        case '+':return od1+od2;  
        case '-':return od1-od2;  
        case '^':return Math.pow(od1,od2);
        
        }  
        return 0;  
    }  
    /*计算多项式*/
    public double CalculateDirectly(String equation)  
    {  
        //操作数栈  
        Stack numStack = new Stack();  
        //操作符栈  
        Stack chStack = new Stack();  
          
        int t = 0;//正在处理的字符位置  
        int length = equation.length();  
        while(t < length)  
        {  
            char c = equation.charAt(t);//取得表达式第t个位置的字符  
            if(c == '(')  
            {  
                chStack.push(c);//"("则直接入操作符栈  
            }  
            else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')//若为运算符  
            {  
                int currOpLevel = getOpLevel(c);//取得运算符优先级  
                while(true)  
                {  
                    int stackOpLevel = 0;  
                    Object obj = chStack.get();//取得栈顶操作符
                    if(obj != null)  
                    {  
                        stackOpLevel = getOpLevel((char)obj);//得到栈顶操作符优先级  
                    }  
                    //新运算符优先级大于栈中原运算符优先级则可以入栈  
                    if(currOpLevel > stackOpLevel)  
                    {  
                        chStack.push(c);  
                        break;  
                    } 
                    //若小于原运算符优先级
                    else  
                    {  
                    	//运算一次
                        try{  
                            char optemp = (char) chStack.pop();  
                            double odNum1 = (double) numStack.pop();  
                            double odNum2 = (double) numStack.pop();  
                            numStack.push(CaculateResult(optemp, odNum2, odNum1));  
                        }  
                        catch(Exception e){                    
                           System.out.println("多项式不正确："+equation);  
                           e.printStackTrace();  
                        }  
                    }  
                }  
            }  
            //若字符为")"，需要计算整个括号内的表达式
            else if(c == ')')  
            {  
                while(true)  
                {  	
                	//若操作符栈为空也没有找到匹配的"(",报错
                    char op = (char) chStack.pop();
                    //直到遇到"("计算停止
                    if(op == '(')  
                    {  
                        break;  
                    }
                    
                    //取运算符、数字计算
                    else  
                    {  
                        try{     
                            double odNum1 = (double) numStack.pop(); 
                            double odNum2 = (double) numStack.pop();                               
                            numStack.push(CaculateResult(op, odNum2, odNum1));  
                        }  
                        catch(Exception e){                       	
                            System.out.println("多项式不正确："+equation);  
                            e.printStackTrace();  
                        }  
                    }  
                }
            } 
            //若字符为数字，仍然需要往后取字符，保证多位数数字可以被取到
            else if(c >= '0' && c <= '9')  
            {  
                int temp = t+1;//取到当前位置的后一位置  
                while(temp < length)  
                {  
                    char tempc = equation.charAt(temp);  
                    if(tempc >= '0' && tempc <= '9')  
                    {  
                        temp++;  
                    }  
                    else  
                    {  
                        break;  
                    }  
                }  
                String odStr = equation.substring(t, temp);// 取得完整数字 
                try {  
                    double odNum = Double.parseDouble(odStr);  
                    numStack.push(odNum); //数字入栈 
                    t = temp - 1;  //定位字符位置
                } catch (Exception e) {               	
                    System.out.println("多项式不正确："+equation);  
                    e.printStackTrace();  
                }  
            }  
              
            t++;  //操作位置后移一位
        }  
          
        //开始看操作符栈是否为空，若表达式结束，但栈中仍有字符，需要取出计算  
        while(true)  
        {  
            Object obj = chStack.pop();  
            if(obj == null)  
            {  
                break;  
            }  
            else  
            {  
                char optemp = (char) obj;          
                double odNum1 = (double) numStack.pop();
                double odNum2 = (double) numStack.pop();  
                numStack.push(CaculateResult(optemp, odNum2, odNum1));  
            }  
        }  
        double result = 0.0;  
        try {  
        	//最后数字栈中的结果即为计算结果
            result = (double) numStack.pop();  
        } catch (Exception e) {       	
            System.out.println("多项式不正确："+equation); 
            e.printStackTrace();  
        }  
        return result;  
    }
//    public void CaveatUI(){
//    	/*表达式输入错误窗口*/
//		WrongExp.setSize(300, 200);
//		WrongExp.setResizable(false);
//		WrongExp.setVisible(false);
//		WrongExp.setLocationRelativeTo(null);
//		WrongExp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		WrongExp.setLayout(null);
//		WrongExp.add(WrongExpimg);
//		WrongExpimg.setBounds(20, 20, 40, 40);
//		WrongExpLabel.setFont(new Font("WrongExpLabel",Font.BOLD, 15));
//		WrongExp.add(WrongExpLabel);
//		WrongExpLabel.setBounds(70, 30, 200, 40);
//		WrongExpSure.setFont(new Font("WrongExpSure",Font.BOLD, 15));
//        WrongExp.add(WrongExpSure);
//        WrongExpSure.setBounds(50, 120, 200, 30);
//        /*表达式错误提示窗口按钮*/
//		WrongExpSure.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				try {
//					BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
//				} catch (MalformedURLException e1) {
//					e1.printStackTrace();
//				}
//				BUTTONClip.play();
//				WrongExp.dispose();
//			}
//		});
//		WrongExp.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e) {
//				try {
//					BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
//				} catch (MalformedURLException e1) {
//					e1.printStackTrace();
//				}
//				BUTTONClip.play();
//				WrongExp.dispose();
//			}
//		});
//		WrongExp.setVisible(true);
//    }
}  