// Get the modal
var modal = document.getElementById("leaveModal");

// Get the button that opens the modal
var btn = document.getElementById("addLeaveBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// Get the user list select element
var userlist = document.getElementById("userlist");

// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
    var modalContent = modal.querySelector(".modal-content");
    modalContent.classList.add("show");
    // Fetch users when the modal is opened
    fetchUsers();
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
    var modalContent = modal.querySelector(".modal-content");
    modalContent.classList.remove("show");
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target === modal) {
        modal.style.display = "none";
        var modalContent = modal.querySelector(".modal-content");
        modalContent.classList.remove("show");
    }
}

// Function to fetch users from REST API
function fetchUsers() {
    var apiUrl = "/users/api"; // Replace with your actual API endpoint

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(users => {
            populateUserList(users);
        })
        .catch(error => {
            console.error("There was a problem with the fetch operation:", error);
        });
}

// Function to populate the user list in the select element
function populateUserList(users) {
    // Clear any existing options
    userlist.innerHTML = '';

    // Add default option
    var defaultOption = document.createElement("option");
    defaultOption.text = "Select User";
    defaultOption.value = "";
    defaultOption.disabled = true;
    defaultOption.selected = true;
    userlist.appendChild(defaultOption);

    // Add user options
    users.forEach(user => {
        var option = document.createElement("option");
        option.text = user.id + " " + user.name + " " + user.surname + " " + (user.role === 1 ? "admin" : "user"); // or user.username, etc.
        option.value = user.id; // or any unique identifier
        userlist.appendChild(option);
    });
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
        var descriptionText = this.getAttribute("data-description");
        document.getElementById("descriptionText").innerText = descriptionText;
        descriptionModal.style.display = "block";
    }
});

// When the user clicks on <span> (x), close the modal
closeDescriptionSpan.onclick = function () {
    descriptionModal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target === descriptionModal) {
        descriptionModal.style.display = "none";
    }
}