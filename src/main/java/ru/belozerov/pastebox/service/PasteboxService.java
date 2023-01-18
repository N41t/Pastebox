package ru.belozerov.pastebox.service;

import ru.belozerov.pastebox.api.request.PasteboxRequest;
import ru.belozerov.pastebox.api.response.PasteboxResponse;
import ru.belozerov.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPastebox(int amount);
    PasteboxUrlResponse create(PasteboxRequest request);
}
