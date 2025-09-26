# Exercice Java Test #3 - API Spring Boot

## Objectifs

Appréhender le fonctionnement de JUnit et de Mockito dans le cadre de tests du framework Spring (API)
## Sujet

Via l'utilisation de Maven, de JUnit 5 et de Mockito, réaliser une application Spring permettant de faire un CRUD de base sur une entité de votre choix.

Cette API devra avoir par exemple, pour routes:

* `GET /api/v1/products`: Retourne tous les produits
* `GET /api/v1/products/:productId`: Retourne un produit à partir de son ID, ou Not Found si aucun produit de ce type existe
* `POST /api/v1/products`: Permet l'ajout d'un produit via un payload contenant les infos du produit
* `PATCH /api/v1/products/:productId`: Permet l'édition des informations d'un produit via son ID et les nouvelles informations en payload. Retourne un Not found si ce dernier n'existe pas
* `DELETE /api/v1/products/:productId`: Permet la suppression d'un produit ou retourne un Not Found si celui-ci n'existe pas

Réaliser l'ensemble des tests de cette API et tester au minimum les couches Contrôleur et Service.

## BONUS

Réaliser l'application en suivant les principes du TDD