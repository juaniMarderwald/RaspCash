var appBilletera = new Vue({
    el: "#billetera",
    data: {
        billetera: [],
        tipoDeMoneda: "",
        monto: "",
        billeteraEmisora: "",
        billeteraReceptora: "",
        descripcion: ""
    },
    created() {
        this.obtenerBilletera()
    },
    methods: {
        obtenerBilletera() {
            axios.get('/api/usuarios/current')
                .then(response => {
                    console.log(response.data)
                    this.billetera = response.data.billetera
                    console.log(this.billetera)
                })
        },
        transaccion() {
            axios.post('/api/usuarios/current', "tipoDeMoneda=" + this.tipoDeMoneda + "&monto=" + this.monto + "&direccionBilleteraEmisora=" + this.billeteraEmisora + "&direccionBilleteraReceptora" + this.billeteraReceptora + "&descripcion" + this.descripcion)
                .then(response => {
                    window.alert("compra hecha exitosamente!!!")
                })
        }
    }





})