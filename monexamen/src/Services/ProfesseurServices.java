package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Classe;
import Entities.Professeur;
import Entities.ProfesseurClasse;
import Repositories.ProfesseurClasseRepository;
import Repositories.ProfesseurRepository;

public class ProfesseurServices {
    ProfesseurRepository professeurRepository = new ProfesseurRepository();
    ProfesseurClasseRepository professeurClasseRepository = new ProfesseurClasseRepository();

    public List<Professeur> listerProfesseurs() {
        return professeurRepository.selectAll();
    }

    public void AjouterProf(Professeur professeur) {
        professeurRepository.AjouterProf(professeur);
    }

    public void ajouterProfesseurClasse(ProfesseurClasse professeurClasse) {
        professeurClasseRepository.insert(professeurClasse);
    }

    public void AjouterProfClasse(ProfesseurClasse professeurClasse) {
        professeurClasseRepository.AjouterProfClasse(professeurClasse);
    }

    public Professeur rechercheProfesseurParId(int id) {
        return professeurRepository.selectProfById(id);
    }

    // Nouvelle méthode pour lister les professeurs d'une classe par libellé
    public List<Professeur> listerProfesseursParClasse(String libelleClasse) {
        return professeurClasseRepository.selectProfesseursByClasseLibelle(libelleClasse);
    }
}

    

