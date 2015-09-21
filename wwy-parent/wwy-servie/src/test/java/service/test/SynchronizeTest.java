package service.test;

public class SynchronizeTest {

    public static void main(String[] args) {
        Num num = new Num();
        num.setNum(1000);
        NumOp numOp = new NumOp(num);
        Company1 company = new Company1(numOp);
        Thread companyThread = new Thread(company);
        Bank1 bank = new Bank1(numOp);
        Thread bankThread = new Thread(bank);
        System.out.println("Account : Initial Balance: " + num.getNum());
        companyThread.start();
        bankThread.start();
        try {
            // join()方法等待这两个线程运行完成
            companyThread.join();
            bankThread.join();
            System.out.println("Account : Final Balance:" + num.getNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Num {

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class NumOp {

    public NumOp(Num num) {
        this.num = num;
    }

    private Num num;

    public void add() {
        num.setNum(num.getNum() + 1);
    }

    public void sub() {
        num.setNum(num.getNum() - 1);
    }
}

/* 银行 */
class Bank1 implements Runnable {

    private NumOp account;

    public Bank1(NumOp account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.sub();
        }
    }
}

/* 公司 */
class Company1 implements Runnable {

    private NumOp account;

    public Company1(NumOp account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.add();
        }
    }
}
