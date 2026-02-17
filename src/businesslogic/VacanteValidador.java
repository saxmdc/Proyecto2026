package businesslogic;

import persistence.Vacante;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VacanteValidador {

    private static final Set<String> CONTRATOS_VALIDOS =
            Set.of("Termino fijo", "Indefinido", "Prestacion de servicios", "Aprendizaje");

    public List<String> validar(Vacante v) {
        List<String> errores = new ArrayList<>();

        if (v == null) {
            errores.add("La vacante no puede ser nula.");
            return errores;
        }

        if (v.getIdVacante() <= 0) {
            errores.add("El idVacante debe ser mayor que 0.");
        }

        if (v.getCargo() == null || v.getCargo().isBlank()) {
            errores.add("El cargo es obligatorio.");
        }

        if (v.getCiudad() == null || v.getCiudad().isBlank()) {
            errores.add("La ciudad es obligatoria.");
        }

        if (v.getTipoContrato() == null || !CONTRATOS_VALIDOS.contains(v.getTipoContrato())) {
            errores.add("El tipo de contrato no es valido.");
        }

        if (v.getSalario() < 0) {
            errores.add("El salario no puede ser negativo.");
        }

        return errores;
    }

    public boolean esValido(Vacante v) {
        return validar(v).isEmpty();
    }
}
