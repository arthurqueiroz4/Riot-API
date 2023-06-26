package org.Application.DTO;

import java.util.List;

public record PerksDTO(
        PerkStatsDTO statPerks,
        List<PerkStyleDTO> styles
) {
}
