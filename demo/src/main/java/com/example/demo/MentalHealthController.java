package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MentalHealthController {

    private List<MentalHealthResponse> responses = new ArrayList<>();

    @PostMapping("/mental-health-check")
    public ResponseEntity<MentalHealthResponse> evaluateMentalHealth(@RequestBody MentalHealthRequest request) {
        int puntaje = request.getAnimo() + request.getEstres() + request.getSueno() +
                      request.getApetito() + request.getMotivacion() + request.getInteraccionSocial();

        String mensaje;
        boolean contactarPsicologo = false;

        if (puntaje >= 12) {
            mensaje = "Parece que estás atravesando un momento difícil. Es importante buscar ayuda de un profesional de la salud mental.";
            contactarPsicologo = true;
        } else if (puntaje >= 7) {
            mensaje = "Tal vez te sientas un poco abrumado. Tómate un tiempo para relajarte y practicar el autocuidado.";
        } else {
            mensaje = "Parece que te encuentras bien. ¡Sigue manteniendo un equilibrio saludable en tu vida!";
        }

        MentalHealthResponse response = new MentalHealthResponse(request.getNombre(), request.getPosicion(), mensaje, contactarPsicologo);
        responses.add(response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employee-responses")
    public ResponseEntity<List<MentalHealthResponse>> getAllResponses() {
        return ResponseEntity.ok(responses);
    }

    // Historial simulado
    @GetMapping("/employee-response-history")
    public ResponseEntity<List<MentalHealthResponse>> getEmployeeResponseHistory(@RequestParam String nombre) {
        List<MentalHealthResponse> history = new ArrayList<>();
        for (MentalHealthResponse response : responses) {
            if (response.getNombre().equalsIgnoreCase(nombre)) {
                history.add(response);
            }
        }
        // Agregar datos simulados al historial
        history.add(new MentalHealthResponse(nombre, "Puesto simulado", "Mensaje anterior simulado", false));
        history.add(new MentalHealthResponse(nombre, "Puesto simulado", "Mensaje más antiguo simulado", true));
        return ResponseEntity.ok(history);
    }
}
