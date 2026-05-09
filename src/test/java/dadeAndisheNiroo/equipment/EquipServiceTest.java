package dadeAndisheNiroo.equipment;

import dadeAndisheNiroo.equipment.model.EquipModel;
import dadeAndisheNiroo.equipment.repository.EquipRepository;
import dadeAndisheNiroo.equipment.service.EquipService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EquipServiceTest {

    @Mock
    EquipRepository equipRepository;

    @InjectMocks
    EquipService equipService;

    @Test
    void saveEquip() {
        EquipModel equipment= new EquipModel();
        equipment.setName("Boiler 2");
        when(equipRepository.save(any())).thenReturn(equipment);
        EquipModel result= equipService.saveEquip(equipment);
        assertEquals("Boiler 2", result.getName());
    }
}