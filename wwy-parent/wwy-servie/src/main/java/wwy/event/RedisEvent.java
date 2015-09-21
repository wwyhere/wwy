package wwy.event;

import org.springframework.context.ApplicationEvent;

public class RedisEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4275202276072580804L;
	private String channel;
	private String msg;

	public RedisEvent(Object source,String channel,String msg) {
		super(source);
		this.channel=channel;
		this.msg=msg;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
