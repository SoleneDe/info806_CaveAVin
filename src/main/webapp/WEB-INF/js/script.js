var imgRep; // dossier où se trouvent les images
// bouteilles-page
// bouteille-page
function loadImgRep(rep)
{
    imgRep = rep;
}

// bouteilles-page
function afficherBouteilles()
{
    $.ajax({ 
        url: "/api/bouteilles", 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) { 
            $.each(data, function (i, item) {
                $("#listeBout").append("<li>" +
                        item.id + ". " + item.nom + ", " + item.region + ", " + item.annee +
                        "<img width='30px' height='30px' src='"+ imgRep + item.photo +"'></img>" +
                  "</li>");
            });
        },
        error: processError
    });
}

// bouteille-page
function afficherBouteille(id)
{
    $.ajax({ 
        url: "/api/bouteilles/"+id, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#bout").append(data.nom + ", " + data.region + ", " + data.annee);
            $("#bout").append("<img width='30px' height='30px' src='"+imgRep+data.photo+"'></img>");
                
        },
        error: processError
    });
}

// bouteille-page
function modifBouteille(id) {
    var paramsNames = ['nom', 'region', 'annee', 'photo'];
    var params = ['', '', '', ''];
    var strParams='';
    var isFirstParam = true;
    
    params[0] = $("#nom").val();
    params[1] = $("#region").val();
    params[2] = $("#annee").val();
    params[3] = $("#photo").val();
    
    for (var i=0; i<4; i++)
    {
        if (params[i] !== '')
        {
            if (!isFirstParam)
            {
                strParams = strParams + "&";
            }
            else
            {
                strParams = strParams + "?";
            }
            strParams = strParams + paramsNames[i] + "=" + params[i];
            isFirstParam = false;
        }   
    }
    
    $.ajax({ 
        url: "/api/bouteilles/"+id+strParams, 
        type: 'PUT', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#result").append("Modified");
        },
        error: processError
    });
    
}

// bouteille-page
function supprBouteille(id) {
    $.ajax({ 
        url: "/api/bouteilles/"+id, 
        type: 'DELETE', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#result").append("Deleted");
        },
        error: processError
    });
    
}

// casiers-page
function afficherCasiers() {
    $.ajax({ 
        url: "/api/casiers", 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) { 
            $.each(data, function (i, item) {
                $("#listeCas").append("<li>" +
                        item.id + ". " + item.nom +
                    "</li>");
          
                $("#listeCas").append("<ul id='casier"+ item.id +"'>");

                var idContenu = Object.keys(item.contenu);
                
                $.each(idContenu, function (j, id) {
                    afficherBouteillesDansCasier(id, item.contenu[id], "#casier"+item.id, false);

                });
                $("#casier"+item.id).append("</ul>");       
            });
        },
        error: processError
    });
}

// casier-page
function afficherCasier(id)
{
    $.ajax({ 
        url: "/api/casiers/"+id, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#casier").append(data.nom );
            
            var idContenu = Object.keys(data.contenu);
            $.each(idContenu, function (i, id) {
                afficherBouteillesDansCasier(id, data.contenu[id], "#casier", true);
            });
                
        },
        error: processError
    });
}

// casier-page
function supprCasier(id) {
    $.ajax({ 
        url: "/api/casiers/"+id, 
        type: 'DELETE', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#result").append("Deleted");
        },
        error: processError
    });
    
}

// casiers-page
function afficherBouteillesDansCasier(idBouteille, quantite, localisation, modifOK) {
    
    var qte = quantite;
    if (modifOK)
        qte = "<input type='number' id='qte"+ idBouteille +"' value='" + quantite + "'>";
   
    $.ajax({ 
        url: "/api/bouteilles/"+idBouteille, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) { 
            $(localisation).append("<li>" +
                    data.id + ". " + data.nom + ", " + data.region + ", " + data.annee + " | " + qte +
              "</li>");
        },
        error: processError
    });
    
}

// creerBouteille-page
function creerBouteille() {
    $.ajax({ 
        url: "/api/bouteilles?nom=" + $("#nom").val() + "&region=" + $("#region").val()
            + "&annee=" + $("#annee").val() + "&photo=" + $("#photo").val(), 
        type: 'POST', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#result").append("Done");
        },
        error: processError
    });
    
}

// creerCasier-page
function creerCasier() {
    $.ajax({ 
        url: "/api/casiers?nom=" + $("#nom").val(), 
        type: 'POST', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            $("#result").append("Done");
        },
        error: processError
    });
    
}

// casier-page
function modifQteDansCasier(idCasier) {
    // boucle for ? Récupérer les <li> ?
    // récupérer l'id de la bouteills
    // et le contenu de l'input sur la page
    // mettre à jour PUT api/casiers, w/ idB & idC & qte ?
    
}

function processError(data,status,er) { 
    alert("error: "+data[0]+" status: "+status+" er:"+er);
}