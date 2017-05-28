package IO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandleExcutePool {
	
	private ExecutorService excutor;

	public TimeServerHandleExcutePool() {
	}
	//����߳����������Ϣ����
	public TimeServerHandleExcutePool(int maxPoolSize,int queueSize){
		excutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
				maxPoolSize, 120L, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(queueSize));
	}
	public void excute(Runnable task){
		excutor.execute(task);
	}
	
	

}
