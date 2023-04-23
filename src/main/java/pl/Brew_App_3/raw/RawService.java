package pl.Brew_App_3.raw;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RawService {
    private final RawRepository rawRepository;

    public Page<Raw> getRaws(Pageable pageable) {
        return rawRepository.findAll(pageable);
    }

    public Raw getRaw(Long id) {
        return rawRepository.findById(id).orElseThrow();
    }

    public Raw createRaw(Raw raw) {
        return rawRepository.save(raw);
    }
}
