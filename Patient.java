public class Patient {
    private String nomComplet;
    private String tel;
    private String numero;

    public Patient(String nomComplet, String tel) {
        this.nomComplet = nomComplet;
        this.tel = tel;
        this.numero = "PAT" + String.format("%04d", ++patientCount);
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getTel() {
        return tel;
    }

    public String getNumero() {
        return numero;
    }
}
