package edu.rico.roomates.services.interfaces;

import java.util.List;

import edu.rico.roomates.model.dtos.RoomateRequestDTO;
import edu.rico.roomates.model.dtos.RoomateResponseDTO;
import edu.rico.roomates.model.enums.Gender;

public interface IRoomateService {
    public RoomateResponseDTO guardar(RoomateRequestDTO dto);

    public List<RoomateResponseDTO> obtenerTodos();

    public RoomateResponseDTO obtenerPorId(Long id);

    public boolean eliminar(Long id);

    public RoomateResponseDTO actualizar(RoomateRequestDTO dto);

    public List<RoomateResponseDTO> buscarPorGenero(Gender genero);
}
