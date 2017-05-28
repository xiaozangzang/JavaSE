package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUser {
	  public boolean UseReflect() throws NoSuchFieldException{  
          boolean flag=false;  
           try {  
               //>>>>>>>>>>>>>>>>>>>>>>  
               //获取某个类的Class对象有三种方式(其实就是获取类Reflect)，如下：  
               //方法一：利用Class.forName(String param);  
               Class cls=Class.forName("reflect.Reflect");  
               //方法二：使用  类名.class  
               //Class cls=Reflect.class;  
               //方法三：使用getClass()  
               //Reflect r=new Reflect();   
               //Class cls=r.getClass();  
               //<<<<<<<<<<<<<<<<<<<<<<<<  
               System.out.println("-------------cls is "+cls+"-------------------------");  
                 
               //利用获取到的类的Class对象新建一个实例（相当于Reflect new了个对象）  
               Object obj=cls.newInstance();  
                 
               System.out.println("-------------obj is "+obj+"-------------------------");  
                 
                   Class[] param=new Class[1];  
                   param[0]=String.class;  
                    System.out.println("-------------param[0] is "+param[0]+"-------------------------");  
                     
                //获取Reflect的方法，第一个参数是方法名；第二个参数是参数的类型，注意是参数的类型！       
                Method med=cls.getMethod("setName",param);  
                //null表示getName方法没有参数  
                Method med1=cls.getMethod("getName", null);  
                System.out.println("-------------med is "+med+"-------------------------");  
                  
//                Object o=med.invoke(obj, new Object[]{"this is a reflect test."});  
               //开始调用方法，第一个参数是调用该方法的对象；第二个参数是值，即setName方法中要传入的值  
                Object o=med.invoke(obj, "this is a reflect test.");  
                System.out.println("-------------o is "+o+"-------------------------");  
                 
                //方法没有 参数的话就用null表示  
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
