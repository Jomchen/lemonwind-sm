package com.lemonwind.sm;

import com.lemonwind.sm.common.LemonwindEntity;
import com.lemonwind.sm.entity.dto.BusinessUserDTO;
import com.lemonwind.sm.mapper.BusinessUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LemonwindSmApplication {

    public static void main(String[] args) throws IOException {
       String resource = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession sqlSession = sqlSessionFactory.openSession();
       BusinessUserMapper businessUserMapper = sqlSession.getMapper(BusinessUserMapper.class);
       List<BusinessUserDTO> dataList = businessUserMapper.findUserWithKongFu(3);

//       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////       List<User> dataList = userMapper.findCondition(6, 15, 0, " AND email IS NOT NULL");
//        List<User> dataList = userMapper.findCondition(6, 15, 0, " AND email IS NULL");
       System.out.println("查询结果为：");
       printAll(dataList);
    }

    public static void printAll(List<? extends LemonwindEntity> list) {
        if (null == list || list.isEmpty()) { return; }
//        list.forEach(System.out::println);
        list.forEach(e -> {
            System.out.println(e);
        });
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
        // 下面行不注掉，t1自己 false ；下面行注掉，t1自己 true
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
