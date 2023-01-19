package ru.belozerov.pastebox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.belozerov.pastebox.api.request.PublicStatus;

@Data
@RequiredArgsConstructor
public class PasteboxResponse {
    private final String data;
    private final boolean isPublic;
}
