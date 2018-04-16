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
        //$("#bouteille").css("height", height+"px");
        $("#informationsBouteille").css("top", (height/2)-100+"px");
    }, 200);
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
                var qteB = Object.values(item.contenu);
                var res = 0;
                for(let j = 0 ; j < qteB.length ; j++){
                    res += qteB[j];
                }
                $("#casiers").append("<li id='casier"+ item.id +"' class='casier'><a href='./casiers/"+item.id+"'>" +
                        item.id + ". " + item.nom +
                    " : "+ res +" bouteilles</a></li>");  
            });
        },
        error: processError
    });
}

// casier-page
function afficherCasier(id)
{
	console.log(id);
    $.ajax({ 
        url: "/api/casiers/"+id, 
        type: 'GET', 
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(data) {
        	console.log(data);
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

function afficherBouteilleDansCasier(idBouteille, quantite, localisation) {
	console.log("../../api/bouteilles/"+idBouteille);
    $.ajax({ 
        url: "../../api/bouteilles/"+idBouteille, 
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