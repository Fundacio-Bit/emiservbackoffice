# SCDCPAJUv3-api-cedent-client

SCDCPAJUv3
- API version: 1.0.0

# This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>es.caib.scsp</groupId>
  <artifactId>SCDCPAJUv3-api-cedent-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "es.caib.scsp:SCDCPAJUv3-api-cedent-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/SCDCPAJUv3-api-cedent-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.*;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.auth.*;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.*;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;

import java.io.File;
import java.util.*;

public class ScdcpajUv3ApiExample {

    public static void main(String[] args) {
        
        ScdcpajUv3Api apiInstance = new ScdcpajUv3Api();
        Solicitud body = new Solicitud(); // Solicitud | Dades de la consulta
        try {
            Resultado result = apiInstance.peticionSincrona(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScdcpajUv3Api#peticionSincrona");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *http://emiservbackoffice.fundaciobit.org:8080/emiservbackofficeapi/externa/services*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ScdcpajUv3Api* | [**peticionSincrona**](docs/ScdcpajUv3Api.md#peticionSincrona) | **POST** /SCDCPAJUv3/peticionSincrona | Realitza una consulta al cedent

## Documentation for Models

 - [ClaveHojaPadronal](docs/ClaveHojaPadronal.md)
 - [DatosPersonales](docs/DatosPersonales.md)
 - [Documentacion](docs/Documentacion.md)
 - [Domicilio](docs/Domicilio.md)
 - [ModelApiResponse](docs/ModelApiResponse.md)
 - [MotivoInscripcion](docs/MotivoInscripcion.md)
 - [Numero](docs/Numero.md)
 - [NumeroSuperior](docs/NumeroSuperior.md)
 - [PeriodoInscripcion](docs/PeriodoInscripcion.md)
 - [Persona](docs/Persona.md)
 - [Personas](docs/Personas.md)
 - [Resultado](docs/Resultado.md)
 - [Solicitud](docs/Solicitud.md)
 - [Titular](docs/Titular.md)
 - [Via](docs/Via.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

pinbal@fundaciobit.org
