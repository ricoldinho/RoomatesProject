package edu.rico.roomates.services.interfaces;

import edu.rico.roomates.model.dtos.RoomateRequestDTO;
import edu.rico.roomates.model.dtos.RoomateResponseDTO;

public interface IRoomateService {
    public RoomateResponseDTO guardar(RoomateRequestDTO dto);
}
