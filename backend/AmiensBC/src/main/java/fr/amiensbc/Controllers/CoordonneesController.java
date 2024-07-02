package fr.amiensbc.Controllers;


import fr.amiensbc.Exceptions.ControllerException;
import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Coordonnees;
import fr.amiensbc.services.CoordonneesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/coordonnees")
public class CoordonneesController {

    @Autowired
    private CoordonneesService coordonneesService;

    @PostMapping
    @Operation(summary = "Créer un groupement de coordonnées")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le groupement de coordonnées a été créé avec succès"),
            @ApiResponse(responseCode = "404", description = "Le groupement de coordonnées n'a pas pu être créé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la création du groupement de coordonnées")
    })
    public ResponseEntity<Coordonnees> createCoordonnees(@RequestBody Coordonnees coordonnees) throws ControllerException {
        try {
            return ResponseEntity.ok(coordonneesService.createCoordonnees(coordonnees));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la création du groupement de coordonnées", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupère un groupement de coordonnées par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le groupement de coordonnées a été récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun groupement de coordonnées n'a été trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération du groupement de coordonnées par son id")
    })
    public ResponseEntity<Coordonnees> getCoordonneesById(@PathVariable Long id) throws ControllerException {
        try {
            return ResponseEntity.ok(coordonneesService.getCoordonneesById(id));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération du groupement de coordonnées par son id", e);
        }
    }



    @Operation(summary = "Récupère toutes les coordonnées")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les coordonnées ont été récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune coordonnée n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération de tous les groupements de coordonnées")
    })
    @GetMapping
    public ResponseEntity<List<Coordonnees>> getAllCoordonnees() throws ControllerException {
        try {
            return ResponseEntity.ok(coordonneesService.getAllCoordonnees());
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération de tous les groupements de coordonnées", e);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un groupement de coordonnées par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Le groupement de coordonnées a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun groupement de coordonnées n'a été trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la suppression du groupement de coordonnées")
    })
    public ResponseEntity<Void> deleteCoordonnees(@PathVariable Long id) throws ControllerException {
        try {
            coordonneesService.deleteCoordonnees(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la suppression du groupement de coordonnées", e);
        }
    }
}
