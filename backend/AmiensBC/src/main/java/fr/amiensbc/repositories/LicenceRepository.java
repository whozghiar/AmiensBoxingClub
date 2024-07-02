package fr.amiensbc.repositories;

import fr.amiensbc.beans.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenceRepository extends JpaRepository<Licence, Long> {
}