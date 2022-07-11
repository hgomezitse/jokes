var jwt = localStorage.getItem("jwt");

if (jwt != null) {
  window.location.href = './index.html'
}
function logout(){
  window.location.replace("index.html");
}

function registrar() {
  const usern = document.getElementById("username").value;
  const passw = document.getElementById("password").value;

  let _datos = {
    mail: document.getElementById("username").value,
    pass: document.getElementById("password").value
  }
const url = "http://localhost:8080/usuarios/";
fetch(url, {
    method: "POST",
    body: JSON.stringify(_datos),
    headers: {"Content-type": "application/json; charset=UTF-8"}
  })
.then((resp) => resp.text())
.then(function(data) {
  console.log(data);
if(data !== "hg")
{
    alert("User Saved Succesfully ")
    //document.getElementById('GFG').innerHTML = data;
}
else{alert("Error, try again.");}
})
.catch(function(error) {
console.log("Error: "+error);
});
return false;
}

function login() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  const url = "http://localhost:8080/usuarios/login?mail="+username+"&password="+password;
  fetch(url)
.then((resp) => resp.json())
.then(function(data) {
    console.log(data.idCreado);
  if(data.idCreado !== null)
  {
    window.location.replace("principal.html?"+data.idCreado);
  }
  else{alert("Sucedió un error");}
})
.catch(function(error) {
  console.log(error);
});
  return false;
}

function getJoke() {
 
    const url = "http://localhost:8080/chistesUsuarios/random";
    fetch(url)
  .then((resp) => resp.text())
  .then(function(data) {
      console.log(data);
    if(data !== null)
    {
        //console.log("Entro "+data)
        document.getElementById('GFG').innerHTML = data;
        document.getElementById('saveFav').style.display='block';
        document.getElementById('saveFav').style.visibility='visible';
        
    }
    else{alert("Sucedió un error");}
  })
  .catch(function(error) {
    console.log("Error Hg: "+error);
  });
    return false;
  }

  function favoritos() {
    let _datos = {
        texto: document.getElementById('GFG').innerHTML,
        user: location.search.substring(1)
      }
    const url = "http://localhost:8080/chistesUsuarios/";
    fetch(url, {
        method: "POST",
        body: JSON.stringify(_datos),
        headers: {"Content-type": "application/json; charset=UTF-8"}
      })
  .then((resp) => resp.text())
  .then(function(data) {
      console.log(data);
    if(data !== null)
    {
        alert("Joke Saved Succesfully ")
        //document.getElementById('GFG').innerHTML = data;
    }
    else{alert("Sucedió un error");}
  })
  .catch(function(error) {
    console.log("Error Hg: "+error);
  });
    return false;
  }

  
  function listarFavoritos() {
    let _datos = {
        texto: document.getElementById('GFG').innerHTML,
        user: location.search.substring(1)
      }
    const url = "http://localhost:8080/chistesUsuarios/?id="+location.search.substring(1);
    fetch(url)
    .then((resp) => resp.json())
    .then(function(data) {
        console.log(data);
        let body = ""
      if(data !== null)
      {
       
        document.getElementById('data').innerHTML = `<tr><td></td></tr>`; 
        data.forEach(agregarALista);
          //console.log("Entro "+data)
          //document.getElementById('GFG').innerHTML = data;
      }
      else{alert("Sucedió un error");}
    })
    .catch(function(error) {
      console.log("Error Hg: "+error);
    });
      return false;
    }

  function agregarALista(item){
    document.getElementById('data').innerHTML += `<tr><td>${item.texto}</td></tr>`;
  }