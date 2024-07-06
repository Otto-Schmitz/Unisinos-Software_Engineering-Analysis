import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.response.PatronDto;
import com.se.contracts.PatronInterface;

@RestController
@RequestMapping("/patron")
public class PatronController {

    @Autowired
    private PatronInterface patronInterface;

    @PostMapping
    private ResponseEntity<PatronDto> create(CreatePatronRequest request) {
        return patronInterface.create(request);
    }
}
