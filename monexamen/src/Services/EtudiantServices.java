package Services;

import java.util.List;

import Entities.Etudiant;
import Entities.EtudiantClasse;
import Entities.Professeur;
import Entities.ProfesseurClasse;
import Repositories.EtudiantClasseRepository;
import Repositories.EtudiantRepository;

public class EtudiantServices {
    EtudiantRepository etudiantRepository= new EtudiantRepository();
    EtudiantClasseRepository etudiantClasseRepository = new EtudiantClasseRepository();

    public List<Etudiant>listerEtudiant(){
        return etudiantRepository.selectAll();
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
        
        Etudiant etudiantInsere = etudiantRepository.selectEtudiantBYMatri(etudiant.getMatri());
        
        if (etudiantInsere != null) {
            return etudiantInsere;
        } else {
            return null;
        }
    }
    

    public Etudiant rechercheEtudiantParMatri(String matri){
        return etudiantRepository.selectEtudiantBYMatri(matri);
    }

    
     public void ajouterEtudiantClasse(EtudiantClasse etudiantClasse) {
        etudiantClasseRepository.insert(etudiantClasse);
    }

     public Etudiant rechercheEtudiantParId(int id){
        return etudiantRepository.selectEtudiantById(id);
    }

    public List<Etudiant> listerEtudiantParClasse(String libelle){
        return etudiantClasseRepository.selectEtudiantByClasse(libelle);
    }
}
