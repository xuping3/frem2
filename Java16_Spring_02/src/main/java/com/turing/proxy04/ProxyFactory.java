package com.turing.proxy04;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 代理工厂---生产代理对象
 * @author fred
 *
 */
public class ProxyFactory implements MethodInterceptor{

	//目标方
	private Object tareget;

	public ProxyFactory(Object tareget) {
		super();
		this.tareget = tareget;
	}

	//创建代理对象
	public Object getProxy() {
		//创建一个增强器
		Enhancer en = new Enhancer();
		//设置父类加载器
		en.setClassLoader(tareget.getClass().getClassLoader());
		//设置代理方的父类
		en.setSuperclass(tareget.getClass());
		//设置拦截方法
		en.setCallback(this);
		//创建代理对象
		return en.create();
	}


	//拦截---当目标方的任意方法执行，都会拦截的方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object object = null;
		if(!"sel".equals(method.getName())) {
			//增强目标方
			System.out.println("开启事务");
			object = method.invoke(tareget, args);
			//增强目标方
			System.out.println("提交事务");
		}else {
			object = method.invoke(tareget, args);
		}
		return object;
	}

	
}
