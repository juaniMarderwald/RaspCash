var appDeFi = new Vue({
        el: "#appDeFi",
        data: {
            direccionBilletera: "",
            montoPesos: "",
            montoEnBTC: "",
            tipoDeSwap: "",

            monto: "",
            cuotas: "",
            billeteraDestino: "",
            nombrePrestamo: "",

            prestamo: [],
            cuotas: [],
            cargarCuotas: "",
            billeteraReceptor: []
        },
        created() {
            this.cargarCuentas()
            this.cargarCuotas()
        },

        methods: {
            cargarCuotas() {
                axios.get("/api/prestamos")
                    .then(response => {
                        this.prestamo = response.data
                        this.cuotas = this.cuotas.filter(cuota => cuota.nombre == this.cargarCuotas)
                        this.cuotas = this.cuotas[0].cuotas
                        console.log(this.payments)

                        // this.payments = response.data[0].payments
                    })
                    .catch(error => {
                        "error"
                    });
            },

            cargarCuentas() {
                axios.get("/api/usuarios/current")
                    .then(response => {
                        this.billeteraReceptor = response.data.billetera
                        console.log(this.billeteraReceptor)
                    })
                    .catch(error => {
                        "error"
                    });
            },

            metodoSwap() {
                axios.post("/api/transaccion/swap", "direccionBilletera=" + this.direccionBilletera + "&montoPesos=" + thi.montoPesos + "&montoEnBTC=" + this.montoEnBTC + "&tipoDeSwap=" + this.tipoDeSwap)
                    .then
                window.alert("Transaccion realizada!!")
            },
            pedirPrestamo() {
                axio.post("/api/prestamos", {
                    "monto": this.monto,
                    "cuotas ": this.cuotas,
                    "billeteraDestino": this.billeteraDestino,
                    "nombrePrestamo ": this.nombrePrestamo
                })
            }
        }

    }









)