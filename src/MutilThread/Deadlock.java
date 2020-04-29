package MutilThread;
/**
 * 基本的java 死锁模拟
 */
public class Deadlock {
    public static String str1 = "str1";
//    public static String str2 = "str1";
// 常量池，如果不同的线程持有的锁是具有相同字符的字符串锁时，两个锁实际上同一个锁
    public static String str2 = "str2";

    public static void main(String[] args){
        Thread a = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str1){
                        System.out.println(Thread.currentThread().getName()+"锁住 str1");
//                        Thread.sleep(1000);
                        synchronized(Deadlock.str2){
                            System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try{
                while(true){
                    synchronized(Deadlock.str2){
                        System.out.println(Thread.currentThread().getName()+"锁住 str2");
//                        Thread.sleep(1000);
                        synchronized(Deadlock.str1){
                            System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }
}