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
            axios.post("/api/transaccion/swap", "direccionBilletera=" + this.direccionBilletera + "&montoPesos=" + thi.montoPesos + "&montoEnBTC=" + this.montoEnBTC + "&tipoDeSwap=" + this.tipoDeSwap)
                .then
            window.alert("Transaccion realizada!!")
        }
    }









})