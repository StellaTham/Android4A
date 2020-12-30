# Android4A
Projet Mobile Programming 4A

##  **Presentation**   

Ce projet est une application développée sur Android Studio en utilisant le langage Kotlin.

Il contient une page de connexion/inscription qui donne accès à une liste de musiques de Kéké dans Animal Crossing.


##  **Elements implémentés**
* Ecran de connexion/inscription de compte
* Ecran avec une liste de musiques de Kéké
* Appel WebService à une API rest  
* Stockage de données dans une base de données avec Room
* Clean Architecture et MVVM
* Design


##  **Fonctionnalités**
La page principale correspond à l'écran de connexion/inscription.

![Mainscreen](https://user-images.githubusercontent.com/49620631/103321896-21c53e80-4a3c-11eb-98ad-d1a6b3401f95.JPG)

Après avoir inséré un e-mail et un mot de passe dans les champs requis, on a le choix d'appuyer sur login ou create account.

![MainscreenInfo](https://user-images.githubusercontent.com/49620631/103321971-81bbe500-4a3c-11eb-9f0e-b9f164c2ae64.JPG)

Si l'on appuie sur create account en essayant de s'inscrire, l'application préviendra avec un toast si le compte a bien été créé.
Si l'email utilisé correspond à celui d'un utilisateur déjà inscrit, une erreur s'affiche.

![MainscreenErrorEmail](https://user-images.githubusercontent.com/49620631/103322015-b6c83780-4a3c-11eb-8134-e2813b03f338.JPG)

Si l'on essaye de se connecter avec un compte qui n'existe pas (qui n'a pas été créé ou bien avec des entrées non correctes comme un mauvais mot de passe), une erreur s'affiche aussi.

![MainscreenErrorLogin](https://user-images.githubusercontent.com/49620631/103322063-e8410300-4a3c-11eb-819f-7c36057febba.JPG)

Si l'on réussit finalement à se connecter avec un compte qui est bien enregistré, on a accès à la liste de musiques sur laquelle on peut scroll down.

![List](https://user-images.githubusercontent.com/49620631/103322101-11619380-4a3d-11eb-8f80-37a7d794100f.JPG)

![List2](https://user-images.githubusercontent.com/49620631/103322123-35bd7000-4a3d-11eb-9202-f62e9b260d39.JPG)

P.-S. : le paramètre "music" dans KKsong devait être utilisé pour lire de la musique depuis le fichier mp3 auquel on accède avec le lien URL mais l'idée a été abandonnée par manque de temps.
