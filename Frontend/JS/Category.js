const endpointCat = "http://152.67.54.209:8081/api/Category/all";
const etpCat = document.getElementById("informacionCat");
/** capturar bones de categoria */
const bmostrarCat = document.getElementById("bmostrarCat");
const bguardarCat = document.getElementById("bguardarCat");
const bactualizarCat = document.getElementById("bactualizarCat");
const beliminarCat = document.getElementById("beliminarCat");
/** captura de los inputs de la interfaz html para categorias */
const idCat = document.getElementById("idCat");
const nameCat = document.getElementById("nameCat");
const descriptionCat = document.getElementById("descriptionCat");

/**
 * petición get para categorias
 */

function peticiongetCat() {
  $.ajax({
    method: "GET",
    url: endpointCat,
    success: function (data) {
      getCategoria(data);
      console.log(data);
    },
  });
}

function peticionpostCat() {
    $.ajax({
      method: "POST",
      url: "http://152.67.54.209:8081/api/Category/save",
      data: capturarcategoria(),
      datatype: "json",
      contentType: "application/json",
      complete: function (response) {
        mostrarResultadoCat(response.status, "Se guardó con exito");
        //console.log(response.status);
        limpiarCampoCat();
        peticiongetCat();
      },
    });
  }

  function peticionputCat() {
    $.ajax({
      method: "PUT",
      url: "http://152.67.54.209:8081/api/Category/update",
      data: capturarcategoria(),
      datatype: "json",
      contentType: "application/json",
      complete: function (response) {
        mostrarResultadoCat(response.status, "Se guardó con exito");
        //console.log(response.status);
        limpiarCampoCat();
        peticiongetCat();
      },
    });
  }

  function peticionDeleteCat() {
    $.ajax({
      method: "DELETE",
      url:"http://152.67.54.209:8081/api/Category/delete" ,
      data: captIdCat(),
      datatype: "json",
      contentType: "application/json",
      complete: function (response) {
        resultadoEliminarCat(response.status);
        limpiarCampoCat();
        peticiongetCat();
      },
    });
  }


function getCategoria(categorias) {
  let myTable = "<table>";
  for (i = 0; i < categorias.length; i++) {
    myTable += "<tr>";
    myTable +=
      "<td>" + "<strong> id :</strong> " + categorias[i].id + "</td>";
    myTable +=
      "<td>" + "<strong> name :</strong> " + categorias[i].name + "</td>";
    myTable +=
      "<td>" +
      "<strong>description  :</strong>  " +
      categorias[i].description+
      "</td>";
    myTable += "</tr>";
  }
  myTable += "</table>";
  $("#informacionCat").html(myTable);
}

function capturarcategoria() {
    const data = {
        id: $("#idCat").val(),
        name: $("#nameCat").val(),
        description: $("#descriptionCat").val(),
    };
    return JSON.stringify(data);
  }

  function mostrarResultadoCat(status, texto) {
    let mensaje = "";
    if (status == 201) {
      mensaje = texto;
    } else if (status == 204) {
      mensaje = "El registro existe";
    }
    alert(mensaje);
  }

function limpiarCampoCat() {
  idCat.value = "";
  nameCat.value = "";
  descriptionCat.value = "";
}
function validarCampoCat() {
  if (descriptionCat.value == "" || nameCat.value == "") {
    return true;
  } else {
    return false;
  }
}

function captIdCat() {
  const data = {
    id: idCat.value,
  };
  return JSON.stringify(data);
}

function resultadoEliminarCat(status) {
  if (status == 204) {
    alert("Registro eliminado");
  }
}

function validarCampoEliCat() {
  if (idCat.value == "") {
    return true;
  } else {
    return false;
  }
}


bmostrarCat.addEventListener("click", (e) => {
  e.preventDefault();
  peticiongetCat();
});

bguardarCat.addEventListener("click", (e) => {
    e.preventDefault();
    if (validarCampoCat()) {
      alert("campo(s) Vacio!!");
    } else {
      console.log(capturarcategoria());
      peticionpostCat();
    }
  });

  bactualizarCat.addEventListener("click", (e) => {
    e.preventDefault();
    if (validarCampoCat()) {
      alert("Campo(s) vacio!!");
    } else {
      peticionputCat();
    }
  });


  beliminarCat.addEventListener("click", (e) => {
    e.preventDefault();
    if (validarCampoEliCat()) {
      alert("Campo id Vacio!!");
    } else {
      peticionDeleteCat();
    }
  });

