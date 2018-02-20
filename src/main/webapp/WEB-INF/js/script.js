function afficherBouteilles() {
        $.ajax({ 
            url: "/api/bouteilles", 
            type: 'GET', 
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data) { 
                $.each(data, function (i, item) {
                    $("#listeBout").append("<li>" +
                            item.nom + ", " + item.region + ", " + item.annee +
                      "</li>");
                });

            },
            error:function(data,status,er) { 
                alert("error: "+data[0]+" status: "+status+" er:"+er);
            }
        });
    }