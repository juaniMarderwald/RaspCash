var app = new Vue({
    el: '#app',
    data: {
        usuario: {}
    },
    created() {
        this.cargarDatos();
    },

    methods: {
        cargarDatos() {
            axios.get('/api/usuario/current')
                .then(response => {
                    this.usuario = response.data;
                    this.cargarCarrito();
                }).catch(error => console.log(error.response.data))
                .finally(function () {
                    const preload = document.querySelector(".preload");
                    preload.style.visibility = "hidden";
                });
        },
        cargarCarrito(){
            axios.get(`/api/carrito/${app.usuario.id}`)
            .then(response => {
                console.log(response.data);
            })
        }
    }
})