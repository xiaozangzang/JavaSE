package reflect;

public class TestReflect {
	  public static void main(String[] args) throws NoSuchFieldException{  
	        boolean flag=false;  
	        ReflectUser rlu=new ReflectUser();  
	        flag=rlu.UseReflect();  
	          
	        if(flag){  
	        System.out.println("successful!");  
	          
	       }else{  
	        System.out.println("fail~~~~");  
	       }  
	  
	}  
}
