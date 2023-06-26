package org.Application.DTO;

import java.util.List;

public record PerkStyleDTO(
        String description,
        List<PerkStyleSelectionDTO> selections,
        Integer style
) {
}
