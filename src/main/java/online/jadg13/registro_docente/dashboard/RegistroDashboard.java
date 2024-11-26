package online.jadg13.registro_docente.dashboard;

import org.openxava.annotations.*;
import org.openxava.jpa.XPersistence;

import java.util.Collection;
import java.util.List;

@View(members =
        "estadisticasDocentes[" +
                "totalDocentes, totalCarreras; titulosDocentes" +
                "];" +
                "detallePorCarrera[totalDocentesPorCarrera]")
public class RegistroDashboard {

    /** Total de docentes */
    @LargeDisplay(icon = "account")
    @Stereotype("LINK")
    public String getTotalDocentes() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select count(*) from Docente")
                .getSingleResult();
        return "<strong>Total de <a href='Docente' style='text-decoration:none;'>Docentes:</strong> </a> " + total ;
    }

    /** Total de carreras */
    @LargeDisplay(icon = "folder")
    public String getTotalCarreras() {
        return "<strong>Total de Carreras:</strong> " +
                XPersistence.getManager().createQuery("select count(*) from Carrera")
                        .getSingleResult().toString();
    }

    /*Titulos de docentes*/
    @LargeDisplay(icon = "book")
    public String getTitulosDocentes() {
        return "<strong>Total de Titulos:</strong> " +
                XPersistence.getManager().createQuery("select count(distinct titulo) from Docente")
                        .getSingleResult().toString();
    }

    /** Total de docentes por carrera */
    @Stereotype("HTML_TEXT")
    public String getTotalDocentesPorCarrera() {
        List<Object[]> resultados = XPersistence.getManager()
                .createQuery("select c.nombre, count(d) from Docente d join d.carrera c group by c.nombre", Object[].class)
                .getResultList();

        StringBuilder tabla = new StringBuilder("<table style='width:100%;border-collapse:collapse;'>");
        tabla.append("<tr style='background-color:#f4f4f4;'><th style='text-align:left;padding:8px;'>Carrera</th><th style='text-align:right;padding:8px;'>Total Docentes</th></tr>");

        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            Long totalDocentes = (Long) fila[1];
            tabla.append("<tr>")
                    .append("<td style='padding:8px;'>").append(nombreCarrera).append("</td>")
                    .append("<td style='text-align:right;padding:8px;'>").append(totalDocentes).append("</td>")
                    .append("</tr>");
        }
        tabla.append("</table>");
        return tabla.toString();
    }



}
