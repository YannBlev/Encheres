function filterCards() {
    let input = document.getElementById("myInput");
    let filter = input.value.toUpperCase();
    let cards = document.getElementsByClassName("card");

    for (let i = 0; i < cards.length; i++) {
        let txtValue = cards[i].textContent || cards[i].innerText;

        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            cards[i].classList.remove("hidden");
        } else {
            cards[i].classList.add("hidden");
        }
    }
}
