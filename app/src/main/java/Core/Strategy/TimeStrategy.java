//Strategy interface "TimeStrategy"
package Core.Strategy;

import com.nini.menu.DBM;

public interface TimeStrategy {
	DBM con = DBM.getInstance();
	void execute();
}
