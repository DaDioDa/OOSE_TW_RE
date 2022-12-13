//Dinner Class
package Core.Strategy;


import android.util.Log;

import com.nini.menu.DBM;

import java.util.ArrayList;

import Core.Composite.Menu;
import Core.Singleton.Controller;

public class Dinner implements TimeStrategy{
	String[] sql = new String[4];
	Menu data;
	DBM con = DBM.getInstance();

	@Override
	public void execute()
	{
		new Thread(new Runnable() {
			@Override
			public void run() {
				con.run();
				sql = new String[]{"SELECT * FROM main where dinner = 1", "SELECT * FROM soup where dinner = 1", "SELECT * FROM dessert where dinner = 1", "SELECT * FROM drinks where dinner = 1"};
				data = con.getData(sql);
				Controller.getInstance().setMenu(data);
				Log.v("DB","=======晚餐=======" + data);
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
