/**
 * Created by zsy on 2019/7/19 15:05
 */
public class LockTest {
    static String msg = "lllooooccckk";
    static ChatGroup c1 = new ChatGroup("1", "1");
    static ChatGroup c2 = new ChatGroup("2", "2");

    public static void main(String[] args)  {


        new Thread(() -> {
            tellMsg(c1);
            tellMsg(c1);
            tellMsg(c1);
            tellMsg(c1);
            tellMsg(c1);
        }).start();
        tellMsg(c2);
    }

    public static void tellMsg(ChatGroup group)  {
        group.newTransaction().start();
        System.out.println("lock:"+group.getChannelId());
        System.out.println(msg);
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        group.newTransaction().end();
        System.out.println("unlock:"+group.getChannelId());
    }
}
