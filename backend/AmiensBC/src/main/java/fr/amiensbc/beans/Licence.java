package fr.amiensbc.beans;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Table(name = "licence")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Schema(description = "Description d'une licence de boxe d'un utilisateur")
public class Licence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "id")
    private Long id;

    @Schema(description = "Type de la licence", examples = {"Loisir/Débutant", "Amateur", "HandiBoxe"})
    @Column(name = "type")
    private String type;

    @Schema(description = "Date de début de la licence", example = "2021-01-01")
    @Column(name = "date_debut")
    private Date dateDebut;

    @Schema(description = "Date de fin de la licence", example = "2022-01-01")
    @Column(name = "date_fin")
    private Date dateFin;

}
