
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 聊天群
 *
 * @author ChiShiJie
 * @createdAt 2019-06-15 09:42
 */
public class ChatGroup {

    private String groupId;
    private String channelId;
    private String roomType = "Lala";

    private Map<String, User> userMap = new ConcurrentHashMap<>();
    private Transaction transaction;

    public ChatGroup(String groupId, String channelId) {
        this.groupId = groupId;
        this.channelId = channelId;
        this.transaction = new Transaction();
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        this.userMap.put(user.getUserId(), user);
        return user;
    }

    /**
     * 移除用户
     *
     * @param userId
     * @return
     */
    public User removeUser(String userId) {
        return this.userMap.remove(userId);
    }

    /**
     * 用户上线
     *
     * @param userId
     * @return
     */
    public User change2Online(String userId) {
        User user = this.userMap.get(userId);
        user.online = true;
        return user;
    }

    /**
     * 用户离线
     *
     * @param userId
     * @return
     */
    public User change2Offline(String userId) {
        User user = this.userMap.get(userId);
        user.online = false;
        return user;
    }

    /**
     * 创建事务
     *
     * @return
     */
    public Transaction newTransaction() {
        return transaction;
    }

    /**
     * 创建用户构建器
     * @return
     */

    /**
     * 在线用户迭代器
     *
     * @return
     */
    public Iterator<User> getOnlineUserIterator() {
        return this.userMap.values().iterator();
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public String getChannelId() {
        return channelId;
    }

    @Override
    public String toString() {
        return String.format("{groupId: %s, channelId: %s}", groupId, channelId);
    }

    public User find(String userId) {
        return this.userMap.get(userId);
    }

    public class User {

        private String userId;
        private boolean online = true;
        private boolean showRoomState;

        public String getUserId() {
            return this.userId;
        }

        /**
         * 当前用户状态(综合考虑群和房间)
         * @return
         */

        /**
         * 是否在线
         *
         * @return
         */
        public boolean isOnline() {
            return online;
        }

        /**
         * 设置是否上线
         *
         * @param online
         */
        public void setOnline(boolean online) {
            this.online = online;
        }

        /**
         * 是否展示房间状态
         *
         * @return
         */
        public boolean isShowRoomState() {
            return showRoomState;
        }

        /**
         * 设置是否展示房间状态
         *
         * @param showRoomState
         */
        public void setShowRoomState(boolean showRoomState) {
            this.showRoomState = showRoomState;
        }

        /**
         * 输出信息
         *
         * @return
         */
        public Map<String, Object> output() {

            Map<String, Object> output = new HashMap<>();

            return output;
        }
    }

    public class UserBuilder {

        private User user = new User();

        public UserBuilder setUserId(String userId) {
            user.userId = userId;
            return this;
        }

        /**
         * 是否展示群状态
         *
         * @param showRoomState
         * @return
         */
        public UserBuilder setShowRoomState(boolean showRoomState) {
            user.setShowRoomState(showRoomState);
            return this;
        }


    }


    /**
     * 群事务
     */
    class Transaction {


        private Lock lock = new ReentrantLock();

        /**
         * 事务开始
         */
        public void start() {
            lock.lock();
        }

        /**
         * 事务结束
         */
        public void end() {
            lock.unlock();
        }
    }


}
