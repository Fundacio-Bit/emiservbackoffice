# carpeta-api-externa-client

API REST EXTERNA de Carpeta
- API version: 1.0.0
  - Build date: 2022-04-08T12:09:32.619803400+02:00[Europe/Paris]

Conjunt de Serveis REST de Carpeta per ser accedits des de l'exterior

  For more information, please visit [http://otae.fundaciobit.org](http://otae.fundaciobit.org)

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
  <groupId>es.caib.carpeta</groupId>
  <artifactId>carpeta-api-externa-client</artifactId>
  <version>1.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "es.caib.carpeta:carpeta-api-externa-client:1.1"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/carpeta-api-externa-client-1.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import es.caib.carpeta.apiexterna.client.services.*;
import es.caib.carpeta.apiexterna.client.services.auth.*;
import es.caib.carpeta.apiexterna.client.model.*;
import es.caib.carpeta.apiexterna.client.api.AccessosApi;

import java.io.File;
import java.util.*;

public class AccessosApiExample {

    public static void main(String[] args) {
        
        AccessosApi apiInstance = new AccessosApi();
        String entitat = "entitat_example"; // String | Codi de l'entitat de la qual obtenim les estadistiques
        String inici = "inici_example"; // String | Data d'inici, en format YYYY-MM-DD, a partir de la qual volem obtenir estadistiques
        String fi = "fi_example"; // String | Data fi, en format YYYY-MM-DD, fins la qual volem tenir estadistiques
        String idioma = "idioma_example"; // String | Codi de l'idioma
        try {
            PaginaAcces result = apiInstance.accessos(entitat, inici, fi, idioma);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccessosApi#accessos");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/carpetaapi/externa*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccessosApi* | [**accessos**](docs/AccessosApi.md#accessos) | **GET** /serveis/accessos | Retorna la llista d&#x60;accessos a CARPETA
*SecuretatApi* | [**echo**](docs/SecuretatApi.md#echo) | **GET** /secure/echo | Fa un ECHO

## Documentation for Models

 - [Acces](docs/Acces.md)
 - [PaginaAcces](docs/PaginaAcces.md)

## Documentation for Authorization

Authentication schemes defined for the API:
### BasicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

governdigital.carpeta@fundaciobit.org