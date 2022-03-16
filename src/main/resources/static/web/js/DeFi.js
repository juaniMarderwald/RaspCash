var appDeFi = new Vue({
    el: "#appDeFi",
    data: {
        direccionBilletera: "",
        montoPesos: "",
        montoEnBTC: "",
        tipoDeSwap: "",

        monto: "",
        cuotas: [],
        billeteraDestino: [],
        nombrePrestamo: [],

    },
    created() {

    },
    methods: {
        metodoSwap() {
            axios.post("/api/transaccion/swap", "direccionBilletera=" + this.direccionBilletera + "&montoPesos=" + thi.montoPesos + "&montoEnBTC=" + this.montoEnBTC + "&tipoDeSwap=" + this.tipoDeSwap)
                .then
            window.alert("Transaccion realizada!!")
        },
        pedirPrestamo() {
            axio.post("/api/prestamo" {
                "monto": this.monto,
                "cuotas ": this.cuotas,
                "billeteraDestino": this.billeteraDestino,
                "nombrePrestamo ": this.nombrePrestamo
            })
        }
    }

}









})