var app = new Vue({
    el: '#app',
    data: {
        nfts: {}
    },
    created() {
        this.cargarDatos();
    },

    methods: {
        cargarDatos() {
            axios.get('/api/productos/nfts')
                .then(response => {
                    console.log(response.data);
                    this.nfts = response.data;
                })
                .finally(function () {
                    const preload = document.querySelector(".preload");
                    preload.style.visibility = "hidden";
                });
        }
    }
})