const menuItemsList = [
    {label: 'dashboardPage', value: 'dashboardMenuItem'},
    {label: 'productPage', value: 'productMenuItem'},
    {label: 'categoriesPage', value: 'categoriesMenuItem'},
    {label: 'ordersPage', value: 'orderMenuItem'},
    {label: 'usersPage', value: 'usersMenuItem'},
    {label: 'vendorPage', value: 'vendorMenuItem'},
    {label: 'transactionsPage', value: 'transactionsMenuItem'}
];

const body = document.querySelector('body'),
    sidebar = body.querySelector('.sidebar'),
    toggle = body.querySelector('.toggle');

toggle.addEventListener('click', () => {
    sidebar.classList.toggle('close');
});

const currentPath = window.location.pathname;

function setActiveMenuItem(){
    const menuItems = document.querySelectorAll('.nav__links');
    menuItems.forEach(function (menuItem) {
        menuItem.classList.remove('active');
    })

    menuItemsList.forEach(function(item){
        console.log('Current Path ', currentPath.split("/"))
        if(currentPath.split("/").includes(item.label)){
            document.getElementById(item.value).classList.add('active');
        }
    })
}

document.addEventListener("click", function(event) {
    var dropdown = document.getElementById("dropdownUserContent");
    var button = document.getElementsByClassName("header__icon")[0];

    if (event.target !== button && event.target !== dropdown) {
        dropdown.style.display = "none";
    }
});

function openUserIconMenu() {
    const dropdown = document.getElementById('dropdownUserContent');
    dropdown.style.display =
        dropdown.style.display === 'block' ? 'none' : 'block';
}


setActiveMenuItem();
