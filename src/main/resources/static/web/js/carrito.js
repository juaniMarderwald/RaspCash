var app = new Vue({
    el: '#app',
    data: {
        carrito: {},
        productos: {}
    },
    created() {
        this.cargarDatos();
    },

    methods: {
        cargarDatos() {
            axios.get('/api/carrito/current')
                .then(response => {
                    this.carrito = response.data;
                    this.productos = this.carrito.productos;
                    console.log(response.data);
                }).catch(error => console.log(error.response.data))
                .finally(function () {
                    const preload = document.querySelector(".preload");
                    preload.style.visibility = "hidden";
                });
        }
    }
})