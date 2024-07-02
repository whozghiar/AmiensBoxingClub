package fr.amiensbc.services;

import fr.amiensbc.Exceptions.ServiceException;

import fr.amiensbc.beans.Coordonnees;

import fr.amiensbc.repositories.CoordonneesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordonneesService {

    @Autowired
    private CoordonneesRepository coordonneesRepository;

    /**
     * Créer un groupement de coordonnées
     * @param coordonnees
     * @return
     * @throws ServiceException
     */
    public Coordonnees createCoordonnees(Coordonnees coordonnees) throws ServiceException {
        try {
            return coordonneesRepository.save(coordonnees);
        } catch (Exception e) {
            throw new ServiceException("Error creating Coordonnees", e);
        }
    }

    /**
     * Réupérer tous les groupements de coordonnées
     * @return
     * @throws ServiceException
     */
    public List<Coordonnees> getAllCoordonnees() throws ServiceException {
        try {
            return coordonneesRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all Coordonnees", e);
        }
    }

    /**
     * Récupérer un groupement de coordonnées par son id
     * @param id
     * @return
     * @throws ServiceException
     */
    public Coordonnees getCoordonneesById(Long id) throws ServiceException {
        try {
            return coordonneesRepository.findById(id).orElseThrow(() -> new ServiceException("Coordonnees not found"));
        } catch (Exception e) {
            throw new ServiceException("Error fetching Coordonnees by id", e);
        }
    }

    /**
     * Supprimer un groupement de coordonnées par son id
     * @param id
     * @throws ServiceException
     */
    public void deleteCoordonnees(Long id) throws ServiceException {
        try {
            coordonneesRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error deleting Coordonnees", e);
        }
    }
}
