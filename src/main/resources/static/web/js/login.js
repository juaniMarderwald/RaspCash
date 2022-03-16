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
            axios.get('/api/usuario/current')
                .then(response => window.location.href = "/web/nft.html")
                .catch(error => {
                    console.log("Inicie sesión!")

                });
        },
        iniciarSesion() {
            axios.post('/api/login', "email=" + this.correo + "&password=" + this.password, {
                    headers: {
                        'content-type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(response => {
                    window.location.href = "/web/nft.html"
                }).catch(error => {
                    alert("Usuario o contraseña incorrectos");
                })
        },
        registrarse() {
            axios.post('/api/usuarios', "correo=" + this.correo + "&password=" + this.password + "&nombre=" + this.nombre + "&apellido=" + this.apellido + "&apodo=" + this.apodo, {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            }).then(response => {
                this.iniciarSesion();
                window.location.href = "/web/nft.html"
            }).catch(error => {
                alert(error.response.data);
            })


        },

        CerraSeccion() {
            axios.post(`/api/logout`)
                .then(response => window.alert('GRACIAS POR LA VISITA!! :D'))
            return (window.location.href = "/index.html")

        },
    }

})