package businesslogic;

import persistence.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class UsuarioValidador {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    private static final Set<String> ROLES_VALIDOS =
            Set.of("Admin", "Moderador", "Aspirante");

    public List<String> validar(Usuario u) {
        List<String> errores = new ArrayList<>();

        if (u == null) {
            errores.add("El usuario no puede ser nulo.");
            return errores;
        }

        if (u.getIdUsuario() <= 0) {
            errores.add("El idUsuario debe ser mayor que 0.");
        }

        if (u.getNombre() == null || u.getNombre().isBlank() || u.getNombre().length() < 3) {
            errores.add("El nombre es obligatorio y debe tener al menos 3 caracteres.");
        }

        if (u.getCorreo() == null || !EMAIL_PATTERN.matcher(u.getCorreo()).matches()) {
            errores.add("El correo no tiene un formato valido.");
        }

        if (u.getEdad() < 18) {
            errores.add("La edad debe ser mayor o igual a 18.");
        }

        if (u.getRol() == null || !ROLES_VALIDOS.contains(u.getRol())) {
            errores.add("El rol no es valido.");
        }

        return errores;
    }

    public boolean esValido(Usuario u) {
        return validar(u).isEmpty();
    }
}
