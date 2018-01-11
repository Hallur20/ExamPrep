/* global fetch */

document.getElementById('btnsend').onclick = () => {
    var r = document.getElementById("region");
    var region = r.options[r.selectedIndex].value;

    var g = document.getElementById('gender');
    var gender = g.options[g.selectedIndex].value;
    region = fixRegion(region);
    gender = fixGender(gender);
    
    
    document.getElementById('amount').value +
            fetch('http://uinames.com/api/?amount=' +
                    document.getElementById('amount').value + region +
                    gender).then((response) => {
                        console.log(response);
if(response.status >= 400){
    alert("error: you requested more than 500 names");
}
        return response.json();
    }).then((json) => {
        console.log(json);
        var tableBody = makeTableBody(json);
        document.getElementById("tblbody").innerHTML =
                tableBody;
    });
};

document.getElementById('btnsql').onclick = () => {
    var tBody = document.getElementsByTagName("td");
    for(var i = 0; i < tBody.length; i++){
        if(tBody[i].innerHTML === "male" || tBody[i].innerHTML === "female"){
        tBody[i].innerHTML+="\n";
        }
       document.getElementById('sql').innerHTML+= tBody[i].innerHTML;
    }
};
    function makeTableBody(json) {
        var fill = "";
        for (var i = 0; i < json.length; i++) {
            fill += "<tr><td>" + json[i].name + "</td><td>" + json[i].surname + "</td> <td>" + json[i].gender + "</td></tr>";
        }
        return fill;
    }

    function fixRegion(r) {
        var str;
        if (r === "All") {
            str = "";
        } else {
            str = "&region=" + r;
        }
        return str;
    }
    function fixGender(g) {
        var str;
        if (g === "both") {
            str = "";
        } else {
            str = "&gender=" + g;
        }
        return str;
}