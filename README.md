Saagie Human
----

But : Proposer une API Rest permettant la gestion des personnes de l'édition.


Il sera possible de faire un CRUD sur les objets "human" ainsi :

GET     /api/human => retourne la liste de toutes les personnes
GET     /api/human/id => retoune la personne représentée par son ID (HTTP Error 404 si la personne n'existe pas)
DELETE  /api/human/id => supprime la personne représentée par son ID et la retourne (HTTP Error 404 si la personne n'existe pas)
POST    /api/human => ajoute une personne et retourne la personne avec son ID
PUT     /api/human/id => modifie une personne (modification totale) - (HTTP Error 404 si la personne n'existe pas)

