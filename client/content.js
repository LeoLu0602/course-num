document.addEventListener("dblclick", (e) => {
    const selected = window.getSelection()?.toString() ?? "";

    console.log(selected);
});