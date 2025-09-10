document.addEventListener("DOMContentLoaded", () => {
  // Get the current path, then only the filename (e.g., index.html)
  let path = window.location.pathname;
  const currentPage = path.substring(path.lastIndexOf('/') + 1).toLowerCase() || "index.html";

  // Select all navbar links
  document.querySelectorAll("nav a").forEach(link => {
    const hrefFile = link.getAttribute("href").split("/").pop().toLowerCase();

    // Skip login button
    if (hrefFile === "login.html") return;

    // Add highlight if current page
    if (hrefFile === currentPage) {
      link.classList.add("text-yellow-500", "font-semibold");
      link.classList.remove("text-gray-700", "hover:text-green-600");
    }
  });
});
