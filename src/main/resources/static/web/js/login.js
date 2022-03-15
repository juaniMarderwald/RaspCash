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
        this.cargarDatos
    },

    methods: {
        cargarDatos() {
            //Función a modificar
        },
        iniciarSesion() {
            axios.
                post('/api/login', "email=" + this.correo + "&password=" + this.password, {
                    headers: {
                        'content-type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(response => {
                    window.location.href = "/index.html"

                }).catch(error => {
                    alert(error);
                })
        },
    registrarse() {
        axios.post('/api/usuarios', "correo=" + this.correo + "&password=" + this.password + "&nombre=" + this.nombre + "&apellido=" + this.apellido +"&apodo=" + this.apodo).then(response => {
            window.location.href = "/index.html"

        }).catch(error => {
            alert(error);
        })
    }
    },
})