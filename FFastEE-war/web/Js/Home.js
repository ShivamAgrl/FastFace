function drop() {
    var options=document.getElementById("myDropdown");
    options.classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
//window.onclick = function(event) {
//  if (event.target.matches('.dropbtn')) {
//
//    var dropdowns = document.getElementById("myDropdown");
//    var i;
//    for (i = 0; i < dropdowns.length; i++) {
//      var openDropdown = dropdowns[i];
//      if (openDropdown.classList.contains('show')) {
//        openDropdown.classList.remove('show');
//      }
//    }
//  }
//};