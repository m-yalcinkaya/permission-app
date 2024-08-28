// Get the modal
var modal = document.getElementById("leaveModal");

// Get the button that opens the modal
var btn = document.getElementById("addUserButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
    var modalContent = modal.querySelector(".modal-content");
    modalContent.classList.add("show");
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
    var modalContent = modal.querySelector(".modal-content");
    modalContent.classList.remove("show");
}


window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
        var modalContent = modal.querySelector(".modal-content");
        modalContent.classList.remove("show");
    }
}