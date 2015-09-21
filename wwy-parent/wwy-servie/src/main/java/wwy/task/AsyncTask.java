package wwy.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;

/**
 * 
 * @author wwy
 * @date 2015年6月14日上午11:15:54
 */
public class AsyncTask {
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ListenableFutureTask<String> task = new ListenableFutureTask<String>(new Callable() {
            
            @Override
            public Object call() throws Exception {
                Thread.sleep(4 * 1000L);
                System.out.println("=======task execute");
                return "hello";
            }
        });
        
        task.addCallback(new ListenableFutureCallback<String>() {
            
            @Override
            public void onSuccess(String result) {
                System.out.println("===success callback 1");
            }
            
            @Override
            public void onFailure(Throwable t) {
            }
        });
        
        task.addCallback(new ListenableFutureCallback<String>() {
            
            @Override
            public void onSuccess(String result) {
                System.out.println("===success callback 2");
            }
            
            @Override
            public void onFailure(Throwable t) {
            }
        });
        System.out.println("开始执行异步任务!");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        String result = task.get();
        System.out.println(result);
        executorService.shutdown();
    }
}
