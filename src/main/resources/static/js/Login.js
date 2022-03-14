var app1 = new Vue({
    el: '#app1',
    data: {
        correo: "",
        password: "",
    },

    methods: {
        iniciarSesion() {
            axios.
            post('/api/login', "email=" + this.correo + "&password=" + this.password, {
                headers: {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            })

            .then(response => {
                window.alert("USTED INGRESO A SU HOME BANKING")
                console.log('signed in!!!');
                return window.location.href = "/index.html"

            }).catch(error => {
                "error de correo o password"


            })

        }
    },

    logout() {
        axios.post(`/api/logout`)

        .then(response => console.log('signed out!!'))
            .then

        return (window.location.href = "/index.html")

    }




})