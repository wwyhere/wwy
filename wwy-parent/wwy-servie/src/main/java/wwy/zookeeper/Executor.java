/*
 * Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * FileName: Executor.java
 * Author:   weiyi.wang
 * Date:     2015年7月31日 下午5:54:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package wwy.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author weiyi.wang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Executor implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        System.out.println("path:" + path);
        String type = watchedEvent.getType().name();
        System.out.println("type:" + type);
        String state = watchedEvent.getState().name();
        System.out.println("state:" + state);
    }
}
