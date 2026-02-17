package persistence;

public class Vacante {
    private int idVacante;
    private String cargo;
    private String ciudad;
    private String tipoContrato; // Termino fijo, Indefinido, Prestacion de servicios, Aprendizaje
    private double salario;
    private boolean primerEmpleo;

    public Vacante() {
    }

    public Vacante(int idVacante, String cargo, String ciudad, String tipoContrato, double salario, boolean primerEmpleo) {
        this.idVacante = idVacante;
        this.cargo = cargo;
        this.ciudad = ciudad;
        this.tipoContrato = tipoContrato;
        this.salario = salario;
        this.primerEmpleo = primerEmpleo;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isPrimerEmpleo() {
        return primerEmpleo;
    }

    public void setPrimerEmpleo(boolean primerEmpleo) {
        this.primerEmpleo = primerEmpleo;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "idVacante=" + idVacante +
                ", cargo='" + cargo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", tipoContrato='" + tipoContrato + '\'' +
                ", salario=" + salario +
                ", primerEmpleo=" + primerEmpleo +
                '}';
    }
}
