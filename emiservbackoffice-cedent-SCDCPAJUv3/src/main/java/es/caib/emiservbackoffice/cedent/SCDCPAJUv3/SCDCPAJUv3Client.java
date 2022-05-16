package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Adapter entorn al client del servei de verificació d'identitat.
 */
@ApplicationScoped
public class SCDCPAJUv3Client {

    private static final Logger LOG = LoggerFactory.getLogger(SCDCPAJUv3Client.class);

    @Inject
    private Configuracio configuracio;

    //private ScdcpajUv3Api clientScdcpajUv3Api;

    @PostConstruct
    protected void init() {
        LOG.info("Iniciant client");
        
//        ScdcpajUv3Api clientScdcpajUv3Api;
//        
//        JacksonJsonProvider provider = new JacksonJsonProvider();
//        List providers = new ArrayList();
//        providers.add(provider);
//        
//        String path = "/SCDCPAJU/peticionSincrona";
//        String baseURI = configuracio.getEndpoint().concat(path);
//        
//        // Replace 'user' and 'password' by the actual values
//        String userpass = configuracio.getUsuari().concat(":").concat(configuracio.getSecret());
//        String authorizationHeader = "Basic "
//        + org.apache.cxf.common.util.Base64Utility.encode(userpass.getBytes());
//        
//        
//        clientScdcpajUv3Api = JAXRSClientFactory.create(baseURI, ScdcpajUv3Api.class, providers);
//        org.apache.cxf.jaxrs.client.Client client = WebClient.client(clientScdcpajUv3Api).authorization(authorizationHeader);
//        
//        ClientConfiguration config = WebClient.getConfig(client); 
        
        LOG.info("Client creat");
        
        
        
    }

    public Resultado peticioSincrona(Solicitud solicitud) throws IOException {
        
        //return clientScdcpajUv3Api.peticionSincrona(solicitud);
        return null;
        
    }


}
