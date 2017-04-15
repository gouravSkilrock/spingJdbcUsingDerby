package org.panwar;

import org.panwar.Dao.CircleDao;
import org.panwar.model.Circle;

public class JdbcDemo {

	/**
	 * 
	 * Author : gourav Panwar
	 */
	public static void main(String[] args) {

		Circle circle =new CircleDao().getCircle(1);
		System.out.println(circle.getName());
	}

}
