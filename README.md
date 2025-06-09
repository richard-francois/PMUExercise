# PMU Exercise
Exercice PMU de mise en oeuvre d'un micro-service(API), avec une BDD relationnelle SQL et un bus de de messages.

Stack choisie: 
- API: Java 21 / SpringBoot
- BDD: PostGreSQL 17
- Messaging; Kafka 3.7

## Initialisation de l'infrastructure
J'utilise une installation existante des logiciels n-tiers sous windows:
- PostGreSQL avec pgAdmin pour administrer la base de données
- Kafka sous WSL/Ubuntu

## Initialisation du micro-service
J'utilise spring initializr (https://start.spring.io/) pour créer le squelette de mon application
- Je choisi maven comme gestionnaire de packages
- Je choisi java 21 et spring boot 3
- Je choisi les dependances suivantes: Spring Web, Spring Data JPA, PostgreSQL Driver, Liquibase Migration, Spring for Apache Kafka. 

Je rajoute ensuite  les dependances JUnit/Mockito, log4j et swagger respectivement pour les tests unitaires/integration, le logging et la documentation de l'API.

De cette manière j'embarque tout le necessaire pour assurer le DEV, le TEST et la supervision RUN de l'application.

## Approche d'implémentation du MVP
Je choisi une approche Hexagonale avec du TDD. Le code sera testé tout au long du developpement et la séparation des responsabilités Métier/Technique sera faite.
Je choisi de mettre en oeuvre le design pattern Outbox pour garantir la consistance des données entre la base de données et Kafka.
