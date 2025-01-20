# Entwicklungsbericht: Webanwendung "Kinderbibliothek"

## Inhalt

1. [Einleitung](#1-einleitung)
2. [Projektübersicht](#2-projektübersicht)
3. [Entwicklungsphasen](#3-entwicklungsphasen)
    - [3.1. Erstellung und Befüllung der Datenbank](#31-erstellung-und-befüllung-der-datenbank)
    - [3.2. Einrichtung der JDBC-Verbindung und Verbindungs-Pooling](#32-einrichtung-der-jdbc-verbindung-und-verbindungs-pooling)
    - [3.3. Entwicklung eines JPA-Containers](#33-entwicklung-eines-jpa-containers)
    - [3.4. Entwicklung eines Session-Komponenten- und EJB-Containers](#34-entwicklung-eines-session-komponenten-und-ejb-containers)
    - [3.5. Entwicklung der Benutzeroberfläche](#35-entwicklung-der-benutzeroberfläche)
4. [Konfiguration und Bereitstellung](#4-konfiguration-und-bereitstellung)
    - [4.1. Einrichtung des Applikationsservers](#41-einrichtung-des-applikationsservers)
    - [4.2. Bereitstellung der Anwendung](#42-bereitstellung-der-anwendung)
5. [Tests](#5-tests)
6. [Fazit](#6-fazit)

---

## 1. Einleitung

Das Ziel dieses Berichts ist es, den Entwicklungsprozess der Webanwendung "Kinderbibliothek" zu dokumentieren. Die Anwendung ist darauf ausgelegt, einen Katalog von Kinderbüchern zu verwalten. Die Funktionen umfassen das Hinzufügen, Bearbeiten, Löschen und Anzeigen von Informationen über Bücher, Autoren und Kategorien. Die Entwicklung erfolgte unter Verwendung von Java EE-Technologien wie JSP, Servlets, JDBC, JPA und EJB.

## 2. Projektübersicht

Die Webanwendung "Kinderbibliothek" dient der Verwaltung einer Buchsammlung und bietet den Benutzern eine benutzerfreundliche Schnittstelle zur Interaktion mit den Daten. Die Hauptfunktionen umfassen:

- **Anzeigen der Bücherliste**: Benutzer können die verfügbaren Bücher sowie Informationen über deren Autoren und Kategorien anzeigen.
- **Hinzufügen neuer Bücher**: Möglichkeit, neue Einträge in den Katalog mit allen erforderlichen Details hinzuzufügen.
- **Bearbeiten und Löschen von Büchern**: Verwaltung vorhandener Einträge zur Aktualisierung der Daten.
- **Verwaltung von Autoren und Kategorien**: Hinzufügen, Bearbeiten und Löschen von Informationen über Autoren und Kategorien.
- **Dynamische Datenverarbeitung**: Verwendung von Servlets und EJB zur Verarbeitung von Anfragen und Geschäftslogik der Anwendung.

## 3. Entwicklungsphasen

### 3.1. Erstellung und Befüllung der Datenbank

Der erste Schritt bestand darin, die Datenbank zu entwerfen und zu erstellen, die Informationen über Bücher, Autoren und Kategorien speichert. Die Datenbank umfasst folgende Entitäten:

- **Authors (Autoren)**: Speichert Informationen über Autoren, einschließlich Name, Nachname und Biografie.
- **Categories (Kategorien)**: Enthält Buchkategorien wie "Fantasy", "Abenteuer" usw.
- **Books (Bücher)**: Enthält Informationen über Bücher wie Titel, Autor, Kategorie, Erscheinungsjahr und ISBN.

Nach der Erstellung des Datenbankschemas wurden SQL-Skripte entwickelt, um die Tabellen mit minimalen Daten zu füllen. Dies ermöglichte die Testung der Anwendung.

### 3.2. Einrichtung der JDBC-Verbindung und Verbindungs-Pooling

Für die Datenbankinteraktion wurde JDBC verwendet. Es wurde ein Verbindungs-Pooling eingerichtet, um die Ressourcennutzung zu optimieren.

**Hauptschritte der Einrichtung:**

1. **Konfiguration des Verbindungs-Pool**: Definition einer DataSource im Server-Konfigurationsfile.
2. **Integration in DAO-Klassen**: Nutzung von Pooled Connections statt direkter Erstellung neuer Verbindungen.

### 3.3. Entwicklung eines JPA-Containers

Zur Erleichterung der Datenbankinteraktion und zur Umsetzung des objekt-relationalen Mappings (ORM) wurde die Technologie JPA (Java Persistence API) verwendet.

**Hauptschritte der Entwicklung:**

1. **Konfiguration von `persistence.xml`**: Definition einer Persistence-Unit mit Angabe der Datenbankverbindung und Hibernate-Parametern.
2. **Annotieren von Modellen**: Verwendung von JPA-Annotationen wie `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@ManyToOne` und `@OneToMany`, um Entitäten und deren Beziehungen zu definieren.
3. **Erstellung von DAO-Klassen**: Entwicklung von CRUD-Methoden mit dem EntityManager zur Interaktion mit der Datenbank.

### 3.4. Entwicklung eines Session-Komponenten- und EJB-Containers

Zur Umsetzung der Geschäftslogik der Anwendung wurden EJB (Enterprise JavaBeans) verwendet. Es wurde eine zustandslose Session-Komponente entwickelt.

**Hauptschritte der Entwicklung:**

1. **Erstellung von EJB-Services**: Implementierung eines `BookService` mit Methoden für die Buchverwaltung (Hinzufügen, Abrufen, Aktualisieren, Löschen).
2. **Integration mit Servlets**: Aktualisierung der Servlets, um über die EJB-Komponente statt direkt mit DAO-Klassen zu interagieren.

### 3.5. Entwicklung der Benutzeroberfläche

Die Benutzeroberfläche wurde mit JSP-Seiten und -Fragmenten umgesetzt.

**Hauptschritte der Entwicklung:**

1. **Erstellung von JSP-Fragmenten**: Entwicklung von wiederverwendbaren Layout-Komponenten wie `header.jspf` und `footer.jspf`.
2. **Entwicklung der Hauptseiten**:
    - **Startseite (`index.jsp`)**: Übersicht über die Anwendung.
    - **Bücherliste (`books.jsp`)**: Anzeige einer Tabelle mit verfügbaren Büchern.
    - **Formularseiten**: Seiten zum Hinzufügen und Bearbeiten von Büchern.

## 4. Konfiguration und Bereitstellung

### 4.1. Einrichtung des Applikationsservers

Es wurde WildFly als Applikationsserver verwendet. Dieser wurde entsprechend konfiguriert:

1. **Installation von WildFly**: Herunterladen und Konfigurieren des Servers.
2. **Einrichtung des Verbindungs-Pool**: Definition einer DataSource für MySQL.

### 4.2. Bereitstellung der Anwendung

**Hauptschritte:**

1. **Erstellung eines WAR-Files**: Kompilierung und Verpackung der Anwendung mit Maven.
2. **Bereitstellung auf WildFly**: Kopieren des WAR-Files in den `deployments`-Ordner.

## 5. Tests

Die Tests umfassten:

1. **Datenbanktests**: Überprüfung der Tabellen und Beziehungen.
2. **Funktionale Tests**: Sicherstellen der korrekten Ausführung der Geschäftslogik.
3. **UI-Tests**: Überprüfung der Benutzeroberfläche.

## 6. Fazit

Die Webanwendung "Kinderbibliothek" wurde erfolgreich entwickelt und bereitgestellt. Sie bietet alle notwendigen Funktionen zur Verwaltung eines Buchkatalogs und zeichnet sich durch eine modulare Architektur sowie einfache Wartbarkeit aus.
