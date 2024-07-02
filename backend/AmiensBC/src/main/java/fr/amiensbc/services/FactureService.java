package fr.amiensbc.services;

import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Facture;

import fr.amiensbc.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    /**
     * Crée une facture
     * @param facture
     * @return
     * @throws ServiceException
     */
    public Facture createFacture(Facture facture) throws ServiceException {
        try {
            return factureRepository.save(facture);
        } catch (Exception e) {
            throw new ServiceException("Error creating Facture", e);
        }
    }

    /**
     * Réupère toutes les factures
     * @return
     * @throws ServiceException
     */
    public List<Facture> getAllFactures() throws ServiceException {
        try {
            return factureRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all Factures", e);
        }
    }

    /**
     * Récupère une facture par son id
     * @param id
     * @return
     * @throws ServiceException
     */
    public Facture getFactureById(Long id) throws ServiceException {
        try {
            return factureRepository.findById(id).orElseThrow(() -> new ServiceException("Facture not found"));
        } catch (Exception e) {
            throw new ServiceException("Error fetching Facture by id", e);
        }
    }

    /**
     * Supprime une facture par son id
     * @param id
     * @throws ServiceException
     */
    public void deleteFacture(Long id) throws ServiceException {
        try {
            factureRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error deleting Facture", e);
        }
    }
}
