package fr.amiensbc.services;

import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Utilisateur;
import fr.amiensbc.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Crée un utilisateur
     * @param utilisateur
     * @return
     * @throws ServiceException
     */
    public Utilisateur createUtilisateur(Utilisateur utilisateur) throws ServiceException {
        try {
            return utilisateurRepository.save(utilisateur);
        } catch (Exception e) {
            throw new ServiceException("Error creating Utilisateur", e);
        }
    }

    /**
     * Réupère tous les utilisateurs
     * @return
     * @throws ServiceException
     */
    public List<Utilisateur> getAllUtilisateurs() throws ServiceException {
        try {
            return utilisateurRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all Utilisateurs", e);
        }
    }

    /**
     * Récupère un utilisateur par son id
     * @param id
     * @return
     * @throws ServiceException
     */
    public Utilisateur getUtilisateurById(Long id) throws ServiceException {
        try {
            return utilisateurRepository.findById(id).orElseThrow(() -> new ServiceException("Utilisateur not found"));
        } catch (Exception e) {
            throw new ServiceException("Error fetching Utilisateur by id", e);
        }
    }

    /**
     * Supprime un utilisateur
     * @param id
     * @return
     * @throws ServiceException
     */
    public void deleteUtilisateur(Long id) throws ServiceException {
        try {
            utilisateurRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error deleting Utilisateur", e);
        }
    }
}
