
import businesslogic.Reportevalidador;
import businesslogic.UsuarioValidador;
import businesslogic.VacanteValidador;
import persistence.Reporte;
import persistence.Usuario;
import persistence.Vacante;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int opcion;

        do {
            String menu = """
                    ===== WORK IN - MENU =====
                    1. Validar Reporte
                    2. Validar Usuario
                    3. Validar Vacante
                    0. Salir
                    """;

            opcion = leerEntero(menu, "Menú principal");

            switch (opcion) {
                case 1 -> formularioReporte();
                case 2 -> formularioUsuario();
                case 3 -> formularioVacante();
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ----------------- FORMULARIO REPORTE -----------------
    private static void formularioReporte() {
        int idReporte = leerEntero("ID Reporte:", "Reporte");
        String titulo = leerTexto("Título:", "Reporte");
        String descripcion = leerTexto("Descripción:", "Reporte");
        String categoria = leerTexto("Categoría (Fraude / Soporte / Inconsistencia / Sugerencia):", "Reporte");
        String estado = leerTexto("Estado (Abierto / En revision / Cerrado):", "Reporte");
        int prioridad = leerEntero("Prioridad (1 a 5):", "Reporte");
        int idUsuarioReporta = leerEntero("ID Usuario que reporta:", "Reporte");

        Reporte reporte = new Reporte(
                idReporte,
                titulo,
                descripcion,
                categoria,
                estado,
                prioridad,
                LocalDateTime.now(),
                idUsuarioReporta
        );

        Reportevalidador validador = new Reportevalidador();
        List<String> errores = validador.validar(reporte);

        mostrarResultado("Reporte", errores);
    }

    // ----------------- FORMULARIO USUARIO -----------------
    private static void formularioUsuario() {
        int idUsuario = leerEntero("ID Usuario:", "Usuario");
        String nombre = leerTexto("Nombre:", "Usuario");
        String correo = leerTexto("Correo:", "Usuario");
        int edad = leerEntero("Edad:", "Usuario");
        String rol = leerTexto("Rol (Admin / Moderador / Aspirante):", "Usuario");

        Usuario usuario = new Usuario(idUsuario, nombre, correo, edad, rol);

        UsuarioValidador validador = new UsuarioValidador();
        List<String> errores = validador.validar(usuario);

        mostrarResultado("Usuario", errores);
    }

    // ----------------- FORMULARIO VACANTE -----------------
    private static void formularioVacante() {
        int idVacante = leerEntero("ID Vacante:", "Vacante");
        String cargo = leerTexto("Cargo:", "Vacante");
        String ciudad = leerTexto("Ciudad:", "Vacante");
        String tipoContrato = leerTexto(
                "Tipo de contrato (Termino fijo / Indefinido / Prestacion de servicios / Aprendizaje):",
                "Vacante"
        );
        double salario = leerDouble("Salario:", "Vacante");
        boolean primerEmpleo = leerBoolean("¿Es primer empleo? (true/false):", "Vacante");

        Vacante vacante = new Vacante(idVacante, cargo, ciudad, tipoContrato, salario, primerEmpleo);

        VacanteValidador validador = new VacanteValidador();
        List<String> errores = validador.validar(vacante);

        mostrarResultado("Vacante", errores);
    }

    // ----------------- UTILIDADES DE ENTRADA -----------------
    private static String leerTexto(String mensaje, String titulo) {
        while (true) {
            String valor = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

            // Si cancela
            if (valor == null) {
                int r = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas cancelar esta operación?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION
                );
                if (r == JOptionPane.YES_OPTION) {
                    return "";
                }
                continue;
            }

            return valor.trim();
        }
    }

    private static int leerEntero(String mensaje, String titulo) {
        while (true) {
            String valor = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

            if (valor == null) {
                return -1; // valor sentinela por cancelación
            }

            try {
                return Integer.parseInt(valor.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje, String titulo) {
        while (true) {
            String valor = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

            if (valor == null) {
                return -1;
            }

            try {
                return Double.parseDouble(valor.trim().replace(",", "."));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número decimal válido.");
            }
        }
    }

    private static boolean leerBoolean(String mensaje, String titulo) {
        while (true) {
            String valor = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

            if (valor == null) {
                return false;
            }

            valor = valor.trim().toLowerCase();
            if (valor.equals("true")) return true;
            if (valor.equals("false")) return false;

            JOptionPane.showMessageDialog(null, "Escribe exactamente: true o false");
        }
    }

    // ----------------- SALIDA DE RESULTADOS -----------------
    private static void mostrarResultado(String entidad, List<String> errores) {
        if (errores.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "✅ " + entidad + " válido.",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            StringBuilder sb = new StringBuilder("❌ Se encontraron errores en " + entidad + ":\n\n");
            for (String error : errores) {
                sb.append("- ").append(error).append("\n");
            }

            JOptionPane.showMessageDialog(
                    null,
                    sb.toString(),
                    "Resultado de validación",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
