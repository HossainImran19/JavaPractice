package advance.java.imran.g.uses.of.lamda.g.execute.around.method;

import java.util.concurrent.locks.Lock;

public class LockHelper {
    public static void withLock(Lock lock, VoidBusinessCode businessCode) {
        lock.tryLock();
        try {
            businessCode.apply();
        } finally {
            lock.unlock();
        }
    }

    public static int withLock(Lock lock, IntBusinessCode businessCode) {
        lock.tryLock();
        try {
            return businessCode.apply();
        } finally {
            lock.unlock();
        }
    }
}
