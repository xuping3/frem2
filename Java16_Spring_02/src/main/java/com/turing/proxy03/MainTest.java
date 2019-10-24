package com.turing.proxy03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试类
 * @author fred
 *
 */
public class MainTest {

	public static void main(String[] args) {
		//1.创建目标方对象(增强前)
//		StudentService target = new StudentService();
		IService target = new TeacherService();
		//2.创建代理方对象（增强后）---注意：只能用接口接收，不能用实现类，不然就保存
		IService proxy = (IService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), //目标方的类加载器
				target.getClass().getInterfaces(), //目标方的所有接口
				new InvocationHandler() {//匿名内部类
					
					//当目标方的任意方法执行，都会调用的方法
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//增强的方法
						System.out.println("开启事务");
						//调用目标方的方法
						Object object = method.invoke(target, args);
						//增强的方法
						System.out.println("提交事务");
						
						return object;//就是代理对象
					}
				});
		//3.调用代理方的方法
		proxy.add();
		
		/**
		 * JDK动态代理：在编译之后，把代理方创建好
		 * 	1、目标方必须要有一个接口。
		 *  2、让代理方实现和目标方相同的接口。
		 *  3、不管目标方有多少方法，只需要一个JDK代理就搞定
		 *  
		 *  
		 *  不管是静态代理还是动态代理，都需要有接口，那如果没有接口呢？？？？？？？？？？？？？？？
		 */
	}
	

}
