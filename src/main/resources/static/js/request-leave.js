// Get the modal
var modal = document.getElementById("leaveModal");
var userModal = document.getElementById("userModal"); // Burası "leaveModal" değil "userModal" olmalı


// Get the button that opens the modal
var btn = document.getElementById("addLeaveBtn");
var todaybtn = document.getElementById("todayLeavesBtn");

var okButton = document.getElementById("okButton");


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var userClose = document.getElementsByClassName("close-user")[0];


// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
    let modalContent = modal.querySelector(".modal-content");
    modalContent.classList.add("show");
}

todaybtn.onclick = function () {
    userModal.style.display = "block"; // Burada userModal açılıyor
    let modalContent = userModal.querySelector(".modal-content-user"); // Doğru modal content sınıfını seç
    modalContent.classList.add("show");
}


// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
    let modalContent = modal.querySelector(".modal-content");
    modalContent.classList.remove("show");
}

userClose.onclick = function () {
    userModal.style.display = "none";
    let modalContent = userModal.querySelector(".modal-content-user");
    modalContent.classList.remove("show");
}

okButton.onclick = function () {
    userModal.style.display = "none";
    let modalContent = userModal.querySelector(".modal-content-user");
    modalContent.classList.remove("show");
}

window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
        let modalContent = modal.querySelector(".modal-content");
        modalContent.classList.remove("show");
    } else if (event.target === userModal) { // Burada userModal kapatma kontrolü
        userModal.style.display = "none";
        let modalContent = userModal.querySelector(".modal-content-user");
        modalContent.classList.remove("show");
    }
}



// Get the modal
var descriptionModal = document.getElementById("descriptionModal");

// Get the button that opens the modal
var viewDescriptionBtns = document.querySelectorAll(".view-description-btn");

// Get the <span> element that closes the modal
var closeDescriptionSpan = document.getElementsByClassName("close-description")[0];

// Function to open the modal with the description
viewDescriptionBtns.forEach(function (btn) {
    btn.onclick = function () {
        document.getElementById("descriptionText").innerText = this.getAttribute("data-description");
        descriptionModal.style.display = "block";
    }
});

closeDescriptionSpan.onclick = function () {
    descriptionModal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target === descriptionModal) {
        descriptionModal.style.display = "none";
    }
}
