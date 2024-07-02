package fr.amiensbc.Controllers;

import fr.amiensbc.Exceptions.ControllerException;
import fr.amiensbc.Exceptions.ServiceException;
import fr.amiensbc.beans.Utilisateur;
import fr.amiensbc.services.UtilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    @Operation(summary = "Créer un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a été créé avec succès"),
            @ApiResponse(responseCode = "404", description = "L'utilisateur n'a pas pu être créé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la création de l'utilisateur")
    })
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) throws ControllerException {
        try {
            return ResponseEntity.ok(utilisateurService.createUtilisateur(utilisateur));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la création de l'utilisateur", e);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupère un utilisateur par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a été récupéré avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun utilisateur n'a été trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération de l'utilisateur par son id")
    })
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) throws ControllerException {
        try {
            return ResponseEntity.ok(utilisateurService.getUtilisateurById(id));
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération de l'utilisateur par son id", e);
        }
    }


    @GetMapping
    @Operation(summary = "Récupère tous les utilisateurs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Les utilisateurs ont été récupérés avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun utilisateur n'a été trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la récupération des utilisateurs")
    })
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() throws ControllerException {
        try {
            return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la récupération des utilisateurs", e);
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Supprime un utilisateur par son id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'utilisateur a été supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucun utilisateur n'a été trouvé"),
            @ApiResponse(responseCode = "500", description = "Erreur lors de la suppression de l'utilisateur")
    })
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) throws ControllerException {
        try {
            utilisateurService.deleteUtilisateur(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            throw new ControllerException("Erreur lors de la suppression de l'utilisateur", e);
        }
    }
}
