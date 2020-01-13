# project_635-1 E-shop par Valérian HAURY & ALexandre DA MOTA

RESUME WEBSITE ****************************************************************************************************************************
Eshop est un site internet qui permet d'afficher des produits.
Il est possible d'ajouter des produits dans un caddie et d'accéder à celui-ci afin de modifier les produits du caddie (ajout/suppression).
L'application permet de valider le contenu du caddie pour accéder au paiement. 
Finalement l'utilisateur à la possibilité de rentrer ses informations bancaire afin de payer sa commande.

GETTING STARTED ***************************************************************************************************************************
1) télécharger apache-tomee-webprofile 7.1.1 ( url: https://tomee.apache.org/download-ng.html)

/!\ (SI VOUS POSSEDEZ DÉJA LE FICHIER WAR, ALLEZ DIRECTEMENT À L'ÉTAPE 4) /!\
    2) ouvrir le projet avec INTELIJ > Depuis INTELIJ > onglet "terminal" > tapez la commande "mvn clean package".
    3) le fichier eshop-1.0.war se trouveras dans "eshop/target/".
    
4) copiez eshop-1.0.war dans le dossier "webapps" de apache-tomee-webprofile (voir ou vous avez installé tomee dans l'étape 1).
5) allez dans le dossier "bin" de apache-tomee-webprofile > executez "startup.bat" (une console aparait et le serveur démarre)
6) le serveur "déploie" automatiquement eshop-1.0.war en un dossier du même nom ("eshop-1.0") situé au meme endroit que eshop-1.0.war.
7) le site web est maintenant accessible sur le navigateur par l'url suivante : "http://localhost:8080/eshop-1.0/"
