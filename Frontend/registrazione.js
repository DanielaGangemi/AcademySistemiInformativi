async function register() {

    
    var form = document.getElementById("registrationUserForm");

    form.addEventListener("submit", function (event) {

        event.preventDefault();

        let name = document.getElementById("name").value;
        let surname = document.getElementById("surname").value;
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let role = document.getElementById("ruolo").value;

        fetch('http://localhost:8080/api/user/registration', {

            method: 'POST',
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

        }).then(async response => await response.json()) 
        .then(
            window.location.replace("./home.html")
        
        ) 
        .catch((error) => {
            console.error('Errore:', error)
            alert("Errore nell'inserimento dei dati")
        }); 

    })
}