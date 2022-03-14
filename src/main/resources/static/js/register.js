var app = new Vue({
    el: '#app',
    data: {
        form: {
            Nombre: "",
            apellido: "",
            correo: "",
            password: "",
            apodo: ""
        }
    },
    methods: {
        crearNuevoUsuario() {
            // if (this.form.Nombre && this.form.apellido && this.form.apodo && this.form.correo.includes("@")) {
            let client = {
                Nombre: this.form.Nombre,
                apellido: this.form.apellido,
                correo: this.form.correo,
                password: this.form.password,
                apodo: this.form.apodo
            }
            this.postClient(client)

        },

        postClient(client) {

            axios.post('/api/usuarios', "nombre=" + client.Nombre + "&apellido=" + client.apellido + "&apodo=" + client.apodo + "&correo=" + client.correo + "&password=" + client.password, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    window.alert("SE REGISTRO CON EXITO!")
                    console.log('registered')

                    return window.location.href = "/index.html"

                })


            .catch(error => {
                "error a la creacion de cliente"
            });
        }

    }

})