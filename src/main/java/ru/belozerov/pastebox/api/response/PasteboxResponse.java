package ru.belozerov.pastebox.api.response;

import lombok.Data;
import ru.belozerov.pastebox.api.request.PublicStatus;

@Data
public class PasteboxResponse {
    private String data;
    private PublicStatus status;
}
