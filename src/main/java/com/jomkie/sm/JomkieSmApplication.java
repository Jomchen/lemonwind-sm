package com.jomkie.sm;

import com.jomkie.sm.entity.User;
import com.jomkie.sm.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JomkieSmApplication {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InterruptedException {
       String resource = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession sqlSession = sqlSessionFactory.openSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

       List<User> userList;

       System.out.println("-------------------------------------------------------------");
       userList = userMapper.findCondition(6, 15, 0);
       printAll(userList);
       new Object().notifyAll();
    }

    public static void printAll(List<User> list) {
        if (null == list || list.isEmpty()) {
            return;
        }

        list.stream().forEach(System.out::println);
    }

    public static void thread00() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("t1自己" + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        // 下面行注掉，则t1打断状态为true；如果注掉，t1打断状态为 false
        // 注掉是为了t1睡眠之前被主线程打断（其它这样确保不严谨）
        // 结论：如果一个 sleep wait join 的线程被打断，则打断标记会被清除
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        System.out.println("主线程打印t1的打断状态" + t1.isInterrupted());
    }

    public static void thread01() throws InterruptedException {
       ReentrantLock lock = new ReentrantLock();
       Thread t1 = new Thread(() -> {
           try {
                // lock.lockInterruptibly() 允许被打断
               lock.lockInterruptibly();

               // lock.lock() 不会被打断
//               lock.lock();
               System.out.println("t1 拿了锁");
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }
       }, "t1");

       t1.start();
       lock.lock();
       System.out.println("main-----");
       t1.interrupt();
       Thread.sleep(3000);
       lock.unlock();
    }

}
