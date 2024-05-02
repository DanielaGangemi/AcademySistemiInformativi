
const searchParams = new URLSearchParams(window.location.search);
const email = searchParams.get('email'); 

console.log(email)

document.getElementById("email").value = email;

async function update() {

    var form = document.getElementById("updateUserForm");

    form.addEventListener("submit", function (event) {

        event.preventDefault();

        let name = document.getElementById("name").value;
        let surname = document.getElementById("surname").value;
        // let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let role = document.getElementById("ruolo").value;

        // CHIAMATA PUT
        fetch('http://localhost:8080/api/user/update', {

            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({

                "name": name,
                "surname": surname,
                "email": email,
                "password": password,
                "roleId": role

            })

        })
            .then(async response => await response.json())
            .then(

                window.location.replace("./home.html")

            )
            .catch((error) => {
                console.error('Errore:', error)
                alert("Errore nell'inserimento dei dati")
            });

    })

}