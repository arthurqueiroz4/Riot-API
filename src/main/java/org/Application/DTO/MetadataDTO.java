package org.Application.DTO;

import java.util.List;

public record MetadataDTO(
        String dataVersion,
        String matchId,
        List<String> participants
) {

}
