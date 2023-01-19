package ru.belozerov.pastebox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.belozerov.pastebox.api.response.PasteboxResponse;
import ru.belozerov.pastebox.exception.NotFoundEntityException;
import ru.belozerov.pastebox.model.PasteboxEntity;
import ru.belozerov.pastebox.repository.PasteboxRepository;
import ru.belozerov.pastebox.service.PasteboxService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteboxServiceTest {
    @Autowired
    private PasteboxService pasteboxService;

    @MockBean
    private PasteboxRepository pasteboxRepository;
    @Test
    public void notExistHash() {
        assertThrows(NotFoundEntityException.class, () -> pasteboxService.getByHash("sdfsdfsd"));
    }

    @Test
    public void getExistHash() {
        PasteboxEntity entity = new PasteboxEntity();
        entity.setHash("1");
        entity.setData("11");
        entity.setPublic(true);

        when(pasteboxRepository.getByHash("1")).thenReturn(entity);

        PasteboxResponse expected = new PasteboxResponse("11", true);
        PasteboxResponse actual = pasteboxService.getByHash("1");

        assertEquals(expected, actual);
    }
}
