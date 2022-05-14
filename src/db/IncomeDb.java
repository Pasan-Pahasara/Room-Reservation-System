package db;

import view.tm.IncomeTM;

import java.time.Year;
import java.util.ArrayList;

public class IncomeDb {
    public static ArrayList<IncomeTM> monthIncome = new ArrayList();
    static {
        monthIncome.add(new IncomeTM(1,0));
//        monthIncome.add(new IncomeTM(2,0));
//        monthIncome.add(new IncomeTM(3,0));
//        monthIncome.add(new IncomeTM(4,0));
    }
}
