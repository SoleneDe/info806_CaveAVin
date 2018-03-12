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
                $("#bouteilles").append("<li class='bouteille'><a href='./bouteilles/"+item.id+"'>" +
                        item.id + ". " + item.nom + ", " + item.region + ", " + item.annee +
                        " <img width='30px' height='30px' src='"+ imgRep + item.photo +"'></img>" +
                  "</a></li>");
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
            document.title = data.nom;
            $("#nom").append(data.nom);
            $("#origine").append(data.region);
            $("#annee").append(data.annee);
            $("#image").append("<img id='photo' src='"+imgRep+data.photo+"' alt='" + data.photo + "'></img>");
                
        },
        error: processError
    });
    setTimeout(function(){
        let height = $("#image").height();
        let tHeight = $("#nom").height();
        $("#bouteille").css("height", height+"px");
        $("#informationsBouteille").css("top", (height/2)-100+"px");
    }, 80);
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
                $("#casiers").append("<li><a href='./casiers/"+item.id+"'>" +
                        item.id + ". " + item.nom +
                    "</a></li>");
          
                $("#casiers").append("<ul id='casier"+ item.id +"' class='casier'>");

                var idContenu = Object.keys(item.contenu);
                
                $.each(idContenu, function (j, id) {
                    afficherBouteilleDansCasier(id, item.contenu[id], "#casier"+item.id);

                });
                $("#casier"+item.id).append("</ul>");       
            });
        },
        error: processError
    });
}

// bouteille-page
function afficherCasier(id)
{
    $.ajax({ 
        url: "/api/casiers/"+id, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
            document.title = data.nom;
            $("#nom").append(data.nom);
            
            var idContenu = Object.keys(data.contenu);
            $.each(idContenu, function (i, id) {
                afficherBouteilleDansCasier(id, data.contenu[id], "#casier");
            });
                
        },
        error: processError
    });
}

// casiers-page
function afficherBouteilleDansCasier(idBouteille, quantite, localisation) {
    
    $.ajax({ 
        url: "/api/bouteilles/"+idBouteille, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) { 
            $(localisation).append("<li class='bouteille'><a href='../bouteilles/"+data.id+"'>" +
                    data.nom + ", " + data.region + ", " + data.annee + "</a> | qte : " + quantite +
              "</li>");
        },
        error: processError
    });
    
}

function processError(data,status,er) { 
    alert("error: "+data[0]+" status: "+status+" er:"+er);
}