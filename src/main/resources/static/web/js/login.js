var app = new Vue({
    el: '#appLogin',
    data: {
        correo: "",
        password: "",
        nombre: "",
        apellido: "",
        apodo: "",
        inicioSesion: true,
        registro: false
    },
    created() {
        this.cargarDatos();
    },

    methods: {
        cargarDatos() {
            axios.get('/api/usuarios/current')
               .then(response => window.location.href = "/web/nft.html")
                .catch(error => {
                    console.log("Inicie sesión!")

                }).finally(function () {
                    const preload = document.querySelector(".preload");
                    preload.style.visibility = "hidden";
                });
        },
        iniciarSesion() {
            axios.post('/api/login', "email=" + this.correo + "&password=" + this.password, {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            })
                .then(response => {
                    window.location.href = "/web/nft.html";
                }).catch(error => {
                    Swal.fire({
                        text: 'Usuario o contraseña incorrectos!',
                        icon: 'danger',
                        confirmButtonText: 'Ok',
                    })
                })
        },
        registrarse() {
            axios.post('/api/usuarios', "correo=" + app.correo + "&password=" + app.password + "&nombre=" + app.nombre + "&apellido=" + app.apellido + "&apodo=" + app.apodo, {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
             } }).then( response => {
                window.location.href = "/web/nft.html";
            }).catch(error => {
                Swal.fire({
                    text: error.response.data,
                    icon: 'warning',
                    confirmButtonText: 'Ok',
                });
            })


        },
    }

})