package com.turing.proxy04;

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
		StudentService target = new StudentService();
		//2.创建代理方对象（增强后）
		StudentService proxy = (StudentService) new ProxyFactory(target).getProxy();
		//3.调用代理方的方法
		proxy.add();
		System.out.println("----------------------");
		proxy.del();
		System.out.println("----------------------");
		proxy.sel();
		
		/**
		 * CGLIB动态代理：在编译之后，把代理方创建好
		 * 	1、没有接口也可以实现动态代理
		 *  
		 *  
		 * 
		 */
	}
	

}
