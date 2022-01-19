package es.caib.emiservbackoffice.api.externa.services;

import es.caib.emiservbackoffice.service.facade.UnitatOrganicaServiceFacade;
import es.caib.emiservbackoffice.service.model.Pagina;
import es.caib.emiservbackoffice.service.model.PaginaUnitatOrganica;
import es.caib.emiservbackoffice.service.model.UnitatOrganicaDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import javax.ws.rs.POST;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;




/**
 * Recurs REST per accedir a Unitats Organiques.
 *
 * @author areus
 */
@Path("SCDHPAJUv3")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SCDHPAJUv3Resource {

    //@EJB
    //private UnitatOrganicaServiceFacade unitatOrganicaService;

    /**
     * Retorna unta llista paginada de les unitats orgàniques.
     *
     * @return Un codi 200 amb les unitats orgàniques.
     */
    /*
    @GET
    @Operation(operationId = "getUnitats", summary = "Retorna una llista paginada d'unitats orgàniques")
    @APIResponse(
            responseCode = "200",
            description = "Llista d'unitats orgàniques",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PaginaUnitatOrganica.class)))
    public Response getUnitats(
            @Parameter(description = "Primer resultat, per defecte 0")
            @DefaultValue("0") @QueryParam("firstResult") int firstResult,
            @Parameter(description = "Nombre màxim de resultats, per defecte 10")
            @DefaultValue("10") @QueryParam("maxResult") int maxResult)  {
        Pagina<UnitatOrganicaDTO> pagina = unitatOrganicaService.findFiltered(firstResult, maxResult,
                Collections.emptyMap(), Collections.emptyList());
        return Response.ok().entity(pagina).build();
    }
    */
    
    /**
     * Crea una nova unitat orgànica.
     *
     * @param unitatOrganica la nova unitat orgànica a crear.
     * @return Un codi 201 amb la localització de la unitat orgància creada.
     */
    @POST
    @Operation(operationId = "peticionSincrona", summary = "Realitza una consulta al cedent")
    @APIResponse(responseCode = "200",
            description = "Petició processada",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UnitatOrganicaDTO.class)))
    
    
    
    
    @APIResponse(responseCode = "201", description = "Petició processada",
            headers = @Header(name = "location", description = "Enllaç al nou recurs",
                    schema = @Schema(type = SchemaType.STRING)))
    public Response peticionSincrona(
            @RequestBody(
                    required = true,
                    description = "DatosEspecificos",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DatosPersonales.class)))
            @NotNull @Valid UnitatOrganicaDTO unitatOrganica) {
        Long newId = unitatOrganicaService.create(unitatOrganica);
        return Response.created(URI.create("unitats/" + newId)).build();
    }
    
    
    
    
}
