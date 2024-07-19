# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.7/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.7/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.7/reference/htmlsingle/index.html#using.devtools)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.


### About project instalation
For the correct installation or compilation of the project, that is, when executing the command ```mvn -U clean install```, an api key obtained from the NATIONAL VULNERABILITY DATABASE may be required; This is because the project contains the OWASP vulnerability checking extension (OWASP Dependency-Check) as part of good programming practices.

To obtain the API key, you must access the following link: [NVD](https://nvd.nist.gov/developers/request-an-api-key), fill out the form and activate. Please note that the key will only be available once after activation.

Once you have the key string, please add it to the pom file, in build -> plugins -> '<!-- OWASP security inspection -->' in the nvdApiKey property, once this is done, you can compile the project, and once it is Compiling could take a while while the plugin databases are updated, this being the only time this will happen.
