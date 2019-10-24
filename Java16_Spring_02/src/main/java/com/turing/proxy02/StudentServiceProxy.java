package com.turing.proxy02;

/**
 * 代理方
 *	
 * @author fred
 *
 */
public class StudentServiceProxy implements IService{
	
	//目标方
	private IService target;
	
	public StudentServiceProxy(IService target) {
		this.target = target;
	}



	/**
	 * 静态代理：
	 * 	1、创建一个接口
	 * 	2、让目标方和代理方都实现该接口
	 * 	3、代理方需要知道目标方（目标方要作为属性注入）
	 */
	@Override
	public void add() {
		//增强的方法
		System.out.println("开启事务");
		//具体业务
		target.add();
		//增强的方法
		System.out.println("提交事务");
	}
	
	

}
