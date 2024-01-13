document.addEventListener("click", function(event) {
    var dropdown = document.getElementById("dropdownContainer");
    var button = document.getElementById("sortingOption");

    if (event.target !== button && event.target !== dropdown) {
        dropdown.style.display = "none";
    }
});


function openDropdown() {
    const dropdown = document.getElementById('dropdownContainer');
    dropdown.style.display =
        dropdown.style.display === 'block' ? 'none' : 'block';
}

function sortCards(data) {
    const url = '/vendorPage/cards?sort=' + data;

    // Show loading state
    showLoading();

    const xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onload = function () {
        // Hide loading state
        hideLoading();

        if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            console.log({response});
            updateCards(response);
        }
    };
    xhr.send();
}

function updateCards(cards) {
    console.log({cards})
    var cardContainer = document.querySelector('.card-container');
    cardContainer.innerHTML = ''; // Clear existing cards

    if(cards.length > 0){
        cards?.forEach(function (card) {
            var cardHtml = '<div class="card"><h3>' + card.name + '</h3></div>';
            cardContainer.innerHTML += cardHtml;
        });
    }else{
        const cardHtml = '<div class="card"><h3>' + 'No card detail details found' + '</h3/</div>';
        cardContainer.innerHTML = cardHtml;
    }
}

function showLoading() {
    // Show loading spinner or message
    var loadingElement = document.getElementById('loading');
    if (loadingElement) {
        loadingElement.style.display = 'block';
    }
}

function hideLoading() {
    // Hide loading spinner or message
    var loadingElement = document.getElementById('loading');
    if (loadingElement) {
        loadingElement.style.display = 'none';
    }
}


function addVendor(){
    window.location.href = '/vendorPage/add-vendors';
}