/*
 * Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * FileName: Zookeeper.java
 * Author:   weiyi.wang
 * Date:     2015年7月31日 下午5:07:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package wwy.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author weiyi.wang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ZookeeperTest {

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("10.100.204.137:2181,10.100.204.137:2182,10.100.204.137:2183", 1000,
                    new Executor());
            String name = zooKeeper.getState().name();
            System.out.println(name);
            System.exit(1);
            zooKeeper.create("/test", "张友朋".getBytes(), null, CreateMode.EPHEMERAL);
            zooKeeper.setData("/test", "罗燕青".getBytes(), 0);
            String str = new String(zooKeeper.getData("/test", false, null));
            System.out.println(str);
            zooKeeper.delete("/test", 0);
            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
