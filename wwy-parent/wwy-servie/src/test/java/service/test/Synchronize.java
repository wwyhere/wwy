package service.test;

public class Synchronize {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Account account = new Account();
            account.setBalance(1000);
            Company company = new Company(account);
            Thread companyThread = new Thread(company);
            Bank bank = new Bank(account);
            Thread bankThread = new Thread(bank);
            System.out.printf("Account : Initial Balance:  %f\n", account.getBalance());
            companyThread.start();
            bankThread.start();
            try {
                // join()方法等待这两个线程运行完成
                companyThread.join();
                bankThread.join();
                System.out.printf("Account : Final Balance:  %f\n", account.getBalance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/* 帐户 */
class Account {

    private double balance;

    /* 将传入的数据加到余额balance中 */
    public synchronized void addAmount(double amount) {
        balance += amount;
    }

    /* 将传入的数据从余额balance中扣除 */
    public synchronized void subtractAmount(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

/* 银行 */
class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }
}

/* 公司 */
class Company implements Runnable {

    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }
}
