[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QGf4F8_h)

# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description
Le projet "Dice" est une application Spring Boot permettant de simuler des lancés de dés et de gérer l'historique des résultats en base de données. Elle illustre les concepts essentiels de Spring Boot, notamment l’injection de dépendances, les services RESTful, les entités JPA et l’utilisation des repositories pour accéder aux données.

## Étapes réalisées

### 1. Création du projet Spring Boot
Le projet a été initialisé avec [Spring Initializr](https://start.spring.io/). Nous avons opté pour **Maven** et choisi la dernière version LTS de Spring Boot disponible.  
Les dépendances **Spring Web**, **Spring Data JPA** et **H2 Database** ont été incluses dès la création du projet.

### 2. Configuration du projet
Après l’initialisation, l’application a été configurée pour écouter sur le port **8081**. Le nom du projet, **dice**, a également été défini dans le fichier de configuration `application.properties`.

### 3. Création de la classe `Dice`
Nous avons créé la classe `Dice`, marquée avec l’annotation `@Component`. Elle contient la logique nécessaire pour effectuer un lancé aléatoire. Grâce à l’annotation `@Component`, cette classe est injectée automatiquement partout où nous en avons besoin.

### 4. Création de l’entité `DiceRollLog`
Une entité JPA nommée `DiceRollLog` a été implémentée avec les champs suivants :
- **`id`** : Identifiant unique (`@Id`, `@GeneratedValue`).
- **`diceCount`** : Nombre de dés lancés.
- **`results`** : Chaîne (ou liste) des valeurs obtenues. Nous avons choisi une représentation sous forme de simple chaîne de caractères pour plus de simplicité.
- **`timestamp`** : Horodatage du lancé.

L’annotation `@Entity` a été utilisée pour spécifier que `DiceRollLog` est une entité persistante gérée par JPA.

### 5. Création du `Repository`
Un repository `DiceRollLogRepository` a été créé, héritant de l’interface `JpaRepository<DiceRollLog, Long>`. Il permet d’effectuer les opérations CRUD (Create, Read, Update, Delete) sur la table correspondant à l’entité `DiceRollLog`.

### 6. Création du contrôleur REST pour lancer les dés
Un contrôleur REST, annoté `@RestController`, a été mis en place avec les endpoints suivants :
- **`GET api/rollDice`** : Permet de lancer un seul dé.
- **`GET api/rollDice/{nbLancer}`** : nbLancer est un paramètre passé dans l’URL.

### 7. Création du `Service`
Un service annoté `@Service` a été développé pour centraliser la logique métier. Il expose notamment une méthode qui :
1. Reçoit un nombre de dés à lancer.
2. Retourne les résultats des lancés au contrôleur.
3. Enregistre simultanément l’historique des lancés en base de données via le `Repository`.

### 8. Contrôleur pour afficher les historiques
Nous avons également implémenté un contrôleur REST dédié à l’affichage de l’historique des lancés :
- **`GET api/log`** : Retourne l’ensemble des enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation
Enfin, nous avons démarré l’application pour tester chaque endpoint et vérifier le comportement attendu. Les résultats se sont correctement inscrits dans la base de données H2, et les réponses JSON retournées par les endpoints ont validé le bon fonctionnement de l’application.
