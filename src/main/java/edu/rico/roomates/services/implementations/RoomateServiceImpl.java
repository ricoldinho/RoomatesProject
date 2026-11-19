package edu.rico.roomates.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.roomates.model.dtos.RoomateRequestDTO;
import edu.rico.roomates.model.dtos.RoomateResponseDTO;
import edu.rico.roomates.model.entities.Roomate;
import edu.rico.roomates.repositories.IRoomateRepository;
import edu.rico.roomates.services.interfaces.IRoomateService;

@Service
public class RoomateServiceImpl implements IRoomateService {
    @Autowired
    private IRoomateRepository roomateRepo;

    @Override
    public RoomateResponseDTO guardar(RoomateRequestDTO dto) {
        // convertir el dto a entity
        Roomate r = new Roomate(dto.firstName(), dto.lastName(), dto.email(),
                dto.phone(), dto.password(), dto.gender(), dto.dateOfBirth());
        // guardar el entity
        // recoger el entity guardado que devuelve la bbdd y convertirlo a dto
        Roomate rSaved = roomateRepo.save(r);

        return new RoomateResponseDTO(rSaved.getId(), rSaved.getFirstName(), rSaved.getLastName(), rSaved.getEmail(),
                rSaved.getPhone(), rSaved.getGender(), rSaved.getDateOfBirth());
    }

    @Override
    public List<RoomateResponseDTO> obtenerTodos() {
        List<RoomateResponseDTO> listDTO = new ArrayList<>();
        List<Roomate> listEntities = roomateRepo.findAll();
        for (Roomate roomate : listEntities) {
            listDTO.add(new RoomateResponseDTO(roomate.getId(), roomate.getFirstName(), roomate.getLastName(),
                    roomate.getEmail(), roomate.getPhone(), roomate.getGender(), roomate.getDateOfBirth()));

        }
        return listDTO;
    }
}
