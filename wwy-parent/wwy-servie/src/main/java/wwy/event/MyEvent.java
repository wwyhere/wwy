package wwy.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1002815320277254124L;
	
	private String methodName;

	public MyEvent(Object source) {
		super(source);
	}
	
	public MyEvent(Object source, String methodName){
		super(source);
        this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
