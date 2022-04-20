package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Adapter entorn al client del servei de verificació d'identitat.
 */
@ApplicationScoped
public class ClientServeiVerificacioIdentitat {

    private static final Logger LOG = LoggerFactory.getLogger(ClientServeiVerificacioIdentitat.class);

    @Inject
    private Configuracio configuracio;

    private ScdcpajUv3Api clientScdcpajUv3Api;;

    @PostConstruct
    protected void init() {
        LOG.info("Iniciant client");
        clientScdcpajUv3Api = new ScdcpajUv3Api(
                configuracio.getEndpoint(),
                configuracio.getUsuari(),
                configuracio.getSecret());
        LOG.info("Client creat");
    }

    public ScspRespuesta peticioSincrona(ClientSvddgpviws02.SolicitudSvddgpviws02... solicituds) throws IOException {
        return clientSvddgpviws02.peticionSincrona(List.of(solicituds));
    }

    public ScspJustificante getJustificant(String idPeticio) throws IOException {
        return clientSvddgpviws02.getJustificante(idPeticio);
    }

}
