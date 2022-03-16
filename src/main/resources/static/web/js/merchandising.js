 app = new Vue({
    el: '#appMerchandising',
    data: {
        productos: []
    },
    created() {
        this.cargarDatos();
    },

    methods: {
        cargarDatos() {
            axios.get('/api/productos/merchandising')
                .then(response => {
                    this.productos = response.data;
                    console.log(this.productos);
                })
                .finally(function () {
                    const preload = document.querySelector(".preload");
                    preload.style.visibility = "hidden";
                });
        },
        agregarProductoAlCarrito(idProducto) {
            axios.post('/api/carrito/producto', `idProducto=${idProducto}`).then(response => {app.cargarDatos();
            alert(response.data)}).catch(error => {
                alert(error.response.data);
                if (error.response.data == "No hay un usuario logueado") {
                    window.location.href = "login.html"
                }
            })
        }
    }
})