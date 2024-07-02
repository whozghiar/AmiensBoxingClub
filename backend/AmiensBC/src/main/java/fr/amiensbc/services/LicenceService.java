package fr.amiensbc.services;


import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Licence;
import fr.amiensbc.repositories.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LicenceService {

    @Autowired
    private LicenceRepository licenceRepository;

    /**
     * Crée une licence
     * @param licence
     * @return
     * @throws ServiceException
     */
    public Licence createLicence(Licence licence) throws ServiceException {
        try {
            return licenceRepository.save(licence);
        } catch (Exception e) {
            throw new ServiceException("Error creating Licence", e);
        }
    }

    /**
     * Réupère toutes les licences
     * @return
     * @throws ServiceException
     */
    public List<Licence> getAllLicences() throws ServiceException {
        try {
            return licenceRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all Licences", e);
        }
    }

    /**
     * Récupère une licence par son id
     * @param id
     * @return
     * @throws ServiceException
     */
    public Licence getLicenceById(Long id) throws ServiceException {
        try {
            return licenceRepository.findById(id).orElseThrow(() -> new ServiceException("Licence not found"));
        } catch (Exception e) {
            throw new ServiceException("Error fetching Licence by id", e);
        }
    }

    /**
     * Supprime une licence par son id
     * @param id
     * @throws ServiceException
     */
    public void deleteLicence(Long id) throws ServiceException {
        try {
            licenceRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error deleting Licence", e);
        }
    }
}
