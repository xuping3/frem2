package com.turing.proxy03;
/**
 * 目标方
 * @author fred
 *
 */
public class TeacherService implements IService{

	//方法
	@Override
	public void add() {
//		System.out.println("开启事务...");
		System.out.println("添加一条老师记录...");
//		System.out.println("提交事务...");
	}
}
