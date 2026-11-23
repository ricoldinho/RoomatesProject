package edu.rico.roomates.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rico.roomates.model.dtos.RoomateRequestDTO;
import edu.rico.roomates.model.dtos.RoomateResponseDTO;
import edu.rico.roomates.model.entities.Roomate;
import edu.rico.roomates.model.enums.Gender;
import edu.rico.roomates.repositories.IRoomateRepository;
import edu.rico.roomates.services.interfaces.IRoomateService;

@Service
public class RoomateServiceImpl implements IRoomateService {
    @Autowired
    private IRoomateRepository roomateRepo;

    @Override
    @Transactional
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
    @Transactional(readOnly = true)
    public List<RoomateResponseDTO> obtenerTodos() {
        List<RoomateResponseDTO> listDTO = new ArrayList<>();
        List<Roomate> listEntities = roomateRepo.findAll();
        for (Roomate roomate : listEntities) {
            listDTO.add(new RoomateResponseDTO(roomate.getId(), roomate.getFirstName(), roomate.getLastName(),
                    roomate.getEmail(), roomate.getPhone(), roomate.getGender(), roomate.getDateOfBirth()));

        }
        return listDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public RoomateResponseDTO obtenerPorId(Long id) {
        Optional<Roomate> opt = roomateRepo.findById(id);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("id no encontrado");
        }
        Roomate r = opt.get();
        return new RoomateResponseDTO(r.getId(), r.getFirstName(), r.getLastName(), r.getEmail(), r.getPhone(),
                r.getGender(), r.getDateOfBirth());
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) {
        boolean b = roomateRepo.existsById(id);
        if (b) {
            roomateRepo.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    @Transactional
    public RoomateResponseDTO actualizar(RoomateRequestDTO dto) {
        Roomate r = roomateRepo.findByEmail(dto.email());
        if (r == null) {
            throw new IllegalArgumentException("Email no encontrado");
        }
        r.setFirstName(dto.firstName());
        r.setLastName(dto.lastName());
        r.setPhone(dto.phone());
        r.setGender(dto.gender());
        r.setDateOfBirth(dto.dateOfBirth());
        r.setPassword(dto.password());

        Roomate rUpdated = roomateRepo.save(r);
        return new RoomateResponseDTO(rUpdated.getId(), rUpdated.getFirstName(), rUpdated.getLastName(),
                rUpdated.getEmail(), rUpdated.getPhone(), rUpdated.getGender(), rUpdated.getDateOfBirth());
    }

    @Override
    public List<RoomateResponseDTO> buscarPorGenero(Gender genero) {
        List<Roomate> listE = roomateRepo.findByGender(genero);
        List<RoomateResponseDTO> listDtos = new ArrayList<>();
        for (Roomate roomate : listE) {
            listDtos.add(new RoomateResponseDTO(roomate.getId(), roomate.getFirstName(), roomate.getLastName(),
                    roomate.getEmail(), roomate.getPhone(), genero, roomate.getDateOfBirth()));
        }
        return listDtos;
    }

}
