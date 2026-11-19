package edu.rico.roomates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.rico.roomates.model.dtos.RoomateRequestDTO;
import edu.rico.roomates.model.dtos.RoomateResponseDTO;
import edu.rico.roomates.services.interfaces.IRoomateService;

@RestController
@RequestMapping("/api/roomates")
public class RoomateRestController {

    @Autowired
    private IRoomateService roomateService;

    // CRRUD operations will be implemented here in the future
    // create => método .save() en el repository
    @PostMapping("/create")
    public ResponseEntity<RoomateResponseDTO> guardar(@RequestBody RoomateRequestDTO dto) {
        // Aquí puedes implementar la lógica para guardar el Roomate en la base de datos
        RoomateResponseDTO rResponseDTO = roomateService.guardar(dto);
        return ResponseEntity.created(null).body(rResponseDTO);
    }

    // read => método .findAll() en el repository
    @GetMapping("/all")
    public ResponseEntity<List<RoomateResponseDTO>> obtenerTodos() {

        return ResponseEntity.ok(roomateService.obtenerTodos());
    }

    // read2 => método .findById() en el repository
    // update => método .save() en el repository
    // delete => método .delete() en el repository

}
