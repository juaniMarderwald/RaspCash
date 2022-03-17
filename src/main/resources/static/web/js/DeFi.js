let app = new Vue({
    el: "#app",
    data: {
        billetera: "",
        btc: "",
        pesos: "",
        type: "PESOS_A_BTC"
    },
    created() {
        this.cargarUsuario();
    },
    methods: {
        cargarUsuario() {
            axios.get('/api/usuarios/current').then(response => {
                console.log(response.data)
                this.billetera = response.data.billetera;
            }).catch(
                error => {
                    Swal.fire("Inicie sesión");
                    window.location.href = "/index.html"
                }
            );
        },
        realizarSwap() {
            axios.post('/api/transaccion/swap', `direccionBilletera=${this.billetera.direccion}&montoEnPesos=${this.pesos}&montoEnBTC=${this.btc}&tipoDeSwap=${this.type}`)
                .then(response => Swal.fire(response.data))
                .catch(error => Swal.fire(error.response.data));
        }
    }
}

)