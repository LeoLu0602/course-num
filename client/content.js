const URL = "http://localhost:8080/api/v1/courses";
const SCHOOL = "The Ohio State University";
const DEPARTMENT = "CSE";
const box = document.createElement("div");

box.classList.add("box", "hidden");
document.body.appendChild(box);

document.addEventListener("dblclick", async (e) => {
    const selectedTxt = window.getSelection()?.toString() ?? "";
    const num = Number(selectedTxt);

    // Only call API and show box if selectedTxt is a number.
    if (Number.isNaN(num)) {
        return;
    }

    box.classList.remove("hidden");
    box.textContent = "Searching..."

    /*
        Why URLSearchParams?

        URLSearchParams is a built-in JavaScript interface 
        that makes it easier to work with query parameters in URLs. 
        Instead of manually parsing and constructing query strings, 
        URLSearchParams provides convenient methods to manipulate them.
    */
   try {
        const res = await fetch(
            URL + 
            "?" + 
            new URLSearchParams({
                school: SCHOOL,
                department: DEPARTMENT,
                num
            }).toString(),
            {
                headers: {
                    'Content-Type': 'application/json'
                },
            }
        );

        if (!res.ok) {
            box.textContent = "Not found";

            return;
        }


        const { title } = await res.json();
        
        box.textContent = DEPARTMENT + " " + num + " " + title;
    } catch (err) {
        console.error("Fetching error: ", err);
        box.textContent = "Error!"
    }
});

document.body.addEventListener("click", (e) => {
    if (e.target === box) {
        return;
    }

    box.classList.add("hidden");
});