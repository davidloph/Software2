document.addEventListener("DOMContentLoaded", async () => {
    const grupoId = sessionStorage.getItem("grupoSeleccionado");
    const profesorId = sessionStorage.getItem("profesorId");

    if (!grupoId) {
        alert("No se encontró el grupo seleccionado. Por favor, vuelve a seleccionarlo.");
        window.location.href = "SeleccionGrupo.html";
        return;
    }

    if (!profesorId) {
        alert("No se encontró el ID del profesor. Asegúrate de iniciar sesión correctamente.");
        window.location.href = "index.html";
        return;
    }

    const sesionSelect = document.getElementById("sesionSelect");
    const tablaBody = document.querySelector("#tablaEstudiantes tbody");
    const btnRegistrar = document.getElementById("btnRegistrar");

    let estudiantes = [];

    async function cargarSesiones() {
        try {
            const response = await fetch("http://localhost:8080/asisteuco/apigateway/obtenerSesiones", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ grupo: grupoId })
            });

            const data = await response.json();
            data.sesiones.forEach(s => {
                const option = document.createElement("option");
                option.value = s.id;
                option.textContent = new Date(s.fechaHora).toLocaleString("es-CO");
                sesionSelect.appendChild(option);
            });
        } catch (error) {
            alert("Error al cargar las sesiones.");
            console.error(error);
        }
    }

    async function cargarEstudiantes() {
        try {
            const response = await fetch("http://localhost:8080/asisteuco/apigateway/obtenerEstudiantes", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ grupo: grupoId })
            });

            const data = await response.json();
            estudiantes = data.estudiantes;

            data.estudiantes.forEach(est => {
                const fila = document.createElement("tr");

                fila.innerHTML = `
                    <td>${est.tipoIdentificacion}</td>
                    <td>${est.numeroIdentificacion}</td>
                    <td>${est.nombresCompletos}</td>
                    <td>
                        <select data-id="${est.id}" class="asistenciaSelect">
                            <option value="">--</option>
                            <option value="true">Sí</option>
                            <option value="false">No</option>
                        </select>
                    </td>
                `;

                tablaBody.appendChild(fila);
            });
        } catch (error) {
            alert("Error al cargar los estudiantes.");
            console.error(error);
        }
    }

    btnRegistrar.addEventListener("click", async () => {
        const sesionId = sesionSelect.value;
        if (!sesionId) {
            alert("Selecciona una sesión antes de continuar.");
            return;
        }

        const selects = document.querySelectorAll(".asistenciaSelect");
        const asistencia = [];

        for (let select of selects) {
            const id = select.dataset.id;
            const valor = select.value;

            if (valor === "") {
                alert("Debes seleccionar asistencia para todos los estudiantes.");
                return;
            }

            asistencia.push({
                id: id,
                asistio: valor === "true"
            });
        }

        try {
            const response = await fetch("http://localhost:8080/asisteuco/apigateway/asistencias", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    sesion: sesionId,
                    profesor: profesorId,
                    estudiantes: asistencia
                })
            });

            const data = await response.json();

            if (data.messages && data.messages.length > 0) {
                mostrarModalErrores(data.messages);
            } else {
                alert("✅ Asistencia registrada exitosamente.");
                location.reload();
            }
        } catch (error) {
            alert("Error al registrar la asistencia.");
            console.error(error);
        }
    });

    function mostrarModalErrores(mensajes) {
        const modal = document.getElementById("modalErrores");
        const lista = document.getElementById("listaErrores");
        lista.innerHTML = "";
        mensajes.forEach(msg => {
            const li = document.createElement("li");
            li.textContent = msg;
            lista.appendChild(li);
        });
        modal.classList.remove("hidden");
    }

    window.cerrarModal = () => {
        document.getElementById("modalErrores").classList.add("hidden");
    };

    await cargarSesiones();
    await cargarEstudiantes();
});
