package ru.belozerov.pastebox.repository;

import ru.belozerov.pastebox.model.PasteboxEntity;

import java.util.List;

public interface PasteboxRepository {
    PasteboxEntity getByHash(String hash);

    List<PasteboxEntity> getListOfPublicAndAlive(int amount);

    void add(PasteboxEntity pasteboxEntity);


}
