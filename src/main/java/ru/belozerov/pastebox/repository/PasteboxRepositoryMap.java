package ru.belozerov.pastebox.repository;

import org.springframework.stereotype.Repository;
import ru.belozerov.pastebox.exception.NotFoundEntityException;
import ru.belozerov.pastebox.model.PasteboxEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PasteboxRepositoryMap implements PasteboxRepository{

    private final Map<String,PasteboxEntity> vault = new ConcurrentHashMap<>();

    // Hash lookup
    @Override
    public PasteboxEntity getByHash(String hash) {
        PasteboxEntity pasteboxEntity = vault.get(hash);

        if (pasteboxEntity == null) {
            throw new NotFoundEntityException("Pastebox not found with hash=" + hash);
        }
        return pasteboxEntity;
    }

    // Getting a list
    @Override
    public List<PasteboxEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime now = LocalDateTime.now();

        return vault.values().stream()
                .filter(PasteboxEntity::isPublic) // Only public
                .filter(pasteboxEntity -> pasteboxEntity.getLifetime().isBefore(now)) //Only living
                .sorted(Comparator.comparing(PasteboxEntity::getId).reversed()) // sorted by id
                .limit(amount)
                .collect(Collectors.toList());
    }

    // Save
    @Override
    public void add(PasteboxEntity pasteboxEntity) {
        vault.put(pasteboxEntity.getHash(), pasteboxEntity);
    }
}
