package fr.amiensbc.Controllers;

import fr.amiensbc.Exceptions.ControllerException;
import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Facture;
import fr.amiensbc.services.FactureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/facture")
public class FactureController {
    @Autowired
    private FactureService factureService;

    @PostMapping
    @Operation(summary = "Créer une facture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La facture a été créée avec succès"),
            @ApiResponse(responseCode = "404", description = "La facture n'a pas pu être créée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la création de la facture")
    })
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) throws ControllerException {
        try {
            return ResponseEntity.ok(factureService.createFacture(facture));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la création de la facture", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupère une facture par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La facture a été récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune facture n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération de la facture par son id")
    })
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) throws ControllerException {
        try {
            return ResponseEntity.ok(factureService.getFactureById(id));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération de la facture par son id", e);
        }
    }


    @GetMapping
    @Operation(summary = "Récupère toutes les factures")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les factures ont été récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune facture n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération des factures")
    })
    public ResponseEntity<List<Facture>> getAllFactures() throws ControllerException {
        try {
            return ResponseEntity.ok(factureService.getAllFactures());
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération des factures", e);
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime une facture par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La facture a été supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune facture n'a été trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la suppression de la facture")
    })
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) throws ControllerException {
        try {
            factureService.deleteFacture(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la suppression de la facture", e);
        }
    }

}
