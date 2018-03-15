//用栈求解表达式
package Calculation24;

import java.util.ArrayList;  
import java.util.List;  
  
public class Stack {  
    List<Object> list;  
      
    public Stack()  
    {  
        list = new ArrayList<Object>();  
    }  
      
    public void push(Object obj)  
    {  
        list.add(obj);  
    }  
      
    public Object pop()  
    {  
        if(!list.isEmpty())  
        {  
            return list.remove(list.size()-1);  
        }  
        return null;  
    }  
      
    public Object get()  
    {  
        if(!list.isEmpty())  
        {  
            return list.get(list.size()-1);  
        }  
        return null;  
    } 
    public boolean IsEmpty(){
    	if(list.isEmpty())
    		return true;
    	else return false;
    }
}  