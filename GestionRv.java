import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionRV {
    private List<Patient> patients = new ArrayList<>();
    private List<RendezVous> rendezVousList = new ArrayList<>();

    public void ajouterPatient(String nomComplet, String tel) {
        Patient patient = new Patient(nomComplet, tel);
        patients.add(patient);
    }

    public void enregistrerRendezVous(String date, String heure, String motif, Etat etat, Specialite specialite, Patient patient) {
        RendezVous rendezVous = new RendezVous(date, heure, motif, etat, specialite, patient);
        rendezVousList.add(rendezVous);
    }

    public void listerRendezVous() {
        System.out.println("Liste des rendez-vous :");
        for (RendezVous rendezVous : rendezVousList) {
            System.out.println("Patient " + rendezVous.getPatient().getNumero() +
                    ", Date: " + rendezVous.getDate() +
                    ", Heure: " + rendezVous.getHeure() +
                    ", Motif: " + rendezVous.getMotif() +
                    ", État: " + rendezVous.getEtat() +
                    ", Spécialité: " + rendezVous.getSpecialite());
        }
    }

    public static void main(String[] args) {
        GestionRV gestionRV = new GestionRV();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un patient dans le tableau");
            System.out.println("2. Enregistrer un RV pour un patient");
            System.out.println("3. Lister tous les RV");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Nom complet du patient : ");
                    scanner.nextLine(); 
                    String nomComplet = scanner.nextLine();
                    System.out.print("Téléphone du patient : ");
                    String tel = scanner.nextLine();
                    gestionRV.ajouterPatient(nomComplet, tel);
                    break;
                case 2:
                    System.out.print("Date du rendez-vous (jj/mm/aaaa) : ");
                    String date = scanner.next();
                    System.out.print("Heure du rendez-vous (hh:mm) : ");
                    String heure = scanner.next();
                    System.out.print("Motif du rendez-vous : ");
                    scanner.nextLine(); 
                    String motif = scanner.nextLine();

                    System.out.println("Spécialités disponibles : Cardiologie, Ophtalmologie, Urologie");
                    System.out.print("Spécialité du rendez-vous : ");
                    String specialiteStr = scanner.nextLine();
                    Specialite specialite = Specialite.valueOf(specialiteStr.toUpperCase());

                    System.out.print("Numéro du patient : ");
                    int numeroPatient = scanner.nextInt();
                    Patient patient = patients.get(numeroPatient - 1);

                    System.out.println("États possibles : Encours, Valider, Annuler");
                    System.out.print("État du rendez-vous : ");
                    String etatStr = scanner.next();
                    Etat etat = Etat.valueOf(etatStr.toUpperCase());

                    gestionRV.enregistrerRendezVous(date, heure, motif, etat, specialite, patient);
                    break;

                case 3:
                    gestionRV.listerRendezVous();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}
