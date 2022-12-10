//Dinner Class
package Core.Strategy;

import static com.nini.menu.Menu.con;

import android.util.Log;

public class Dinner implements TimeStrategy{
	String sql;
	String data;
	@Override
	public void execute()
	{
		con.run();
		sql ="SELECT * FROM dessert where dinner = 1";
		data = con.getData(sql);
		Log.v("DB","=======晚餐======="+data);

	}

}
