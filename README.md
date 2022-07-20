# JEE
robust enough, from small business website to fortune 500 backend systems.
![](img/jee_ecosystem.png)  
![](img/jee_structure.png)  
  
# Learning Java Enterprise Edition

# Linkedin course
[course link](https://www.linkedin.com/learning/learning-java-enterprise-edition/)
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

```html
<h:form id="trackingForm">
    <p:outputLabel id="ouputLabel" value="#{track.title} #{track.trackingId}" />
    <p:autoComplete 
        id="trackingId" 
        dropdown="true" 
        required="true" 
        forceSelection="true" 
        value="#{track.trackingId}"
        completeMethod="#{track.completeText}" 
    >
        <p:ajax event="itemSelect" update="ouputLabel" process="@this"/>
        <p:ajax event="change" update="ouputLabel" process="@this"/>
    </p:autoComplete>
</h:form>
```
### conclusions
each time some event is trigger, one ajax request is send to server, a header with the event name is sent

![](img/ajax_event.png)  

# JPA
# Embeddable

```java
@Embeddable
```
- the entity is not a table
- the entity becomes part of other entities

# ManyToOne
- the one part is the current attribute
```java
@ManyToOne
@JoinColumn(name = "spec_origin_id", updatable = false)
private Location origin;
```

# Temporal annotation
jpa could handle three types, Date, Time, Timestamp
```java
@Temporal(TemporalType.DATE)
```
# Column annotation
is a important one:
1. nullable
2. updatable
2. insertable
4. name
5. unique
```java
    @Column(name = "spec_arrival_deadline")
```

# notnull annotation
indicator, the column is not null
```java
@NotNull
```

# JoinColumn
- in is basic shape, useful for foreign keys
- you could specific updatable, insertable, nullable, unique
```java
    @JoinColumn(name = "spec_destination_id")
```

# id annotation
```java
@Id
@GeneratedValue
private Long id;
```
# entity annotation
let you declare an object to be manage by the entity manager

```java
@Entity
```

# NamedQueries annotation
- let you define queries in jpa language
```java
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll",
            query = "Select c from Cargo c"),
    @NamedQuery(name = "Cargo.findByTrackingId",query = "Select c from Cargo c where c.trackingId = :trackingId"),
    @NamedQuery(name = "Cargo.getAllTrackingIds",
            query = "Select c.trackingId from Cargo c") })
```

```java
    @Embedded
    private TrackingId trackingId;
```

# apache commons lang
useful for check null values, make builders, composite equals, and so on.

```java
        Validate.notNull(trackingId, "Tracking ID is required");
```

# enumerated annotation
let you declare a columns which could contain specific values
```java
    @Enumerated(EnumType.STRING)
    @Column(name = "next_expected_handling_event_type")
    private HandlingEvent.Type type;
```

EqualsBuilder
```java
private boolean sameValueAs(HandlingActivity other) {
    return other != null
            && new EqualsBuilder().append(this.type, other.type)
            .append(this.location, other.location)
            .append(this.voyage, other.voyage).isEquals();
}
```

# OneToMany annotation
- you need to indicate the foreign key in the other table, to join with the current entity
- you could indicate an order by
```java
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cargo_id")
    @OrderBy("loadTime")
    @PrivateOwned
    @Size(min = 1)
    private List<Leg> legs = Collections.emptyList();
```

# PrivateOwned annotation
- the target object just exists inside the current one
- can't belong to other or exists by their own
```java
    @PrivateOwned
```

# Size annotation
indicate the size for the field
```java
    @Size(min = 1)
```

# Transient annotation
don't be persisted in the database
```java
    @Transient
    private String summary;
```

# Enumerated annotation
useful when you need to keep specific values for a column
```java
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    public enum Type {
        LOAD(true),
        UNLOAD(true),
        RECEIVE(false),
        CLAIM(false),
        CUSTOMS(false);
        private final boolean voyageRequired;

        private Type(boolean voyageRequired) {
            this.voyageRequired = voyageRequired;
        }

        public boolean requiresVoyage() {
            return voyageRequired;
        }

        public boolean prohibitsVoyage() {
            return !requiresVoyage();
        }

        public boolean sameValueAs(Type other) {
            return other != null && this.equals(other);
        }
    }
```

# Pattern annotation
to check the string pattern
```java
    @Pattern(regexp = "[a-zA-Z]{2}[a-zA-Z2-9]{3}")
    private String unlocode;
```


# CDI
about injecting dependencies

# ApplicationScoped annotation
- the bean is created once and is shared by all the requests, EJBs, Servlets, JMS objects, Filters.

```java
@ApplicationScoped
```

# PersistenceContext annotation
let you handle entities
```java
@PersistenceContext
private EntityManager entityManager;
```

getting one single result
```java
return entityManager.createNamedQuery("Location.findByUnLocode",
        Location.class).setParameter("unLocode", unLocode)
        .getSingleResult();
```

getting result list
```java
        return entityManager.createNamedQuery("Location.findAll", Location.class)
                .getResultList();
```

# Inject annotation
let you inject a bean
```java
@Inject
private CargoRepository cargoRepository;
```

# Named annotation
let you create a bean with a named to be call by jsf or jsp

# ViewScoped annotation
the bean just live while the user interact with the same screen

```java
@Named
@ViewScoped
public class Track implements Serializable {
```
