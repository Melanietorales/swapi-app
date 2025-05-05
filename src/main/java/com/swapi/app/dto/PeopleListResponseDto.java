package com.swapi.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PeopleListResponseDto {
    @Schema(example = "82", description = "Cantidad total de registros")
    private int totalRecords;
    @Schema(example = "9", description = "Cantidad total de páginas")
    private int totalPages;
    @Schema(example = "1", description = "Página actual")
    private int currentPage;
    @Schema(description = "Lista de personas")
    private List<PersonSummaryDto> results;
}
