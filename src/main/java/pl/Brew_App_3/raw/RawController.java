package pl.Brew_App_3.raw;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RawController {
    private final RawService rawService;
    public static final Long EMPTY_ID = null;

    @GetMapping("raws")
    public Page<Raw> getRaws(Pageable pageable){
        return rawService.getRaws(pageable);
    }

    @GetMapping("raw/{id}")
    public Raw getRaw(@PathVariable Long id){
        return rawService.getRaw(id);
    }

    @PostMapping("raw")
    public Raw createRaw(@RequestBody RawDto rawDto){
        return rawService.createRaw(mapToRaw(rawDto, EMPTY_ID));
    }

    private Raw mapToRaw(RawDto rawDto, Long id) {
        return Raw.builder()
                .id(id)
                .typeRaw(rawDto.getTypeRaw())
                .build();
    }
}
