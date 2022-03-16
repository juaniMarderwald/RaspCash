var appDeFi = new Vue({
    el: "#appDeFi",
    data: {
        direccionBilletera: "",
        montoPesos: "",
        montoEnBTC: "",
        tipoDeSwap: ""

    },
    created() {

    },
    methods: {
        metodoSwap() {
            axios.post("/api/transaccion/swap")
        }
    }









})