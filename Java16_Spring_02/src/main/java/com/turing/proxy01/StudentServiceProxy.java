package com.turing.proxy01;

/**
 * 代理方
 * 使用继承能否解决问题？
 * 		---没有解决，增强的是孩子
 * @author fred
 *
 */
public class StudentServiceProxy extends StudentService{

	/**
	 * 增强父类的方法
	 */
	@Override
	public void add() {
		//增强的代码
		System.out.println("开启事务...");
		super.add();
		//增强的代码
		System.out.println("提交事务...");
	}
	
	public static void main(String[] args) {
		new StudentServiceProxy().add();
	}
}
