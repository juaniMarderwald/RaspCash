/* 
let endpoint = 'https://api.coingecko.com/api/v3/coins'
fetch(endpoint)
    .then( respuesta => respuesta.json() )
    .then( datos => mostrarData(datos))
    .catch( e => console.log(e))
    

const mostrarData = (data)=>{
    //console.log(data)
    let body = ''
    for (let i=0; i < 10; i++) {
        body += `<tr><td>${data[i].symbol}</td><td><img src="${data[i].image.small}" /></td><td>${data[i].market_data.current_price.usd}</td></tr>`
        console.log(data[i]);
    }
    document.getElementById('data').innerHTML = body
}     */



const url = `https://apipetshop.herokuapp.com/api/articulos`
fetch(url)
    .then(respuesta => respuesta.json())
    .then(datos => mostrarDatos(datos))
    .catch(e => console.log(e))

const mostrarDatos = (data) => {
    for (let i = 0; i < 10; i++) {

        console.log(data.response[i].imagen);
    }
}
