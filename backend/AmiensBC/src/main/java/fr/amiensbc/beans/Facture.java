package fr.amiensbc.beans;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Table(name = "facture")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Schema(description = "Description d'une facture d'une licence pour un utilisateur")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    @Column(name = "id")
    private Long id;

    @Schema(description = "Date d'émission de la facture", example = "2021-01-01")
    @Column(name = "date_emission")
    private Date dateEmission;

    @Schema(description = "Montant de la facture", example = "100.0")
    @Column(name = "montant")
    private String detailsPaiement;

    @Schema(description = "PDF stocké en base 64", example = "%PDF-test")
    @Column(name = "pdf_facture")
    private String pdfFacture;

    @OneToOne
    @JoinColumn(name = "id_licence")
    @Schema(description = "Licence associée à la facture")
    private Licence licence;
}
