package online.jadg13.registro_docente.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicación.
 *
 * Con OpenXava Studio/Eclipse: Botón derecho del ratón > Run As > Java Application
 */

public class registro_docente {

	public static void main(String[] args) throws Exception {
		DBServer.start("registro_docente-db"); // Para usar tu propia base de datos comenta esta línea y configura src/main/webapp/META-INF/context.xml
		AppServer.run("registro_docente"); // Usa AppServer.run("") para funcionar en el contexto raíz
	}

}
