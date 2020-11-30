package soloprimero;

import java.time.format.DateTimeFormatter;

public class Constantes {
	static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS");
	static final String ROW_NUMBER = "%d ";
	static final int MAX_SIZE_MATRIX_ROW_COLUMN = 5;
	static final String ADMIN_SHUT_DOWN_COMPLETED = "Time %s: Thread Administrator terminated. Max ThreadPoolSize = %d";
	static final String ADMIN_SHUT_DOWN_TIMEOUT = "Time %s: Termination timeout. Max ThreadPoolSize = %d";
	static final String ADMIN_SHUT_DOWN_INTERRUPTED = "Time %s: Thread Administrator could not terminate";
	static final String SEARCH_REJECTED = "Time: %s --- Search rejected: %s";
	static final String SEARCH_FAIL = "Time: %s --- Search failed --- Could not find number %d";
	static final String NUMBER_NOT_FOUND = "Time: %s --- %s Not found in row %d";
	static final String NUMBER_TO_SEARCH = "Time: %s --- Number to find: %d";
	static final String NUMBER_FOUND = "Time: %s --- %s Found in row %d";
	static final String THREAD_NAME = "Search-Thread-%d";
	static final String SEARCH_INTERRUPTED = "Time: %s --- %s --- Search interrupted in row %d";

}
