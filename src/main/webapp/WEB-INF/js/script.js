var imgRep; // dossier où se trouvent les images
function loadImgRep(rep)
{
    imgRep = rep;
}

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
        error:function(data,status,er) { 
            alert("error: "+data[0]+" status: "+status+" er:"+er);
        }
    });
}

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
        error:function(data,status,er) { 
            alert("error: "+data[0]+" status: "+status+" er:"+er);
        }
    });
}

function afficherCasiers()
{
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
            });

        },
        error:function(data,status,er) { 
            alert("error: "+data[0]+" status: "+status+" er:"+er);
        }
    });
}