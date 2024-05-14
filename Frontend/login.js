function login() {

    var form = document.getElementById("loginForm");

    form.addEventListener("submit", function (event) {

        event.preventDefault();

        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;

        // console.log(email)
        // console.log(password)

        fetch('http://localhost:8080/api/user/login', {

            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({

                "email": email,
                "password": password

            })

        }).then(async response => await response.json()) 
        .then(data => {

            let token = {
                token: data.token,
                ttl: data.ttl,
                tokenCreationTime: data.tokenCreationTime
            }

            sessionStorage.setItem(token)

            console.log(data)
            window.location.replace("./home.html?email=" + email)
        
        }) 
        .catch((error) => {
            console.error('Errore:', error)
            alert("Errore nell'inserimento dei dati")
        }); 

    })

}