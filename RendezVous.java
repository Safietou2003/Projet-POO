public class RendezVous {
    private String date;
    private String heure;
    private String motif;
    private Etat etat;
    private Specialite specialite;
    private Patient patient;

    public RendezVous(String date, String heure, String motif, Etat etat, Specialite specialite, Patient patient) {
        this.date = date;
        this.heure = heure;
        this.motif = motif;
        this.etat = etat;
        this.specialite = specialite;
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getMotif() {
        return motif;
    }

    public Etat getEtat() {
        return etat;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public Patient getPatient() {
        return patient;
    }
}
