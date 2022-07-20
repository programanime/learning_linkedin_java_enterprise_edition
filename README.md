# JEE
robust enough, from small business website to fortune 500 backend systems.
![](img/jee_ecosystem.png)  
![](img/jee_structure.png)  
  

# Linkedin course
[text](https://www.linkedin.com/learning/learning-java-enterprise-edition/)

## books
- java ee patterns design

# what is JEE?
- group of APIs that provide a common interface to a set of services.
- annotation-base configuration
    - xml is optional
- context and dependency injection (CDI)

# JEE history
![](img/jee_evolution.png)  
- 1999: Enterprise java platform
    J2EE 1.2 Servlet, JSP, EJB, JMS, RMI
- 2003: web services
- 2006: annotations
- 2009: Dependency injection
Future: move to cloud (JEE 9)
![](img/jee9.png)  
![](img/jee_new_apis.png)  

1. JAX-RS
    - java for rest services
2. JSON-P
    - java API to process json objects
3. JSON-B
    - let you convert java objects into json objects pretty straightforwardly

# Common APIS
![](img/jee_common_apis.png)  
# JSF
# JSP
# JSF
# JSTL - EL (Expression Language)
# Managed Beans
# JAX-RS
# EJB
# JPA
# JMS
# Batch
# Bean Validation

```shell
wget https://download.java.net/glassfish/4.1.1/release/glassfish-4.1.1.zip
cd A:\glassfish-4.1.1\glassfish4\glassfish\bin
asadmin
create-domain --adminport 4848 dominiotrack
start-domain dominiotrack
chrome 127.0.0.1:4848
# deploy target cargo folder folder
chrome http://127.0.0.1:8080/cargo-tracker/
```

# jee implementations
![](img/jee_implementations.png)  

# full profile
in order to support full profile, the server needs to support these APIs
![](img/full_profile.png)  
  
some servers like tomcat support web profile, a subset of these APIs

# web profile
![](img/jee_web_profile.png)

# monolithic architectures
# drawbacks
- large learning curve for joiners
- large deployment process

# jee layers
![](img/jee_layers.png)  
# presentation layer
 - rest service jax-rx
 - web page jsf, jsp, jstl
 - websocket

# business layer
 - ejb
 - entities

# data layer
 - jpa

# JSF API 2.0
## MVC (model view controller)
![](img/jee_mvc.png)    

- view and controller are jsf it self
- model is the bean

## facelets
- view language
- tags as core
    - provide cross browser compatibility

## normal tags
## facelets tags
    - repeat
    - composition
    - define
    - param

## core tags
    - convert
    - lengthvalidate
    - loadBundle
    - actionListener
    - ajax

### pluggable libraries
- primefaces
- myfaces
- icefaces
- bootfaces

- data binding
    - EL expressions
        - #{account.name}
    - they connect to the CDI

- inherit ajax support 
![](img/jee_ajax.png)  

# CDI Scopes (Bean Scope)
lifecycle
- Dependent
    - use just for one client
- ViewScoped
    - ajax view
- FlowScoped
    - connect pages
- FlowDefinition
    - connect pages

# jsf tags - facelets
## ui:insert
point to insert on template
```html
    <ui:insert name="title">Title</ui:insert>
```
## ui:define
put on template child and implement
```html
    <ui:define name="title">Track Cargo</ui:define>
```

# jsf - html tags
- to load css files, you need to place the file in webapp/resources
```html
<h:outputStylesheet name="dd.css"/>
```

# html and jsf
you could use normal html tags inside jsf pages, jsf in an html extension
```html
            <script src="http://maps.google.com/maps/api/js?sensor=false" type="text/javascript"></script>
```

# glassfish commands to deploy

```bat
call a
mvn package & A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 redeploy --name learning-cargo-tracker  target/learning-cargo-tracker.war
@REM A:\glassfish-4.1.1\glassfish4\glassfish\bin\asadmin.bat --user admin --port 4848 deploy target/learning-cargo-tracker.war
```

# primefaces autocomplete
the complete method should contain the whole method name and should receive one string

```html
    <p:autoComplete id="trackingId" dropdown="true" required="true" forceSelection="true" completeMethod="#{track.completeText}" />
```

```java
    public List<String> completeText(String filter){
        List<String> list = new ArrayList();
        list.add("word1");
        list.add("word2");
        list.add("word3");
        list.add("word4");
        list.add("word5");
        list.add("word6");
        list.add("word7");
        return list;
    }
```
