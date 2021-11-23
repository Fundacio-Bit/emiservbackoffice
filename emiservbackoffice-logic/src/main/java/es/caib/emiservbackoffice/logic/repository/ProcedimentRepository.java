package es.caib.emiservbackoffice.logic.repository;

import es.caib.emiservbackoffice.persistence.model.Procediment;
import es.caib.emiservbackoffice.service.model.ProcedimentDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interfície de les operacions bàsiques sobre Procediments.
 * Són les generals per CRUD més les específiques per procediments.
 *
 * @author areus
 */
public interface ProcedimentRepository extends CrudRepository<Procediment, Long> {

    Optional<Procediment> findByCodiSia(String codiSia);

    List<ProcedimentDTO> findPagedByUnitat(int firstResult, int maxResult, Long idUnitat);

    long countByUnitat(Long idUnitat);
}
