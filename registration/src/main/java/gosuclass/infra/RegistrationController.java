package gosuclass.infra;

import gosuclass.domain.*;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List; 

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping("/registrations")  // "/registrations" 엔드포인트 설정
@Transactional
public class RegistrationController {

    @Autowired
    RegistrationRepository registrationRepository;

     // classId로 Registration 검색
    @GetMapping("/class/{classId}")
    public List<Registration> getRegistrationsByClassId(@PathVariable Long classId) {
        return registrationRepository.findByClassId(classId);
    }

}
//>>> Clean Arch / Inbound Adaptor