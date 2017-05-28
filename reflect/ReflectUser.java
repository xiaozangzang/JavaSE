package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUser {
	  public boolean UseReflect() throws NoSuchFieldException{  
          boolean flag=false;  
           try {  
               //>>>>>>>>>>>>>>>>>>>>>>  
               //��ȡĳ�����Class���������ַ�ʽ(��ʵ���ǻ�ȡ��Reflect)�����£�  
               //����һ������Class.forName(String param);  
               Class cls=Class.forName("reflect.Reflect");  
               //��������ʹ��  ����.class  
               //Class cls=Reflect.class;  
               //��������ʹ��getClass()  
               //Reflect r=new Reflect();   
               //Class cls=r.getClass();  
               //<<<<<<<<<<<<<<<<<<<<<<<<  
               System.out.println("-------------cls is "+cls+"-------------------------");  
                 
               //���û�ȡ�������Class�����½�һ��ʵ�����൱��Reflect new�˸�����  
               Object obj=cls.newInstance();  
                 
               System.out.println("-------------obj is "+obj+"-------------------------");  
                 
                   Class[] param=new Class[1];  
                   param[0]=String.class;  
                    System.out.println("-------------param[0] is "+param[0]+"-------------------------");  
                     
                //��ȡReflect�ķ�������һ�������Ƿ��������ڶ��������ǲ��������ͣ�ע���ǲ��������ͣ�       
                Method med=cls.getMethod("setName",param);  
                //null��ʾgetName����û�в���  
                Method med1=cls.getMethod("getName", null);  
                System.out.println("-------------med is "+med+"-------------------------");  
                  
//                Object o=med.invoke(obj, new Object[]{"this is a reflect test."});  
               //��ʼ���÷�������һ�������ǵ��ø÷����Ķ��󣻵ڶ���������ֵ����setName������Ҫ�����ֵ  
                Object o=med.invoke(obj, "this is a reflect test.");  
                System.out.println("-------------o is "+o+"-------------------------");  
                 
                //����û�� �����Ļ�����null��ʾ  
                Object o1=med1.invoke(obj, null);  
                System.out.println("-------------o1 is "+o1+"-------------------------");  
                 
                flag=true;  
           } catch (InstantiationException e) {  
                 
               e.printStackTrace();  
           } catch (IllegalAccessException e) {  
             
               e.printStackTrace();  
           } catch (SecurityException e) {  
             
               e.printStackTrace();  
           } catch (NoSuchMethodException e) {  
             
               e.printStackTrace();  
           } catch (IllegalArgumentException e) {  
             
               e.printStackTrace();  
           } catch (InvocationTargetException e) {  
             
               e.printStackTrace();  
           } catch (ClassNotFoundException e) {  
             
               e.printStackTrace();  
           }  
             
            return flag;  
      }  
         
}
