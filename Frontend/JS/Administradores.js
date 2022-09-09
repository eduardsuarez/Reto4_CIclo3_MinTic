const endpointAdm = "http://152.67.54.209:8081/api/Admin/all";
const etpAdm = document.getElementById("informacionAdm");
/** capturar bones decliente */
const bmostrarAdm = document.getElementById("bmostrarAdm");
const bguardarAdm = document.getElementById("bguardarAdm");
const bactualizarAdm = document.getElementById("bactualizarAdm");
const beliminarAdm = document.getElementById("beliminarAdm");
/** captura de los inputs de la interfaz html para administradores */
const idAdm = document.getElementById("idAdm");
const nameAdm = document.getElementById("nameAdm");
const emailAdm = document.getElementById("emailAdm");
const passwordAdm = document.getElementById("passwordAdm");

/**
 * petición get para administradores
 */

function peticiongetAdm() {
  $.ajax({
    method: "GET",
    url: endpointAdm,
    success: function (data) {
      getAdmin(data);
    },
  });
}

function peticionpostAdm() {
  $.ajax({
    method: "POST",
    url: "http://152.67.54.209:8081/api/Admin/save",
    data: capturarAdministradores(),
    datatype: "json",
    contentType: "application/json",
    complete: function (response) {
      mostrarResultadoAdm(response.status, "Se guardó con exito");
      //console.log(response.status);
      limpiarCampoAdm();
      peticiongetAdm();
    },
  });
}

function peticionputAdm() {
  $.ajax({
    method: "PUT",
    url: "http://152.67.54.209:8081/api/Admin/update",
    data: capturarAdministradores(),
    datatype: "json",
    contentType: "application/json",
    complete: function (response) {
      mostrarResultadoAdm(response.status, "Se guardó con exito");
      //console.log(response.status);
      limpiarCampoAdm();
      peticiongetAdm();
    },
  });
}

function peticionDeleteAdm() {
  $.ajax({
    method: "DELETE",
    url: "http://152.67.54.209:8081/api/Admin/delete",
    data: captIdAdm(),
    datatype: "json",
    contentType: "application/json",
    complete: function (response) {
      resultadoEliminarAdm(response.status);
      limpiarCampoAdm();
      peticiongetAdm();
    },
  });
}

function getAdmin(administradores) {
  let myTable = "<table>";
  for (i = 0; i < administradores.length; i++) {
    myTable += "<tr>";
    myTable +=
      "<td>" + "<strong>id: </strong>" + administradores[i].id + "</td>";
    myTable +=
      "<td>" + "<strong>email: </strong>" + administradores[i].email + "</td>";
    myTable +=
      "<td>" + "<strong>password:  </strong>" + administradores[i].password + "</td>";
    myTable +=
      "<td>" + "<strong>name:  </strong>" + administradores[i].name + "</td>";
    myTable += "</tr>";
  }
  myTable += "</table>";
  $("#informacionAdm").html(myTable);
}

function capturarAdministradores() {
  const data = {
    id: $("#idAdm").val(),
    email: $("#emailAdm").val(),
    password: $("#passwordAdm").val(),
    name: $("#nameAdm").val(),
  };
  return JSON.stringify(data);
}

function mostrarResultadoAdm(status, texto) {
  let mensaje = "";
  if (status == 201) {
    mensaje = texto;
  } else if (status == 204) {
    mensaje = "El registro existe";
  }
  alert(mensaje);
}

function limpiarCampoAdm() {
  idAdm.value ="";
  nameAdm.value = "";
  emailAdm.value = "";
  passwordAdm.value = "";
}

function validarCampoAdm() {
  if (
    passwordAdm.value == "" ||
    nameAdm.value == "" ||
    emailAdm.value == ""
  ) {
    //console.log(nameAdm.value);
    return true;
  } else {
    return false;
  }
}


function captIdAdm() {
  const data = {
    id: idAdm.value,
  };
  return JSON.stringify(data);
}

function resultadoEliminarAdm(status) {
  if (status == 204) {
    alert("Registro eliminado");
  }
}

function validarCampoEliAdm() {
  if (idAdm.value == "") {
    return true;
  } else {
    return false;
  }
}


bmostrarAdm.addEventListener("click", (e) => {
  e.preventDefault();
  peticiongetAdm();
});

bguardarAdm.addEventListener("click", (e) => {
  e.preventDefault();
  if (validarCampoAdm()) {
    alert("campo(s) Vacio!!");
  } else {
    peticionpostAdm();
  }
});

bactualizarAdm.addEventListener("click", (e) => {
  e.preventDefault();
  if (validarCampoAdm()) {
    alert("Campo(s) vacio!!");
  } else {
    peticionputAdm();
  }
});


beliminarAdm.addEventListener("click", (e) => {
  e.preventDefault();
  if (validarCampoEliAdm()) {
    alert("Campo id Vacio!!");
  } else {
    peticionDeleteAdm();
  }
});

