package view.tm;

public class IncomeTM {
    private int month;
    private double income;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public IncomeTM(int month, double income) {
        this.month = month;
        this.income = income;
    }

    @Override
    public String toString() {
        return "IncomeTM{" +
                "month=" + month +
                ", income=" + income +
                '}';
    }
}
