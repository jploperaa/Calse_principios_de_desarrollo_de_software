function evaluarSaludMental() {
    const nombre = document.getElementById("nombre").value;
    const posicion = document.getElementById("posicion").value;

    
    if (!nombre || !posicion) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    
    const data = {
        nombre: nombre,
        posicion: posicion,
        animo: parseInt(document.querySelector('input[name="animo"]:checked')?.value) || 0,
        estres: parseInt(document.querySelector('input[name="estres"]:checked')?.value) || 0,
        sueno: parseInt(document.querySelector('input[name="sueno"]:checked')?.value) || 0,
        apetito: parseInt(document.querySelector('input[name="apetito"]:checked')?.value) || 0,
        motivacion: parseInt(document.querySelector('input[name="motivacion"]:checked')?.value) || 0,
        interaccionSocial: parseInt(document.querySelector('input[name="interaccionSocial"]:checked')?.value) || 0,
    };

    
    fetch("http://localhost:8080/api/mental-health-check", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        document.getElementById("resultado").innerHTML = `
            <h2>Resultados del Chequeo de Salud Mental:</h2>
            <p><strong>Nombre:</strong> ${result.nombre}</p>
            <p><strong>Posición:</strong> ${result.posicion}</p>
            <p>${result.mensaje}</p>
        `;
    })
    .catch(error => console.error("Error:", error));
}
