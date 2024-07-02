package fr.amiensbc.Controllers;


import fr.amiensbc.beans.Licence;
import fr.amiensbc.Exceptions.ControllerException;
import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.services.LicenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/licence")
public class LicenceController {

    @Autowired
    private LicenceService licenceService;

    @PostMapping
    @Operation(summary = "Créer une licence")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La licence a été créée avec succès"),
            @ApiResponse(responseCode = "404", description = "La licence n'a pas pu être créée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la création de la licence")
    })
    public ResponseEntity<Licence> createLicence(@RequestBody Licence licence) throws ControllerException {
        try {
            return ResponseEntity.ok(licenceService.createLicence(licence));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la création de la licence", e);
        }
    }


    @GetMapping("/{id}")
    @Operation(summary = "Récupère une licence par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La licence a été récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune licence n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération de la licence par son id")
    })
    public ResponseEntity<Licence> getLicenceById(@PathVariable Long id) throws ControllerException {
        try {
            return ResponseEntity.ok(licenceService.getLicenceById(id));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération de la licence par son id", e);
        }
    }


    @GetMapping
    @Operation(summary = "Récupère toutes les licences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les licences ont été récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune licence n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération des licences")
    })
    public ResponseEntity<List<Licence>> getAllLicences() throws ControllerException {
        try {
            return ResponseEntity.ok(licenceService.getAllLicences());
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération des licences", e);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une licence par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La licence a été supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune licence n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la suppression de la licence")
    })
    public ResponseEntity<Void> deleteLicence(@PathVariable Long id) throws ControllerException {
        try {
            licenceService.deleteLicence(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la suppression de la licence", e);
        }
    }

}
