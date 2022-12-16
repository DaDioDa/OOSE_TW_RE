//Strategy interface "TimeStrategy"
package Core.Strategy;

import Core.Singleton.DBM;

public interface TimeStrategy {
	DBM con = DBM.getInstance();
	void execute();
}
