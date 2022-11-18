import axios from  'axios';

// testeeee

// HABILIDADE
var url = 'http://localhost:8080/habilidades'
axios.get(url)
  .then((response) => {
    console.log('GET HABILIDADE:'+response);
  });

var url = 'http://localhost:8080/habilidades'
  axios.post(url, {
    name: 'fogo',
  })
  .then((response) => {
    console.log('POST HABILIDADE:'+response);
  });

  var url = 'http://localhost:8080/habilidades/1'
  axios.put(url, {
    name: 'voar',
  })
  .then((response) => {
    console.log('PUT HABILIDADE:'+response);
  });

var url = 'http://localhost:8080/habilidades/1'
  axios.delete(url)
  .then((response) => {
    console.log('DELETE HABILIDADE:'+response);
  });


//   ===============================

//  TREINADOR
var url = 'http://localhost:8080/treinadores'

axios.get(url)
  .then((response) => {
    console.log('GET TREINADOR:'+response);
  });

var url = 'http://localhost:8080/treinadores'
  axios.post(url, {
    name: 'Milena Alegre',
    xp: 2000
  })
  .then((response) => {
    console.log('POST TREINADOR:'+response);
  });

var url = 'http://localhost:8080/treinadores/1'
  axios.put(url, {
    name: 'Milena Barbosa Alegre',
    xp: 1200
  })
  .then((response) => {
    console.log('PUT TREINADOR:'+response);
  });


