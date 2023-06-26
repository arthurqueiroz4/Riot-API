package org.Application.DTO;

import java.util.List;

public record TeamDTO(
        List<BanDTO> bans,
        ObjectivesDTO objectives,
        Integer teamId,
        boolean win
) {
}
