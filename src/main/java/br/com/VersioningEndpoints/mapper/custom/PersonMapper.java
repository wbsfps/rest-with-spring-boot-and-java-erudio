package br.com.VersioningEndpoints.mapper.custom;

import br.com.VersioningEndpoints.data.dto.v2.PersonDTOV2;
import br.com.VersioningEndpoints.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBirthDay(new Date());

        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 dto) {
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
//        entity.setBirthDay(new Date());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        return entity;
    }
}
