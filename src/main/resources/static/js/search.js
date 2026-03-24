// function myFunction() {
//     var input, filter, ul, li, a, i, txtValue;
//         input = document.getElementById("myInput");
//         filter = input.value.toUpperCase();
//         ul = document.getElementById("myUL");
//         li = ul.getElementsByTagName("li");
//
//     for (i = 0; i < li.length; i++) {
//         a = li[i].getElementsByTagName("a")[0];
//         txtValue = a.textContent || a.innerText;
//
//     if (txtValue.toUpperCase().indexOf(filter) > -1) {
//             li[i].style.display = "";
//
//         } else {
//         li[i].style.display = "none";
//         }
//     }
// }

function myFunction() {
    // Déclaration des variables
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName('li');

    // Boucle à travers tous les éléments de la liste
    for (i = 0; i < li.length; i++) {
        // On récupère le lien <a> à l'intérieur du <li>
        a = li[i].getElementsByTagName("a")[0];
        txtValue = a.textContent || a.innerText;

        // Si le texte correspond au filtre, on affiche, sinon on cache
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
