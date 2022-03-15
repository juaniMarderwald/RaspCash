var app = new Vue({
    el: '#app',
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
           axios.get('/api/usuario/current').then(response => window.location.href = "index.html").catch(error => {console.log("Inicie sesión!")
           const preload = document.querySelector(".preload");
           preload.style.visibility = "hidden";});
        },
        iniciarSesion() {
            axios.post('/api/login', "email=" + this.correo + "&password=" + this.password, {
                    headers: {
                        'content-type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(response => {
                    window.location.href = "index.html"
                }).catch(error => {
                    alert("Usuario o contraseña incorrectos");
                })
        },
    registrarse() {
        axios.post('/api/usuarios', "correo=" + this.correo + "&password=" + this.password + "&nombre=" + this.nombre + "&apellido=" + this.apellido +"&apodo=" + this.apodo, {
        headers: {
            'content-type': 'application/x-www-form-urlencoded'
        }
    }).then(response => {
            window.location.href = "index.html"
        }).catch(error => {
            alert(error.response.data);
        })
    }
    },
})