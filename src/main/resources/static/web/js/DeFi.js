let app = new Vue({
    el: "#appDefi",
    data: {
        billetera: "",
        btc: "0",
        pesos: "0",
        type: "BTC_A_PESOS",
        montoEnPesos:"",
        montoEnBTC:"",
        cotizacionBTCPesos:"4000000"
    },
    created() {
        this.cargarUsuario();
    },
    methods: {
        cargarUsuario() {
            axios.get('/api/usuarios/current').then(response => {
                console.log(response.data)
                this.billetera = response.data.billetera;
                this.montoEnBTC=this.billetera.montoBTC;
                this.montoEnPesos=this.billetera.montoPesos;
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