package thread.sample.connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 使用等待超时模式来构造一个简单的数据库连接池
 * Created by xuzixu on 2019/1/21.
 */
class ConnectionPool {
    private final LinkedList<Connection> pool = new LinkedList<>();

    ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }

    Connection fetchConnection(long millis) throws InterruptedException {
        synchronized (pool) {
            if (millis <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + millis;
                while (pool.isEmpty() && millis > 0) {
                    pool.wait(millis);
                    millis = future - System.currentTimeMillis();
                }
                return pool.isEmpty() ? null : pool.removeFirst();
            }
        }
    }
}
