package com.turing.proxy02;

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
		StudentServiceProxy proxy = new StudentServiceProxy(target);
		//3.调用代理方的方法
		proxy.add();
		
		/**
		 * 静态代理：在编译之前，把代理方创建好
		 * 	1、目标方必须要有一个接口。
		 *  2、让代理方实现和目标方相同的接口。
		 *  3、如果目标方的接口有变化，代理方的方法也要随之调整，维护起来不方便。
		 *  4、一个目标方要对应一个代理方，处理起来麻烦
		 *  
		 */
	}

}
