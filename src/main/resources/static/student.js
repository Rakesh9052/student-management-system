function saveStudent() {

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        course: document.getElementById("course").value,
        age: Number(document.getElementById("age").value)
    };

    fetch("/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        alert("Student saved successfully!");
    })
    .catch(error => {
        console.error(error);
        alert("Error saving student");
    });
}