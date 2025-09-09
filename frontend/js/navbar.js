// navbar.js

// Get the current page (e.g., index.html, donor.html, etc.)
let currentPage = window.location.pathname.split("/").pop();

// Default to index.html if no file is found
if (currentPage === "" || currentPage === "/") {
  currentPage = "index.html";
}

// Loop through nav links and set the active one
document.querySelectorAll("nav a").forEach(link => {
  if (link.getAttribute("href") === currentPage) {
    link.classList.add("text-yellow-500", "font-semibold");
    link.classList.remove("text-gray-700");
  }
});
