package es.caib.scsp.api.cedent.client.SCDCPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * SCDCPAJUv3
 *
 * <p># This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 */
@Path("/")
public interface ScdcpajUv3Api  {

    /**
     * Realitza una consulta al cedent
     *
     * Realitza una consulta al cedent
     *
     */
    @POST
    @Path("/SCDCPAJUv3/peticionSincrona")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Realitza una consulta al cedent", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Petició processada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Resultado.class))),
        @ApiResponse(responseCode = "400", description = "Petició errònia", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))) })
    public Resultado peticionSincrona(Solicitud body);
}
