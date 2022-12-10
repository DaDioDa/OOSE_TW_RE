//Lunch Class
package Core.Strategy;

import static com.nini.menu.Menu.con;

import android.util.Log;

import com.nini.menu.DBM;

public class Lunch implements TimeStrategy{

	String sql;
	String data;
	@Override
	public void execute()
	{
		con.run();
		sql ="SELECT * FROM dessert where lunch = 1";
		data = con.getData(sql);
		Log.v("DB","=======午餐======="+data);

	}
}
