package dadeAndisheNiroo.equipment.service;

import dadeAndisheNiroo.equipment.model.EquipModel;
import dadeAndisheNiroo.equipment.repository.EquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipService {

    EquipRepository equipRepository;

    @Autowired
    public EquipService(EquipRepository equipRepository) {
        this.equipRepository = equipRepository;
    }

    public EquipModel saveEquip(EquipModel equipModel){
        return equipRepository.save(equipModel);
    }
}
