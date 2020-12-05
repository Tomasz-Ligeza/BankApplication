package transaction;

import java.time.Period;

public class PeriodTransaction extends Transaction {
    private Period period;
    private boolean active;

    //ctors

    public void setPeriod(Period period) {
        this.period = period;
    }

    void stopTransaction() { active = false; }

}
