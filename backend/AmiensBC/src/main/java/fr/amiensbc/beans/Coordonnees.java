package fr.amiensbc.beans;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "coordonnees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Schema(description = "Description des coordonnées d'un utilisateur")
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "id")
    private Long id;

    @Schema(description = "Adresse de l'utilisateur", example = "1 rue de la paix")
    @Column(name = "adresse")
    private String adresse;

    @Schema(description = "Code postal de l'utilisateur", example = "80000")
    @Column(name = "code_postal")
    private String codePostal;

    @Schema(description = "Ville de l'utilisateur", example = "Amiens")
    @Column(name = "ville")
    private String ville;

    @Schema(description = "Téléphone de l'utilisateur", example = "0322334455")
    @Column(name = "telephone")
    private String telephone;

    @Schema(description = "Email de l'utilisateur", example = "john.doe@mail.com")
    @Column(name = "email")
    private String email;

}
