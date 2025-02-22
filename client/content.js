const URL = "http://localhost:8080/api/v1/courses";
const SCHOOL = "The Ohio State University";
const DEPARTMENT = "CSE";
const box = document.createElement("div");

box.classList.add("box", "hidden");
document.body.appendChild(box);

document.addEventListener("dblclick", (e) => {
    const selectedTxt = window.getSelection()?.toString() ?? "";

    box.classList.remove("hidden");
    box.textContent = DEPARTMENT + " " + selectedTxt;
});

document.body.addEventListener("click", (e) => {
    if (e.target === box) {
        return;
    }

    box.classList.add("hidden");
});