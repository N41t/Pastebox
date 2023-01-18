package ru.belozerov.pastebox.service;

import ru.belozerov.pastebox.api.request.PasteboxRequest;
import ru.belozerov.pastebox.api.response.PasteboxResponse;
import ru.belozerov.pastebox.api.response.PasteboxUrlResponse;

import java.util.List;

public class PasteboxServiceImpl implements PasteboxService{
    @Override
    public PasteboxResponse getByHash(String hash) {
        return null;
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPastebox(int amount) {
        return null;
    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {
        return null;
    }
}
