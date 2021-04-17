/**
 * 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样行不行？
 *
 * 容易产生脏读问题（dirtyRead）
 */

package com.cloud.rabbittask.juc;

import java.util.concurrent.TimeUnit;

public class Account implements Runnable{
	String name;
	double balance = 100;
	
	public synchronized void set(String name, double balance) {
		this.name = name;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		this.balance = balance;
	}
	
	public void getBalance(String name) {
		synchronized (Account.class){
			for(int i= 0;i<10;i++){
				System.out.println(Thread.currentThread().getName() + ":" + balance++);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Account a = new Account();
		Account b = new Account();
		new Thread(a,"123").start();
		new Thread(b,"321").start();
	}

	@Override
	public synchronized void run() {
		getBalance("123");
	}
}
