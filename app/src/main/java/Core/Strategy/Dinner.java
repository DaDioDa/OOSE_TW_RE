//Dinner Class
package Core.Strategy;


import android.util.Log;

import com.nini.menu.DBM;

public class Dinner implements TimeStrategy{
	String sql;
	String data;
	DBM con = DBM.getInstance();
	@Override
	public void execute()
	{
		new Thread(new Runnable() {
			@Override
			public void run() {
				con.run();
				sql ="SELECT * FROM dessert where dinner = 1";
				data = con.getData(sql);
				Log.v("DB","=======晚餐======="+data);
			}
		}).start();
		/*
		con.run();
		sql ="SELECT * FROM dessert where dinner = 1";
		data = con.getData(sql);
		Log.v("DB","=======晚餐======="+data);


		 */
	}

}
