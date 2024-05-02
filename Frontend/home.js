async function users() {

    try {

        const response = await fetch('http://localhost:8080/api/user/all');

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }


        const dati = await response.json();

        // se va tutto a buon fine mostro il div con la tabella
        let tableDiv = document.getElementById("getUsers");

        if (tableDiv.classList.contains('hidden')) {
            tableDiv.classList.remove('hidden');
        } else {
            tableDiv.classList.add('hidden');
        }

        console.log(dati);

        let body = "";
        dati.forEach(user => {

            body += "<tr>";
            body += "<td>" + user.name + "</td>";
            body += "<td>" + user.surname + "</td>";
            body += "<td>" + user.email + "</td>";
            body += '<td><a style="color: black;" href="#" onClick="updateUser(\'' + user.email + '\')">Modify</a></td>';
            body += "</tr>";


        });



        document.getElementById("userData").innerHTML = body;

    }
    catch (error) {
        console.error('Errore:', error);

        // se va in errore mostro un messaggio
        let tableDiv = document.getElementById("userError");

        if (tableDiv.classList.contains('hidden')) {
            tableDiv.classList.remove('hidden');
        } else {
            tableDiv.classList.add('hidden');
        }
    }

}



async function categories() {

    try {

        const response = await fetch('http://localhost:8080/api/category');


        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }


        const dati = await response.json();

        console.log(dati);

        // se va tutto a buon fine mostro il div con la tabella
        let tableDiv = document.getElementById("getCategories");

        if (tableDiv.classList.contains('hidden')) {
            tableDiv.classList.remove('hidden');
        } else {
            tableDiv.classList.add('hidden');
        }

        let body = "";
        dati.forEach(category => {

            body += "<tr>";
            body += "<td>" + category.categoryName + "</td>";
            body += "</tr>";


        });

        document.getElementById("categoryData").innerHTML = body;

    }
    catch (error) {
        console.error('Errore:', error);

        let tableDiv = document.getElementById("categoryError");

        if (tableDiv.classList.contains('hidden')) {
            tableDiv.classList.remove('hidden');
        } else {
            tableDiv.classList.add('hidden');
        }
    }

}

async function findUser() {

    // tolgo tutte le altre schermate
    let tableDivUser = document.getElementById("getUsers");

    if (!tableDivUser.classList.contains('hidden')) {
        tableDivUser.classList.add('hidden');
    }

    let tableDivCategories = document.getElementById("getCategories");

    if (!tableDivCategories.classList.contains('hidden')) {

        tableDivCategories.classList.add('hidden');
    }

    // mostra il form
    let tableDivFindUser = document.getElementById("findUser");

    if (tableDivFindUser.classList.contains('hidden')) {
        tableDivFindUser.classList.remove('hidden');
    } else {
        tableDivFindUser.classList.add('hidden');
    }

}

async function removeUser() {

    // tolgo tutte le altre schermate
    let tableDivUser = document.getElementById("getUsers");

    if (!tableDivUser.classList.contains('hidden')) {
        tableDivUser.classList.add('hidden');
    }

    let tableDivCategories = document.getElementById("getCategories");

    if (!tableDivCategories.classList.contains('hidden')) {

        tableDivCategories.classList.add('hidden');
    }

    // mostra il form
    let tableDivFindUser = document.getElementById("deleteUser");

    if (tableDivFindUser.classList.contains('hidden')) {
        tableDivFindUser.classList.remove('hidden');
    } else {
        tableDivFindUser.classList.add('hidden');
    }

}

async function searchUser() {

    var form = document.getElementById("searchUserForm");

    form.addEventListener("submit", function (event) {

        event.preventDefault();

        let email = document.getElementById("email").value;

        // console.log(email)
        // console.log(password)

        // CHIAMATA GET CON QUERY STRING
        fetch(`http://localhost:8080/api/user/showuser?email=` + email, {
            method: 'GET',
            headers: {
                'X-RapidAPI-Key': 'your-rapid-key',
                'X-RapidAPI-Host': 'famous-quotes4.p.rapidapi.com'
            }
        })
            .then(response => response.json())
            .then(data => {
                console.log(data)

                // mostrare nome e cognome
                let body = "";


                body += "<tr>";
                body += "<td>" + data.name + "</td>";
                body += "<td>" + data.surname + "</td>";
                body += '<td><a style="color: black;" href="#" onClick="updateUser(\'' + data.email + '\')">Modify</a></td>';
                body += "</tr>";


                document.getElementById("findUserTable").innerHTML = body;

            })
            .catch(err => {
                console.error(err)
                alert("invalid input")

            });

    })
}

async function updateUser(email) {
    window.location.replace("./modificaUtente.html?email=" + email)
}

async function deleteUser() {

    var form = document.getElementById("deleteUserForm");

    form.addEventListener("submit", function (event) {

        event.preventDefault();

        let email = document.getElementById("emailDelete").value;

        fetch('http://localhost:8080/api/user/delete/' + email, {

            method: 'DELETE',


        }).then(async response => await response.json())
            .then(res => {

                console.log("eseguito");
                // window.location.replace("./home.html")

            }

            )
            .catch((error) => {
                console.error('Errore:', error)
                alert("Errore nell'inserimento dei dati")
            });

    })
}

async function logout() {

    try {

        const response = await fetch('http://localhost:8080/api/user/logout');


        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }



    }
    catch (error) {

        console.error('Errore durante la chiamata REST:', error);
    }

}