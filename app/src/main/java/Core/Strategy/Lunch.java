//Lunch Class
package Core.Strategy;


import android.util.Log;

import com.nini.menu.DBM;

import Core.Composite.Menu;

public class Lunch implements TimeStrategy{

	String[] sql;
	Menu data;
	DBM con = DBM.getInstance();
	@Override
	public void execute()
	{
		new Thread(new Runnable() {
			@Override
			public void run() {
				con.run();
				sql = new String[]{"SELECT * FROM main where lunch = 1", "SELECT * FROM dessert where lunch = 1", "SELECT * FROM soup where lunch = 1", "SELECT * FROM drinks where lunch = 1"};
				data = con.getData(sql);
				Log.v("DB","=======午餐=======" + data);
			}
		}).start();
		/*
		con.run();
		sql ="SELECT * FROM dessert where lunch = 1";
		data = con.getData(sql);
		Log.v("DB","=======午餐======="+data);

		 */

	}
}
