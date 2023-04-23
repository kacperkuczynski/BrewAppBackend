package pl.Brew_App_3.raw;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RawDto {
    private Long id;
    private String typeRaw;
}
