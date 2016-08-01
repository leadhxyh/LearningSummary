-	死锁
（每个线程都在等待其他线程释放资源，但是在获得需要的所有资源前不释放自己拥有的资源）：锁顺序死锁，资源死锁
-	锁顺序死锁
1.简单的锁顺序死锁
```
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {
    }

    void doSomethingElse() {
    }
}
```
2.动态的锁顺序死锁
```
 public static void transferMoney(Account fromAccount,
                                     Account toAccount,
                                     DollarAmount amount)
            throws InsufficientFundsException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount) < 0)
                    throw new InsufficientFundsException();
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
```
当两个线程同时调用同一个对象的transerMoney时，可能发生死锁。transerMoney(myAccount, yourAccount, 10), transerMoney(yourAccount, myAccount, 10)
解决方案：1.通过两个对象的hash码来规定顺序
```
public class InduceLockOrder {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct,
                              final Account toAcct,
                              final DollarAmount amount)
            throws InsufficientFundsException {
        class Helper {
            public void transfer() throws InsufficientFundsException {
                if (fromAcct.getBalance().compareTo(amount) < 0)
                    throw new InsufficientFundsException();
                else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    interface DollarAmount extends Comparable<DollarAmount> {
    }

    interface Account {
        void debit(DollarAmount d);

        void credit(DollarAmount d);

        DollarAmount getBalance();

        int getAcctNo();
    }

    class InsufficientFundsException extends Exception {
    }
}
```
2.使用tryLock避免锁顺序死锁

-	死锁避免
1.支持定时的锁：Lock.tryLock，支持超时设置
2.减少加锁交互数量