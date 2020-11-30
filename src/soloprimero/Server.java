package soloprimero;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	private static class ServerThreadFactory implements ThreadFactory {
		int numOfThreads = 1;
		
		@Override
		public Thread newThread(Runnable searchThread) {
			return new Thread(searchThread, String.format(Constantes.THREAD_NAME, numOfThreads++));
		}
		
	}
	

	private final ThreadPoolExecutor threadAdminPool = 
			(ThreadPoolExecutor) Executors.newFixedThreadPool((int)Runtime.getRuntime().availableProcessors());

	public ThreadPoolExecutor getThreadAdminPool() {
		return threadAdminPool;
	}

	public Server() {
		threadAdminPool.setThreadFactory(new ServerThreadFactory());
		threadAdminPool.setRejectedExecutionHandler((taskThread, poolExecutor) -> 
			System.out.println(String.format(Constantes.SEARCH_REJECTED, LocalDateTime.now().format(Constantes.TIME_FORMATTER), ((Thread) taskThread).getName())));
	}
	
    public void shutdown() throws InterruptedException {
        threadAdminPool.shutdown();
        if (threadAdminPool.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println(String.format(Constantes.ADMIN_SHUT_DOWN_COMPLETED, LocalDateTime.now().format(Constantes.TIME_FORMATTER), threadAdminPool.getLargestPoolSize()));
        } else {
            System.out.println(String.format(Constantes.ADMIN_SHUT_DOWN_TIMEOUT, LocalDateTime.now().format(Constantes.TIME_FORMATTER), threadAdminPool.getLargestPoolSize()));
        }
    }

    public void shutdownNow() throws InterruptedException {
        threadAdminPool.shutdownNow();
        if (threadAdminPool.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println(String.format(Constantes.ADMIN_SHUT_DOWN_COMPLETED, LocalDateTime.now().format(Constantes.TIME_FORMATTER), threadAdminPool.getLargestPoolSize()));
        } else {
            System.out.println(String.format(Constantes.ADMIN_SHUT_DOWN_TIMEOUT, LocalDateTime.now().format(Constantes.TIME_FORMATTER), threadAdminPool.getLargestPoolSize()));
        }
    }

}
