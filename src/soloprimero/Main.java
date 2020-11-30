package soloprimero;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import soloprimero.Constantes;
public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		List<Buscador> matriz = new ArrayList<Buscador>();
		int fila;
		int numero = new Random().nextInt(10) + 1;
		
		for (int i = 0; i < Constantes.MAX_SIZE_MATRIX_ROW_COLUMN; i++) {
			matriz.add(new Buscador(i, numero));
		}
        
        try {
        	System.out.println(String.format(Constantes.NUMBER_TO_SEARCH, LocalDateTime.now().format(Constantes.TIME_FORMATTER), numero));
        	fila = server.getThreadAdminPool().invokeAny(matriz);
        } catch (ExecutionException e) {
        	System.out.println(String.format(Constantes.SEARCH_FAIL, LocalDateTime.now().format(Constantes.TIME_FORMATTER), numero));
        } catch (InterruptedException e) {
		}
        
        try {
            server.shutdown();
        } catch (InterruptedException e) {
        	System.out.println(String.format(Constantes.ADMIN_SHUT_DOWN_INTERRUPTED, LocalDateTime.now().format(Constantes.TIME_FORMATTER)));
            return;
        }

	}

}
