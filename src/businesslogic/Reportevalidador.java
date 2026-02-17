package businesslogic;

import persistence.Reporte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Reportevalidador {

    private static final Set<String> CATEGORIAS_VALIDAS =
            Set.of("Fraude", "Soporte", "Inconsistencia", "Sugerencia");

    private static final Set<String> ESTADOS_VALIDOS =
            Set.of("Abierto", "En revision", "Cerrado");

    public List<String> validar(Reporte r) {
        List<String> errores = new ArrayList<>();

        if (r == null) {
            errores.add("El reporte no puede ser nulo.");
            return errores;
        }

        if (r.getIdReporte() <= 0) {
            errores.add("El idReporte debe ser mayor que 0.");
        }

        if (r.getTitulo() == null || r.getTitulo().isBlank() || r.getTitulo().length() < 5) {
            errores.add("El titulo es obligatorio y debe tener al menos 5 caracteres.");
        }

        if (r.getDescripcion() == null || r.getDescripcion().isBlank() || r.getDescripcion().length() < 10) {
            errores.add("La descripcion es obligatoria y debe tener al menos 10 caracteres.");
        }

        if (r.getCategoria() == null || !CATEGORIAS_VALIDAS.contains(r.getCategoria())) {
            errores.add("La categoria no es valida.");
        }

        if (r.getEstado() == null || !ESTADOS_VALIDOS.contains(r.getEstado())) {
            errores.add("El estado no es valido.");
        }

        if (r.getPrioridad() < 1 || r.getPrioridad() > 5) {
            errores.add("La prioridad debe estar entre 1 y 5.");
        }

        if (r.getFechaCreacion() == null) {
            errores.add("La fecha de creacion es obligatoria.");
        } else if (r.getFechaCreacion().isAfter(LocalDateTime.now())) {
            errores.add("La fecha de creacion no puede estar en el futuro.");
        }

        if (r.getIdUsuarioReporta() <= 0) {
            errores.add("El idUsuarioReporta debe ser mayor que 0.");
        }

        return errores;
    }

    public boolean esValido(Reporte r) {
        return validar(r).isEmpty();
    }
}
