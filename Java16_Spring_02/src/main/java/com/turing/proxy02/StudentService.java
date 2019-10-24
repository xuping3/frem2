package com.turing.proxy02;
/**
 * 目标方
 * @author fred
 *
 */
public class StudentService implements IService{

	//方法
	@Override
	public void add() {
//		System.out.println("开启事务...");
		System.out.println("添加一条学生记录...");
//		System.out.println("提交事务...");
	}
}
